package com.gjh.communitymanagement.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gjh.communitymanagement.common.MessageConstant;
import com.gjh.communitymanagement.common.PageResult;
import com.gjh.communitymanagement.common.Result;
import com.gjh.communitymanagement.common.StatusCode;
import com.gjh.communitymanagement.domain.Activity;
import com.gjh.communitymanagement.domain.Complaint;
import com.gjh.communitymanagement.domain.Device;
import com.gjh.communitymanagement.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 设备表 前端控制器
 * </p>
 *
 * @author Guo Jianhui
 * @since 2023-02-08
 */
@RestController
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap) {
        IPage<Device> deviceIPage = deviceService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.COMMUNITY_SEARCH_SUCCESS, deviceIPage.getRecords(), deviceIPage.getTotal());
    }

    @PostMapping("/add")
    public Result add(@RequestBody Device device){
        Boolean add = deviceService.add(device);
        return new Result(add,StatusCode.OK,"");
    }

    @PostMapping("/update")
    public Result update(@RequestBody Device device){
        Boolean update = deviceService.update(device);
        return new Result(update,StatusCode.OK,"");
    }

    @GetMapping("/findById")
    public Result findById(Integer id){
        Device device = deviceService.findById(id);
        return new Result(true,StatusCode.OK,"",device);
    }

    @DeleteMapping ("/daleteById")
    public Result deleteById(@RequestParam Integer id){
        int i = deviceService.deleteById(id);
        return new Result(i > 0 ? true : false, StatusCode.OK, "");
    }
}

