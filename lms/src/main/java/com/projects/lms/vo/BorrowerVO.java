package com.projects.lms.vo;

import lombok.Data;

@Data
public class BorrowerVO {
    private Long cardId;
    private String ssn;
    private String borrowerName;
    private String address;
    private String phone;
}
