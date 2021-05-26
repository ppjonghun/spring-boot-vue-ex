package com.example.admin.mapper;

import com.example.admin.vo.TwoidEventInfo;
import com.example.admin.vo.TwoidEventInfoParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // 메서드명과 xml 파일의 id를 매핑
public interface TwoidEventMapper {

    List<TwoidEventInfo> selectTwoidEventList(TwoidEventInfoParam.Select param);
    TwoidEventInfo selectTwoidEventOne(TwoidEventInfoParam.SelectOne param);
    int insertTwoidEvent(TwoidEventInfoParam.Insert param);
    int updateTwoidEvent(TwoidEventInfoParam.Update param);
    int deleteTwoidEvent(TwoidEventInfoParam.Delete param);

}
