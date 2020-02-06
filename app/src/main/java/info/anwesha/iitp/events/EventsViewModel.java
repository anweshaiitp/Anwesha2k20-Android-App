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
    private LiveData<List<String>> allCompetetions;
    private LiveData<List<String>> allEventsCategory;

    public EventsViewModel(@NonNull Application application) {
        super(application);
        eventsRepository = new EventsRepository(application);
        allEvents = eventsRepository.loadAllEvents();
        allClubs = eventsRepository.loadAllClubs();
        allCompetetions=eventsRepository.loadCompetetions();
        allEventsCategory=eventsRepository.loadEventsCategory();
    }

    LiveData<List<info.anwesha.iitp.events.EventItem>> loadAllEvents() {
        return allEvents;
    }

    public LiveData<List<String>> loadAllClubs() {
        return allClubs;
    }

    public LiveData<List<String>> loadCompetetionsCategory() {
        return allCompetetions;
    }

    public LiveData<List<String>> loadEventsCategory() {
        return allEventsCategory;
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
