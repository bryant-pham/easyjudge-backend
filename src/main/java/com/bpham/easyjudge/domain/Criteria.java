package com.bpham.easyjudge.domain;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Criteria {
    private String text;
    private Short score;
}
