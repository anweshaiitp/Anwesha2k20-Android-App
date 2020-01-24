package info.anwesha.iitp.livefeed;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LiveFeedResponse {
    @SerializedName("news")
    private List<NewsList> newsLists;

    public List<NewsList> getNewsLists() {
        return newsLists;
    }

    public void setNewsLists(List<NewsList> newsLists) {
        this.newsLists = newsLists;
    }
}

