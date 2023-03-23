package com.gjh.communitymanagement.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gjh.communitymanagement.common.MessageConstant;
import com.gjh.communitymanagement.common.PageResult;
import com.gjh.communitymanagement.common.StatusCode;
import com.gjh.communitymanagement.domain.Parking;
import com.gjh.communitymanagement.domain.ParkingUse;
import com.gjh.communitymanagement.service.ParkinguseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
}

