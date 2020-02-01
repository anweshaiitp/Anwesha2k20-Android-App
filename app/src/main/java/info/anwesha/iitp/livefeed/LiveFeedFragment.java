package info.anwesha.iitp.livefeed;


import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import info.anwesha.iitp.R;
import info.anwesha.iitp.network.RetrofitClientInstance;
import info.anwesha.iitp.utils.CheckNetwork;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LiveFeedFragment extends Fragment {

    private LiveFeedAdapter adapter;
    private ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (!CheckNetwork.isNetworkConnected(requireContext())) {
            Toast.makeText(requireContext(), "No Internet Connection!!!", Toast.LENGTH_LONG).show();
            View rootView = inflater.inflate(R.layout.fragment_no_internet, container, false);
            return rootView;
        } else {
            View rootView = inflater.inflate(R.layout.fragment_live_feed, container, false);
            return rootView;
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!CheckNetwork.isNetworkConnected(requireContext()))
            Toast.makeText(getContext(), "Check your internet connection", Toast.LENGTH_LONG).show();
        else {
            RecyclerView recyclerView = view.findViewById(R.id.recycler_livefeed);
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));

            adapter = new LiveFeedAdapter(getContext());
            recyclerView.setAdapter(adapter);
            getLiveFeedData();
        }
    }

    void getLiveFeedData() {
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Getting Live Feeds");
        progressDialog.show();

        LiveFeedApi liveFeedApi = RetrofitClientInstance.getRetrofitInstance().create(LiveFeedApi.class);

        Call<LiveFeedResponse> call = liveFeedApi.getLiveFeed();

        call.enqueue(new Callback<LiveFeedResponse>() {
            @Override
            public void onResponse(Call<LiveFeedResponse> call, Response<LiveFeedResponse> response) {
                if (progressDialog != null) progressDialog.dismiss();

                if (response.isSuccessful() && response.body() != null) {
                    adapter.setNewsLists(response.body().getNewsLists());
                } else {
                    Log.e("Error", "onResponse Else: " + response.body());
                    Toast.makeText(getContext(), "Something went wrong!!!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LiveFeedResponse> call, Throwable t) {
                if (progressDialog != null) progressDialog.dismiss();
                Log.e("Error", "onFailure: " + t.getMessage());
                Toast.makeText(getContext(), "Something went wrong!!!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
