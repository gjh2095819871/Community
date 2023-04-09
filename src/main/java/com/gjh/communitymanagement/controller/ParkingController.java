package com.gjh.communitymanagement.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gjh.communitymanagement.common.MessageConstant;
import com.gjh.communitymanagement.common.PageResult;
import com.gjh.communitymanagement.common.Result;
import com.gjh.communitymanagement.common.StatusCode;
import com.gjh.communitymanagement.domain.Parking;
import com.gjh.communitymanagement.domain.ParkingUse;
import com.gjh.communitymanagement.domain.Pet;
import com.gjh.communitymanagement.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 车位表 前端控制器
 * </p>
 *
 * @author Guo Jianhui
 * @since 2023-02-08
 */
@RestController
@RequestMapping("/parking")
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap) {
        IPage<Parking> parkingIPage = parkingService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.COMMUNITY_SEARCH_SUCCESS, parkingIPage.getRecords(), parkingIPage.getTotal());
    }

    @PostMapping("/add")
    public Result add(@RequestBody Parking parking){
        Boolean add = parkingService.add(parking);
        return new Result(add,StatusCode.OK,"");
    }

    @PostMapping("/update")
    public Result update(@RequestBody Parking parking){
        Boolean update = parkingService.update(parking);
        return new Result(update,StatusCode.OK,"");
    }

    @GetMapping("/findById")
    public Result findById(Integer id){
        Parking parking = parkingService.findById(id);
        return new Result(true,StatusCode.OK,"",parking);
    }

    @DeleteMapping ("/daleteById")
    public Result deleteById(@RequestParam Integer id){
        int i = parkingService.deleteById(id);
        return new Result(i > 0 ? true : false, StatusCode.OK, "");
    }
}

