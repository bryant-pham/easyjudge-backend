package com.bpham.easyjudge.domain.exception;

public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(String eventId) {
        super(String.format("Event with id %s not found", eventId));
    }
}
