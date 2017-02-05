package com.bpham.easyjudge.repository;

import com.bpham.easyjudge.domain.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, String> {
    Event findByActiveTrue();
}
