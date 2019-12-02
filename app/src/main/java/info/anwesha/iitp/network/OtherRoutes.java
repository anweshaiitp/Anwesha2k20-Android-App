package info.anwesha.iitp.network;

import info.anwesha.iitp.gallery.Gallery;
import retrofit2.Call;
import retrofit2.http.GET;

public interface OtherRoutes {

    @GET("gallery/gallery.json")
    Call<Gallery> getImages();

}
