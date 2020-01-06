package info.anwesha.iitp.events;

import android.content.Context;
import android.os.Bundle;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.fragment.NavHostFragment;

import info.anwesha.iitp.R;

//import android.util.Log;
//import androidx.preference.PreferenceManager;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
//import java.util.ArrayList;
//import java.util.List;
//import info.anwesha.iitp.network.EventsRoutes;
//import info.anwesha.iitp.network.RetrofitClientInstance;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;

public class EventsFragment extends Fragment {

    private static final String ARG_PARAM1 = "data";

    private String club;
    //private info.anwesha.iitp.events.EventsRecyclerAdapter adapter;
    private info.anwesha.iitp.events.EventsViewModel viewModel;
    //private SwipeRefreshLayout swipeRefreshLayout;
    private Context context;

    public EventsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            club = getArguments().getString(ARG_PARAM1);
        }
        viewModel = ViewModelProviders.of(this).get(EventsViewModel.class);

        if (getContext() != null)
            this.context = getContext();
        else
            NavHostFragment.findNavController(this).navigateUp();

        setEnterTransition(TransitionInflater.from(context).inflateTransition(android.R.transition.fade));
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_events, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        if (getActivity() != null)
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(club + " Events");

        //swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_events);
      /*  swipeRefreshLayout.setOnRefreshListener(this::updateData);

        //RecyclerView recyclerView = view.findViewById(R.id.rv_feed_single_type);
        //recyclerView.setLayoutManager(new LinearLayoutManager(context));

        adapter = new info.anwesha.iitp.events.EventsRecyclerAdapter(context, (EventsRecyclerAdapter.OnEventSelectedListener) context);
        recyclerView.setAdapter(adapter);

        observeAll();
*/
        super.onViewCreated(view, savedInstanceState);
    }
/*
    private void observeAll() {
        viewModel.loadAllEvents().observe(this, eventItems -> {
            List<info.anwesha.iitp.events.EventItem> newList = new ArrayList<>();
            for (info.anwesha.iitp.events.EventItem n : eventItems) {
                if (n.getEvClub().equals(club)) newList.add(n);
            }
            adapter.setEventItemList(newList);
        });

    }

    private void updateData() {

        info.anwesha.iitp.network.EventsRoutes service = RetrofitClientInstance.getRetrofitInstance().create(EventsRoutes.class);

        Call<List<info.anwesha.iitp.events.EventItem>> call = service.getAllEvents();

        call.enqueue(new Callback<List<info.anwesha.iitp.events.EventItem>>() {
            @Override
            public void onResponse(@NonNull Call<List<info.anwesha.iitp.events.EventItem>> call, @NonNull Response<List<info.anwesha.iitp.events.EventItem>> response) {
                if (viewModel != null) {
                    if (response.isSuccessful()) {
                        viewModel.deleteEvents();

                        List<info.anwesha.iitp.events.EventItem> allItems = response.body();

                        if (allItems != null && allItems.size() > 0) {
                            for (info.anwesha.iitp.events.EventItem newItem : allItems) {
                                viewModel.insert(newItem);
                            }
                        }

                        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("last_event_update_time", System.currentTimeMillis()).apply();

                    } else {
                        Log.e(getClass().getSimpleName(), "no data");
                    }
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
  */
}
