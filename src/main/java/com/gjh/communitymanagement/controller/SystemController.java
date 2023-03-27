package com.gjh.communitymanagement.controller;

import com.gjh.communitymanagement.common.Result;
import com.gjh.communitymanagement.common.StatusCode;
import com.gjh.communitymanagement.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author guojianhui
 * @ClassName: SystemController
 * @Version 1.0
 */
@RestController
@RequestMapping("/system")
public class SystemController {

    @Autowired
    private SystemService service;

    @RequestMapping("/get")
    public Result get(){
        Map<String, String> stringMap = service.get();
        return new Result(true, StatusCode.OK, "系统信息查询成功",stringMap);
    }
}
