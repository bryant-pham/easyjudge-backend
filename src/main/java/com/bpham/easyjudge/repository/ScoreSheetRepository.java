package com.bpham.easyjudge.repository;

import com.bpham.easyjudge.domain.Score;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreSheetRepository extends CrudRepository<Score, String> {
    List<Score> findByEventIdAndUserId(String eventId, String userId);
    List<Score> findByEventId(String eventId);
}
