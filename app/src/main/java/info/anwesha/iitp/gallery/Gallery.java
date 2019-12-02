package info.anwesha.iitp.gallery;

import androidx.annotation.Keep;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Keep
public class Gallery {

    @SerializedName("img")
    @Expose
    private List<info.anwesha.iitp.gallery.Image> image = null;

    public List<info.anwesha.iitp.gallery.Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }
}