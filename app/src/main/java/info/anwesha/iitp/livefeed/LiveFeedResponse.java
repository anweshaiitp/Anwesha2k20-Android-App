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

class NewsList {
    @SerializedName("news")
    private String news;
    @SerializedName("img")
    private String img;

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
