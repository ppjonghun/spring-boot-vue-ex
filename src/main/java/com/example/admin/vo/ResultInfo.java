package com.example.admin.vo;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data // @Getter + @Setter + @ToString + @EqualsAndHashCode + @RequiredArgsConstructor
      // @EqualsAndHashCode : equlas와 hashcode 메소드를 만들어 줌
      // @RequiredArgsConstructor : 초기화 되지않은 final 필드나, @NonNull 이 붙은 필드에 대해 생성자를 생성
public class ResultInfo {
    private String comment;
    private Object data;

}
