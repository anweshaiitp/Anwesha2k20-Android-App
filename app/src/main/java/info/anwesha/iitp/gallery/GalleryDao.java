package info.anwesha.iitp.gallery;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface GalleryDao {

    @Query("SELECT * FROM Image")
    List<info.anwesha.iitp.gallery.Image> loadAllImages();

    @Insert(onConflict = REPLACE)
    void insertImage(info.anwesha.iitp.gallery.Image image);

    @Query("DELETE FROM Image")
    void deleteImages();

}
