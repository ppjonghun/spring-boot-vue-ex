package com.example.admin.controller;

import com.example.admin.service.TwoidEventService;
import com.example.admin.vo.ResultInfo;
import com.example.admin.vo.TwoidEventInfo;
import com.example.admin.vo.TwoidEventInfoParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // JSP와 같은 뷰를 만들어 내지 않는 대신 데이터자체를 반환(단순문자열, JSON, XML....)
@RequestMapping("/twoidEvent")  // URL을 매핑
@RequiredArgsConstructor    // 초기화 되지않은 final 필드나, @NonNull 이 붙은 필드에 대해 생성자를 생성. 주로 의존성 주입(Dependency Injection) 편의성을 위해서 사용.
@CrossOrigin    // 붙여주면 기본적으로 '모든 도메인, 모든 요청방식'에 대해 허용한다는 뜻
public class TwoidEventController {

    @Autowired // 상황의 타입에 맞게 자동으로 IoC(Inversion of Control) 컨테이너 안에 존재하는 Bean 주입
    TwoidEventService twoidEventService;

    // @PostMapping == @RequestMapping(method = RequestMethod.POST)
    // @RequestBody = HTTP Body에 담긴 데이터를 매핑하여 가지고 옴

    @PostMapping("/selectTwoidEventList")
    public ResultInfo selectTwoidEventList(@RequestBody TwoidEventInfoParam.Select param){
        List<TwoidEventInfo> twoidEventInfoList = twoidEventService.selectTwoidEventList(param);

        return ResultInfo.builder().comment("목록 조회").data(twoidEventInfoList).build();
    }

    @PostMapping("/selectTwoidEventOne")
    public ResultInfo selectTwoidEventOne(@RequestBody TwoidEventInfoParam.SelectOne param){
        TwoidEventInfo twoidEventInfo = twoidEventService.selectTwoidEventOne(param);

        return ResultInfo.builder().comment("하나만 조회").data(twoidEventInfo).build();
    }

    @PostMapping("/insertTwoidEvent")
    public ResultInfo insertTwoidEvent(@RequestBody TwoidEventInfoParam.Insert param){
        int result = twoidEventService.insertTwoidEvent(param);

        return ResultInfo.builder().comment(result + "건 등록").build();
    }

    @PostMapping("/updateTwoidEvent")
    public ResultInfo updateTwoidEvent(@RequestBody TwoidEventInfoParam.Update param){
        int result = twoidEventService.updateTwoidEvent(param);
        return ResultInfo.builder().comment(result + " 업데이트").build();
    }
    
    @PostMapping("/deleteTwoidEvent")
    public ResultInfo deleteTwoudEvent(@RequestBody TwoidEventInfoParam.Delete param){
        int result = twoidEventService.deleteTwoidEvent(param);
        return ResultInfo.builder().comment(result + " 삭제").build();
    }
}
