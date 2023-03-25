package com.gjh.communitymanagement.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gjh.communitymanagement.common.MessageConstant;
import com.gjh.communitymanagement.common.PageResult;
import com.gjh.communitymanagement.common.StatusCode;
import com.gjh.communitymanagement.domain.Activity;
import com.gjh.communitymanagement.domain.ChargeDetail;
import com.gjh.communitymanagement.service.ChargeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 收费名细表 前端控制器
 * </p>
 *
 * @author Guo Jianhui
 * @since 2023-02-08
 */
@RestController
@RequestMapping("/charge_detail")
public class ChargeDetailController {

    @Autowired
    private ChargeDetailService chargeDetailService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap) {
        IPage<ChargeDetail> chargeDetailIPage = chargeDetailService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.COMMUNITY_SEARCH_SUCCESS, chargeDetailIPage.getRecords(), chargeDetailIPage.getTotal());
    }
}

