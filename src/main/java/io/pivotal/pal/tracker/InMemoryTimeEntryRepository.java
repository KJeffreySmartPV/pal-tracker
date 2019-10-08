package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private Map<Long,TimeEntry> store = new HashMap<>();
    private long lastId = 0L;

    public TimeEntry create(TimeEntry timeEntry) {
        long id = lastId+1;
        lastId = id;
        TimeEntry newTimeEntry = new TimeEntry(id, timeEntry);
        store.put(id, newTimeEntry);
        return newTimeEntry;
    }

    public TimeEntry find(long timeEntryId) {
        return store.get(timeEntryId);
    }

    public List<TimeEntry> list() {
        return new ArrayList<>(store.values());
    }

    public TimeEntry update(long timeEntryId, TimeEntry timeEntry) {
        if (!store.containsKey(timeEntryId))
        {
            return null;
        }

        TimeEntry updatedTimeEntry = new TimeEntry(timeEntryId, timeEntry);
        store.replace(timeEntryId, updatedTimeEntry);
        return updatedTimeEntry;
    }

    public void delete(long timeEntryId) {
        if (store.containsKey(timeEntryId))
        {
            store.remove(timeEntryId);
        }
    }
}
