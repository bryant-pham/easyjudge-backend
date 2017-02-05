package com.bpham.easyjudge.service;

import com.bpham.easyjudge.domain.Event;
import com.bpham.easyjudge.domain.exception.EventNotFoundException;
import com.bpham.easyjudge.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {
    private EventRepository eventRepo;

    @Autowired
    public EventService(EventRepository eventRepo) {
        this.eventRepo = eventRepo;
    }

    public Iterable<Event> getAll() {
        return eventRepo.findAll();
    }

    public Event findById(String eventId) {
        Event event = eventRepo.findOne(eventId);
        if (event == null) {
            throw new EventNotFoundException(eventId);
        }
        return event;
    }

    public Event getActiveEvent() {
        return eventRepo.findByActiveTrue();
    }

    public Event create(Event event) {
        return eventRepo.save(event);
    }

    public Event update(String eventId, Event updateData) {
        Event originalEvent = eventRepo.findOne(eventId);
        if (originalEvent == null) {
            throw new EventNotFoundException(eventId);
        }
        Event updatedEvent = originalEvent.updateWith(updateData);
        deactivateOtherEventsIfEventActivated(originalEvent, updatedEvent);
        return eventRepo.save(updatedEvent);
    }

    public Boolean delete(String eventId) {
        Event eventToDelete = findById(eventId);
        eventRepo.delete(eventToDelete);
        return true;
    }

    public Iterable<Event> activateEvent(String eventId) {
        Iterable<Event> allEvents = getAll();
        List<Event> updatedEvents = new ArrayList<>();
        for (Event event : allEvents) {
            if (event.getId().equals(eventId)) {
                event.activate();
            } else {
                event.deactivate();
            }
            updatedEvents.add(event);
        }
        return eventRepo.save(updatedEvents);
    }

    private void deactivateOtherEventsIfEventActivated(Event originalEvent, Event updated) {
        if (hasToggledActive(originalEvent, updated)) {
            activateEvent(updated.getId());
        }
    }

    private Boolean hasToggledActive(Event original, Event updated) {
        return !original.getActive() && updated.getActive();
    }
}
