package info.anwesha.iitp.special;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.preference.PreferenceManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.card.MaterialCardView;

import java.util.List;

import info.anwesha.iitp.R;
import info.anwesha.iitp.events.EventItem;
import info.anwesha.iitp.events.EventsViewModel;
import info.anwesha.iitp.network.EventsRoutes;
import info.anwesha.iitp.network.RetrofitClientInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpecialCategoryFragment extends Fragment implements View.OnClickListener {

    public SpecialCategoryFragment() {
    }

    private SwipeRefreshLayout swipeRefreshLayout;

    private SharedPreferences preferences;

    private Context context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setEnterTransition(TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.fade));
        if (getContext() != null)
            this.context = getContext();
        else
            NavHostFragment.findNavController(this).navigateUp();

        preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_event_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_event_cat);
//        swipeRefreshLayout.setOnRefreshListener(this::updateData);

        if (preferences.getLong("last_event_update_time", 0) < System.currentTimeMillis() - 10 * 60 * 1000) {
//            swipeRefreshLayout.setRefreshing(true);
            updateData();
        }

        MaterialCardView schoolEvents = view.findViewById(R.id.card_school_events);
        MaterialCardView exhibitions = view.findViewById(R.id.card_exhibitions);
        MaterialCardView guestLectures = view.findViewById(R.id.card_lectures);
        MaterialCardView workshops = view.findViewById(R.id.card_workshops);
        MaterialCardView ozone = view.findViewById(R.id.card_ozone);

//        schoolEvents.setOnClickListener(this);
        //      exhibitions.setOnClickListener(this);
        //    guestLectures.setOnClickListener(this);
        //  workshops.setOnClickListener(this);
        //  ozone.setOnClickListener(this);


        super.onViewCreated(view, savedInstanceState);
    }

    private void updateData() {

        info.anwesha.iitp.events.EventsViewModel viewModel = ViewModelProviders.of(this).get(EventsViewModel.class);
        info.anwesha.iitp.network.EventsRoutes service = RetrofitClientInstance.getRetrofitInstance().create(EventsRoutes.class);

        Call<List<info.anwesha.iitp.events.EventItem>> call = service.getAllEvents();

        call.enqueue(new Callback<List<info.anwesha.iitp.events.EventItem>>() {
            @Override
            public void onResponse(@NonNull Call<List<info.anwesha.iitp.events.EventItem>> call, @NonNull Response<List<info.anwesha.iitp.events.EventItem>> response) {
                if (response.isSuccessful()) {

                    viewModel.deleteEvents();

                    List<info.anwesha.iitp.events.EventItem> allItems = response.body();

                    if (allItems != null && allItems.size() > 0) {
                        for (info.anwesha.iitp.events.EventItem newItem : allItems) {
                            viewModel.insert(newItem);
                        }
                    }

                    preferences.edit().putLong("last_event_update_time", System.currentTimeMillis()).apply();

                } else {
                    Log.e(getClass().getSimpleName(), "no data");
                }

                if (swipeRefreshLayout != null)
                    swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(@NonNull Call<List<EventItem>> call, @NonNull Throwable t) {
                Log.e(getClass().getSimpleName(), t.getMessage());
                if (swipeRefreshLayout != null)
                    swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void onClick(View view) {

        Bundle b = new Bundle();

        switch (view.getId()) {

            case R.id.card_school_events:
                b.putString("data", "Schoolevents");
                break;
            case R.id.card_exhibitions:
                b.putString("data", "Exhibitions");
                break;
            case R.id.card_lectures:
                b.putString("data", "Guesttalks");
                break;
            case R.id.card_workshops:
                b.putString("data", "Workshops");
                break;
            case R.id.card_ozone:
                b.putString("data", "Ozone");
                break;

        }

        if (b.containsKey("data")) {
            Navigation.findNavController(view).navigate(R.id.nav_special_events, b);
        }
    }
}
