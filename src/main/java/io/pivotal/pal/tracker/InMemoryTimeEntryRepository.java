package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    Map<Long, TimeEntry> timeEntryMap = new HashMap<>();

    private Long currentId = 1L;

    public TimeEntry create(final TimeEntry timeEntry) {
        final Long id = currentId++;

        TimeEntry newTimeEntry = new TimeEntry(
                id,
                timeEntry.getProjectId(),
                timeEntry.getUserId(),
                timeEntry.getDate(),
                timeEntry.getHours()
        );
        timeEntryMap.put(id, newTimeEntry);
        return newTimeEntry;
    }

    public TimeEntry find(Long id) {
        return timeEntryMap.get(id);
    }

    public List<TimeEntry> list() {
        return new ArrayList(timeEntryMap.values());
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

        timeEntryMap.replace(id, timeEntry);
        return updatedEntry;
    }

    public void delete(Long id) {
        timeEntryMap.remove(id);
    }

}
