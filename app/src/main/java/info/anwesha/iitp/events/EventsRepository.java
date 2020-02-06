package info.anwesha.iitp.events;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import info.anwesha.iitp.database.AppDatabase;

public class EventsRepository {

    private info.anwesha.iitp.events.EventsDao eventsDao;
    private LiveData<List<info.anwesha.iitp.events.EventItem>> allEvents;
    private LiveData<List<info.anwesha.iitp.events.EventItem>> allExhibitions;
    private LiveData<List<info.anwesha.iitp.events.EventItem>> allSchoolEvents;
    private LiveData<List<info.anwesha.iitp.events.EventItem>> allOzoneEvents;
    private LiveData<List<info.anwesha.iitp.events.EventItem>> allLectures;
    private LiveData<List<info.anwesha.iitp.events.EventItem>> allWorkshops;
    private LiveData<List<String>> allClubs;
    private LiveData<List<String>> allCompetetions;
    private LiveData<List<String>> allEventsCategory;

    public EventsRepository(Application application) {
        info.anwesha.iitp.database.AppDatabase db = AppDatabase.getDatabase(application);
        eventsDao = db.eventsDao();
        allEvents = eventsDao.loadAllEvents();
        allExhibitions = eventsDao.loadAllExhibitions();
        allSchoolEvents = eventsDao.loadAllSchoolEvents();
        allOzoneEvents = eventsDao.loadOzoneEvents();
        allLectures = eventsDao.loadGuestTalks();
        allWorkshops = eventsDao.loadWorkshops();
        allClubs = eventsDao.loadAllClubs();
        allCompetetions = eventsDao.loadCompetetionsCategory();
        allEventsCategory=eventsDao.loadEventsCategory();
    }

    public LiveData<List<info.anwesha.iitp.events.EventItem>> loadAllEvents() {
        return allEvents;
    }
    public LiveData<List<info.anwesha.iitp.events.EventItem>> loadAllExhibitions() {
        return allExhibitions;
    }
    public LiveData<List<info.anwesha.iitp.events.EventItem>> loadAllSchoolEvents() {
        return allSchoolEvents;
    }
    public LiveData<List<info.anwesha.iitp.events.EventItem>> loadAllOzoneEvents() {
        return allOzoneEvents;
    }
    public LiveData<List<info.anwesha.iitp.events.EventItem>> loadAllWorkshops() {
        return allWorkshops;
    }
    public LiveData<List<info.anwesha.iitp.events.EventItem>> loadAllLectures() {
        return allLectures;
    }

    public LiveData<List<String>> loadAllClubs() {
        return allClubs;
    }

    public LiveData<List<String>> loadCompetetions() {
        return allCompetetions;
    }

    public LiveData<List<String>> loadEventsCategory() {
        return allEventsCategory;
    }

    public void insert(info.anwesha.iitp.events.EventItem eventItem) {
        new insertAsyncTask(eventsDao).execute(eventItem);
    }

    public info.anwesha.iitp.events.EventItem loadEventById(String id) {
        getEventById task = new getEventById(eventsDao);
        try {
            return task.execute(id).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteEvents() {
        deleteEventsTask task = new deleteEventsTask(eventsDao);
        task.execute();
    }

    private static class insertAsyncTask extends AsyncTask<info.anwesha.iitp.events.EventItem, Void, Void> {
        private info.anwesha.iitp.events.EventsDao mAsyncTaskDao;

        insertAsyncTask(info.anwesha.iitp.events.EventsDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final info.anwesha.iitp.events.EventItem... params) {
            mAsyncTaskDao.insertEvent(params[0]);
            return null;
        }
    }

    private static class getEventById extends AsyncTask<String, Void, info.anwesha.iitp.events.EventItem> {
        private info.anwesha.iitp.events.EventsDao mAsyncTaskDao;

        getEventById(info.anwesha.iitp.events.EventsDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected EventItem doInBackground(String... params) {
            return mAsyncTaskDao.loadEventById(params[0]);
        }
    }

    private static class deleteEventsTask extends AsyncTask<Void, Void, Void> {
        private info.anwesha.iitp.events.EventsDao mAsyncTaskDao;

        deleteEventsTask(EventsDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Void... params) {
            mAsyncTaskDao.deleteAllEvents();
            return null;
        }
    }

}
