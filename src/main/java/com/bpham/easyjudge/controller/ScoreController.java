package com.bpham.easyjudge.controller;

import com.bpham.easyjudge.domain.Score;
import com.bpham.easyjudge.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @CrossOrigin
    @RequestMapping(value = "api/score", method = RequestMethod.POST)
    public Score create(@RequestBody Score score) {
        return scoreService.save(score);
    }

    @CrossOrigin
    @RequestMapping(value = "api/score", method = RequestMethod.GET)
    public Iterable<Score> get(@RequestParam(value = "eventId", required = false) String eventId,
                               @RequestParam(value = "userId", required = false) String userId) {
        if (userId != null && eventId != null) {
            return scoreService.getByEventIdAndUserId(eventId, userId);
        } else if (eventId != null) {
            return scoreService.getByEventId(eventId);
        }
        return scoreService.getAll();
    }
}
