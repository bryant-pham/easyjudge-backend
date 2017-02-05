package com.bpham.easyjudge.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
@AllArgsConstructor
public class Event {
    private String id;
    private String name;
    private List<Criteria> criteria;
    private String organization;
    private Boolean active;

    public Event updateWith(Event event) {
        return new Event(this.id, event.getName(), event.getCriteria(),
                event.getOrganization(), event.getActive());
    }

    public void activate() {
        this.active = true;
    }

    public void deactivate() {
        this.active = false;
    }
}
