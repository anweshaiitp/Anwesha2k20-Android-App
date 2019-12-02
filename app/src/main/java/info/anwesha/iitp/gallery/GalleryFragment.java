package info.anwesha.iitp.gallery;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.List;
import java.util.concurrent.ExecutionException;

import info.anwesha.iitp.R;
import info.anwesha.iitp.database.AppDatabase;
import info.anwesha.iitp.network.OtherRoutes;
import info.anwesha.iitp.network.RetrofitClientInstance;
import info.anwesha.iitp.utils.ImageViewerActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GalleryFragment extends Fragment implements info.anwesha.iitp.gallery.GalleryAdapter.OnImageSelectedListener {

    public GalleryFragment() {
    }

    private SwipeRefreshLayout swipeRefreshLayout;
    private Context context;
    private info.anwesha.iitp.gallery.GalleryAdapter adapter;
    private info.anwesha.iitp.gallery.GalleryDao dao;
    private SharedPreferences preferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getContext() != null)
            this.context = getContext();
        else
            NavHostFragment.findNavController(this).navigateUp();

        setEnterTransition(TransitionInflater.from(context).inflateTransition(android.R.transition.fade));

        dao = AppDatabase.getDatabase(context).galleryDao();
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gallery, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_gallery);
        swipeRefreshLayout.setOnRefreshListener(this::updateData);

        if (preferences.getLong("last_gallery_update_time", 0) < System.currentTimeMillis() - 10 * 60 * 1000) {
            swipeRefreshLayout.setRefreshing(true);
            updateData();
        }

        RecyclerView recyclerView = view.findViewById(R.id.recycler_gallery);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));

        adapter = new GalleryAdapter(context, this);
        recyclerView.setAdapter(adapter);

        populateData();

        super.onViewCreated(view, savedInstanceState);
    }

    private void populateData() {

        try {
            List<info.anwesha.iitp.gallery.Image> allImages = new GetImagesTask(dao).execute().get();
            adapter.setImageList(allImages);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void updateData() {

        info.anwesha.iitp.network.OtherRoutes service = RetrofitClientInstance.getRetrofitInstance().create(OtherRoutes.class);

        Call<info.anwesha.iitp.gallery.Gallery> call = service.getImages();

        call.enqueue(new Callback<info.anwesha.iitp.gallery.Gallery>() {
            @Override
            public void onResponse(@NonNull Call<info.anwesha.iitp.gallery.Gallery> call, @NonNull Response<info.anwesha.iitp.gallery.Gallery> response) {
                if (response.isSuccessful()) {

                    info.anwesha.iitp.gallery.Gallery gallery = response.body();

                    if (gallery != null && gallery.getImage() != null) {
                        new DeleteImagesTask(dao).execute();

                        for (info.anwesha.iitp.gallery.Image image : gallery.getImage())
                            new InsertImageTask(dao).execute(image);

                        populateData();

                        preferences.edit().putLong("last_gallery_update_time", System.currentTimeMillis()).apply();
                    }

                } else {
                    Log.e(getClass().getSimpleName(), "no data");
                }

                if (swipeRefreshLayout != null) swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(@NonNull Call<Gallery> call, @NonNull Throwable t) {
                Log.e(getClass().getSimpleName(), "f, load failed");
                if (swipeRefreshLayout != null) swipeRefreshLayout.setRefreshing(false);
            }
        });

    }

    @Override
    public void onEventSelected(String reduced, String url) {
        Intent i = new Intent(context, ImageViewerActivity.class);
        i.putExtra("image_url", url);
        i.putExtra("image_reduced", reduced);
        startActivity(i);
    }


    private static class InsertImageTask extends AsyncTask<info.anwesha.iitp.gallery.Image, Void, Void> {
        private info.anwesha.iitp.gallery.GalleryDao mAsyncTaskDao;

        InsertImageTask(info.anwesha.iitp.gallery.GalleryDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final info.anwesha.iitp.gallery.Image... params) {
            mAsyncTaskDao.insertImage(params[0]);
            return null;
        }
    }

    private static class GetImagesTask extends AsyncTask<Void, Void, List<info.anwesha.iitp.gallery.Image>> {
        private info.anwesha.iitp.gallery.GalleryDao mAsyncTaskDao;

        GetImagesTask(info.anwesha.iitp.gallery.GalleryDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected List<Image> doInBackground(Void... params) {
            return mAsyncTaskDao.loadAllImages();
        }
    }

    private static class DeleteImagesTask extends AsyncTask<Void, Void, Void> {
        private info.anwesha.iitp.gallery.GalleryDao mAsyncTaskDao;

        DeleteImagesTask(GalleryDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Void... params) {
            mAsyncTaskDao.deleteImages();
            return null;
        }
    }


}
