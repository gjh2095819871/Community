package com.gjh.communitymanagement.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gjh.communitymanagement.common.MessageConstant;
import com.gjh.communitymanagement.common.PageResult;
import com.gjh.communitymanagement.common.Result;
import com.gjh.communitymanagement.common.StatusCode;
import com.gjh.communitymanagement.domain.Parking;
import com.gjh.communitymanagement.domain.ParkingUse;
import com.gjh.communitymanagement.service.ParkinguseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 车位使用表 前端控制器
 * </p>
 *
 * @author Guo Jianhui
 * @since 2023-02-08
 */
@RestController
@RequestMapping("/parkinguse")
public class ParkingUseController {

    @Autowired
    private ParkinguseService parkinguseService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap) {
        IPage<ParkingUse> parkingUseIPage = parkinguseService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.COMMUNITY_SEARCH_SUCCESS, parkingUseIPage.getRecords(), parkingUseIPage.getTotal());
    }

    @PostMapping("/add")
    public Result add(@RequestBody ParkingUse parkingUse){
        Boolean add = parkinguseService.add(parkingUse);
        return new Result(add,StatusCode.OK,"");
    }

    @PostMapping("/update")
    public Result update(@RequestBody ParkingUse parkingUse){
        Boolean update = parkinguseService.update(parkingUse);
        return new Result(update,StatusCode.OK,"");
    }

    @GetMapping("/findById")
    public Result findById(Integer id){
        ParkingUse parkingUse = parkinguseService.findById(id);
        return new Result(true,StatusCode.OK,"",parkingUse);
    }

    @DeleteMapping ("/daleteById")
    public Result deleteById(@RequestParam Integer id){
        int i = parkinguseService.deleteById(id);
        return new Result(i > 0 ? true : false, StatusCode.OK, "");
    }
}

