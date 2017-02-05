package com.bpham.easyjudge.domain;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
public class Score {
    private String id;
    private String eventId;
    private List<Criteria> criteria;
    private String userId;
    private String projectNumber;
}
