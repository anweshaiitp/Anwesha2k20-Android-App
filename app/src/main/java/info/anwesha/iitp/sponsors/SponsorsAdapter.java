package info.anwesha.iitp.sponsors;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import info.anwesha.iitp.R;
import info.anwesha.iitp.utils.IntentUtils;

public class SponsorsAdapter extends RecyclerView.Adapter<SponsorsAdapter.ViewHolder> {

    private Context context;
    private List<info.anwesha.iitp.sponsors.SponsorItem> sponsorItemList;

    public SponsorsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_sponsors, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        if (sponsorItemList != null) {
            final info.anwesha.iitp.sponsors.SponsorItem current = sponsorItemList.get(position);

            holder.name.setText(current.getName());
            holder.sponsor_name.setText(current.getSponsor_name());

            Glide.with(context)
                    .load(current.getImage())
                    .thumbnail(Glide.with(context).load(R.raw.load))
                    .into(holder.image);

            Log.e("image", current.getImage());

            holder.root.setOnClickListener(v -> {

                IntentUtils.openWebBrowser(context, current.getWebsite());
//                NavController navController = Navigation.findNavController((Activity) context, R.id.nav_host_fragment);
//                    navController.navigate(pair.getValue());
            });


        } else {
            holder.name.setText("Loading ...");
        }
    }

    @Override
    public int getItemCount() {
        if (sponsorItemList != null)
            return sponsorItemList.size();
        else return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        View root;
        TextView name;
        ImageView image;
        TextView sponsor_name;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            root = itemView.findViewById(R.id.cv_sponsors);
            image = itemView.findViewById(R.id.image);
            sponsor_name = itemView.findViewById(R.id.sponsor_name);
        }
    }

    void setSponsorItemList(List<SponsorItem> sponsors) {
        sponsorItemList = sponsors;
        notifyDataSetChanged();
    }
}
