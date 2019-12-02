package info.anwesha.iitp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import info.anwesha.iitp.events.EventItem;
import info.anwesha.iitp.events.EventsDao;
import info.anwesha.iitp.gallery.GalleryDao;
import info.anwesha.iitp.gallery.Image;
import info.anwesha.iitp.utils.Converters;

@Database(entities = {EventItem.class, Image.class}, version = 3, exportSchema = false)
@TypeConverters(Converters.class)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile info.anwesha.iitp.database.AppDatabase INSTANCE;

    public abstract EventsDao eventsDao();
    public abstract GalleryDao galleryDao();

    public static info.anwesha.iitp.database.AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (info.anwesha.iitp.database.AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            info.anwesha.iitp.database.AppDatabase.class, "database")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
