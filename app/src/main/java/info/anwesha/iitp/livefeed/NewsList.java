package info.anwesha.iitp.livefeed;

import com.google.gson.annotations.SerializedName;

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