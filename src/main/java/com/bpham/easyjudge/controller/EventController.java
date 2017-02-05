package com.bpham.easyjudge.controller;

import com.bpham.easyjudge.domain.Event;
import com.bpham.easyjudge.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @CrossOrigin
    @RequestMapping(value = "/api/event", method = RequestMethod.GET)
    public Iterable<Event> getAll() {
        return eventService.getAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/api/event", method = RequestMethod.POST)
    public Event create(@RequestBody Event event) {
        return eventService.create(event);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/event/{eventId}", method = RequestMethod.PUT)
    public Event update(@PathVariable String eventId, @RequestBody Event event) {
        return eventService.update(eventId, event);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/event/{eventId}", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable String eventId) {
        return eventService.delete(eventId);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/event/active", method = RequestMethod.GET)
    public Event getActive() {
        return eventService.getActiveEvent();
    }
}
