package com.example.admin.vo;

import lombok.*;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class TwoidEventInfoParam {

    @Getter
    @Setter
    @Builder // 객체를 안전하게 생성
    @AllArgsConstructor // 모든필드에 대한 생성자 생성
    @NoArgsConstructor // 파라미터가 없는 생성자 생성
    public static class Select {

        @NotNull
        @NotEmpty
        String offset;

        @NotNull
        @NotEmpty
        String limit;

        public String getOffset() {
            return StringUtils.isEmpty(offset) ? "0" : offset;
        }

        public String getLimit() {
            return StringUtils.isEmpty(limit) ? "10" : limit;
        }

        @Override
        public String toString() {
            return "Select{" +
                    "offset='" + offset + '\'' +
                    ", limit='" + limit + '\'' +
                    '}';
        }
    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SelectOne{
        @NotEmpty
        @NotNull
        private String eventId;
    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Insert {
        private String eventId;

        @NotEmpty
        @NotNull
        private String startDt;

        @NotEmpty
        @NotNull
        private String endDt;

        @NotEmpty
        @NotNull
        private String eventNm;

        private String createId;
        private Date createDt;

    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Update{
        @NotNull
        @NotEmpty
        private String eventId;
        private String startDt;
        private String endDt;
        private String eventNm;
        private String updateId;
        private Date updateDt;
    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Delete{
        @NotNull
        @NotEmpty
        private String eventId;
    }

}
