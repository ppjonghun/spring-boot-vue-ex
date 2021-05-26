package com.example.admin.service;

import com.example.admin.mapper.TwoidEventMapper;
import com.example.admin.utils.CommonUtil;
import com.example.admin.vo.TwoidEventInfo;
import com.example.admin.vo.TwoidEventInfoParam;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service // 비즈니스 로직이나 repository layer 호출하는 함수에 사용
@RequiredArgsConstructor
public class TwoidEventService {

    @Autowired
    private final TwoidEventMapper twoidEventMapper;

    public List<TwoidEventInfo> selectTwoidEventList(TwoidEventInfoParam.Select param){
        List<TwoidEventInfo> twoidEventInfoList = twoidEventMapper.selectTwoidEventList(param);
        twoidEventInfoList.stream().forEach(twoidEventInfo -> twoidEventInfo.setStatusCd(compareEventDate(twoidEventInfo)));

        return twoidEventInfoList;
    }

    public TwoidEventInfo selectTwoidEventOne(TwoidEventInfoParam.SelectOne param){
        return twoidEventMapper.selectTwoidEventOne(param);
    }

    public int insertTwoidEvent(TwoidEventInfoParam.Insert param){
        param.setEventId(createEventId());
        param.setCreateId("admin");
        param.setCreateDt(new Date());

        return twoidEventMapper.insertTwoidEvent(param);
    }

    public int updateTwoidEvent(TwoidEventInfoParam.Update param){
        param.setUpdateId("admin");
        param.setUpdateDt(new Date());

        return twoidEventMapper.updateTwoidEvent(param);
    }

    public int deleteTwoidEvent(TwoidEventInfoParam.Delete param){
        return twoidEventMapper.deleteTwoidEvent(param);
    }


    public String createEventId(){
        return LocalDateTime.now().format(CommonUtil.DEFAULT_DATETIME_FORMAT) + RandomStringUtils.randomNumeric(4);
    }

    public TwoidEventInfo.EventStatusCd compareEventDate(TwoidEventInfo event){
        LocalDate startDt = LocalDate.parse(event.getStartDt(), CommonUtil.DEFAULT_DATE_FORMAT);
        LocalDate endDt = LocalDate.parse(event.getEndDt(), CommonUtil.DEFAULT_DATE_FORMAT);
        LocalDate now = LocalDate.now();

        if(now.compareTo(startDt) >= 0 && now.compareTo(endDt) <= 0){
            return TwoidEventInfo.EventStatusCd.A;
        }else if(startDt.compareTo(now) < 0){
            return TwoidEventInfo.EventStatusCd.E;
        }else{
            return TwoidEventInfo.EventStatusCd.R;
        }
    }

}
