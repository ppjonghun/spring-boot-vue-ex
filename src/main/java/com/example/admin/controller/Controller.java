package com.example.admin.controller;

import com.example.admin.vo.ResultInfo;
import com.example.admin.vo.TwoidEventInfo;
import com.example.admin.vo.TwoidEventInfoParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @GetMapping("/index")
    public ResultInfo selectTwoidEventList(){

        return ResultInfo.builder().comment("켜짐").build();
    }
    
}
