package info.anwesha.iitp.special;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import info.anwesha.iitp.events.EventItem;
import info.anwesha.iitp.events.EventsRepository;

public class SpecialViewModel extends AndroidViewModel {

    private info.anwesha.iitp.events.EventsRepository eventsRepository;
    private LiveData<List<info.anwesha.iitp.events.EventItem>> allExhibitions;
    private LiveData<List<info.anwesha.iitp.events.EventItem>> allOzoneEvents;
    private LiveData<List<info.anwesha.iitp.events.EventItem>> allLectures;
    private LiveData<List<info.anwesha.iitp.events.EventItem>> allSchoolEvents;
    private LiveData<List<info.anwesha.iitp.events.EventItem>> allWorkshops;

    public SpecialViewModel(@NonNull Application application) {
        super(application);
        eventsRepository = new EventsRepository(application);
        allExhibitions = eventsRepository.loadAllExhibitions();
        allLectures = eventsRepository.loadAllLectures();
        allOzoneEvents = eventsRepository.loadAllOzoneEvents();
        allSchoolEvents = eventsRepository.loadAllSchoolEvents();
        allWorkshops = eventsRepository.loadAllWorkshops();
    }

    LiveData<List<info.anwesha.iitp.events.EventItem>> loadAllExhibitions() {
        return allExhibitions;
    }
    LiveData<List<info.anwesha.iitp.events.EventItem>> loadAllGuestLectures() {
        return allLectures;
    }
    LiveData<List<info.anwesha.iitp.events.EventItem>> loadAllOzoneEvents() {
        return allOzoneEvents;
    }
    LiveData<List<info.anwesha.iitp.events.EventItem>> loadAllSchoolEvents() {
        return allSchoolEvents;
    }
    LiveData<List<info.anwesha.iitp.events.EventItem>> loadAllWorkshops() {
        return allWorkshops;
    }

    public void insert(EventItem eventItem) {
        eventsRepository.insert(eventItem);
    }

    public void deleteEvents() {
        eventsRepository.deleteEvents();
    }

}
