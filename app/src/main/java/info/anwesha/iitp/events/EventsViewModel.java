package info.anwesha.iitp.events;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class EventsViewModel extends AndroidViewModel {

    private info.anwesha.iitp.events.EventsRepository eventsRepository;
    private LiveData<List<info.anwesha.iitp.events.EventItem>> allEvents;
    private LiveData<List<String>> allClubs;

    public EventsViewModel(@NonNull Application application) {
        super(application);
        eventsRepository = new EventsRepository(application);
        allEvents = eventsRepository.loadAllEvents();
        allClubs = eventsRepository.loadAllClubs();
    }

    LiveData<List<info.anwesha.iitp.events.EventItem>> loadAllEvents() {
        return allEvents;
    }

    public LiveData<List<String>> loadAllClubs() {
        return allClubs;
    }

    public void insert(info.anwesha.iitp.events.EventItem eventItem) {
        eventsRepository.insert(eventItem);
    }

    public EventItem getEventById(String id) {
        return eventsRepository.loadEventById(id);
    }

    public void deleteEvents() {
        eventsRepository.deleteEvents();
    }

}
