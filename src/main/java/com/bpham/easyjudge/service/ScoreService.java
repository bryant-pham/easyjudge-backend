package com.bpham.easyjudge.service;

import com.bpham.easyjudge.domain.Score;
import com.bpham.easyjudge.repository.ScoreSheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {
    private ScoreSheetRepository scoreSheetRepo;

    @Autowired
    public ScoreService(ScoreSheetRepository scoreSheetRepo) {
        this.scoreSheetRepo = scoreSheetRepo;
    }

    public Score save(Score score) {
        return scoreSheetRepo.save(score);
    }

    public List<Score> getByEventIdAndUserId(String eventId, String userId) {
        return scoreSheetRepo.findByEventIdAndUserId(eventId, userId);
    }

    public List<Score> getByEventId(String eventId) {
        return scoreSheetRepo.findByEventId(eventId);
    }

    public Iterable<Score> getAll() {
        return scoreSheetRepo.findAll();
    }
}
