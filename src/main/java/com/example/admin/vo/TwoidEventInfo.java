package com.example.admin.vo;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder // 객체를 안전하게 생성
@AllArgsConstructor // 모든필드에 대한 생성자 생성
@NoArgsConstructor // 파라미터가 없는 생성자 생성
@ToString
public class TwoidEventInfo {

    private String eventId;
    private String startDt;
    private String endDt;
    private String eventNm;
    private EventStatusCd statusCd;
    private String createId;
    private Date createDt;
    private String updateId;
    private Date updateDt;
    private String totalCount;

    public enum EventStatusCd{
        R,
        A,
        E
    }

}
