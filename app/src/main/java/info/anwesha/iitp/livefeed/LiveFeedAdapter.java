package info.anwesha.iitp.livefeed;

import android.content.Context;
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

public class LiveFeedAdapter extends RecyclerView.Adapter<LiveFeedAdapter.ViewHolder> {
    private Context context;
    private List<LiveFeedResponse> liveFeedResponsesList;
    private List<NewsList> newsLists;

    public LiveFeedAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public LiveFeedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_livefeed, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LiveFeedAdapter.ViewHolder holder, int position) {
//        if (liveFeedResponsesList != null) {
//            LiveFeedResponse response = liveFeedResponsesList.get(position);
//            holder.news.setText(response.getNewsLists().get(position).getNews());
//
//            Glide.with(context)
//                    .load(response.getNewsLists().get(position).getImg())
//                    .thumbnail(Glide.with(context).load(R.raw.load))
//                    .into(holder.img);
//
//        }
        if (newsLists != null) {
            NewsList newsList = newsLists.get(position);
            holder.news.setText(newsList.getNews());

            if (newsList.getImg().equals("")) {
                Glide.with(context)
                        .load(R.drawable.logo)
                        .thumbnail(Glide.with(context).load(R.raw.load))
                        .into(holder.img);
            } else {
                Glide.with(context)
                        .load(newsList.getImg())
                        .thumbnail(Glide.with(context).load(R.raw.load))
                        .into(holder.img);
            }
        }
    }

    @Override
    public int getItemCount() {
//        if (liveFeedResponsesList != null)
//            return liveFeedResponsesList.size();
//        else
//            return 0;
        if (newsLists != null)
            return newsLists.size();
        else
            return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView news;
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            news = itemView.findViewById(R.id.livefeed_news);
            img = itemView.findViewById(R.id.livefeed_image);
        }
    }

    void setLiveFeedResponsesList(List<LiveFeedResponse> responses) {
        liveFeedResponsesList = responses;
        notifyDataSetChanged();
    }

    void setNewsLists(List<NewsList> list) {
        newsLists = list;
        notifyDataSetChanged();
    }

}
