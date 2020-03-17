package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    HashMap<Long, TimeEntry> timeEntries = new HashMap<>();

    private Long currentId = 1L;

    public TimeEntry create(final TimeEntry timeEntry) {
        Long id = currentId++;

        TimeEntry newTimeEntry = new TimeEntry(
                id,
                timeEntry.getProjectId(),
                timeEntry.getUserId(),
                timeEntry.getDate(),
                timeEntry.getHours()
        );
        timeEntries.put(id, newTimeEntry);
        return newTimeEntry;
    }

    public TimeEntry find(Long id) {
        return timeEntries.get(id);
    }

    public List<TimeEntry> list() {
        return new ArrayList<>(timeEntries.values());
    }

    public TimeEntry update(Long id, TimeEntry timeEntry) {
        if (find(id) == null) return null;

        TimeEntry updatedEntry = new TimeEntry(
                id,
                timeEntry.getProjectId(),
                timeEntry.getUserId(),
                timeEntry.getDate(),
                timeEntry.getHours()
        );

        timeEntries.replace(id, timeEntry);
        return updatedEntry;
    }

    public void delete(Long id) {
        timeEntries.remove(id);
    }

}
