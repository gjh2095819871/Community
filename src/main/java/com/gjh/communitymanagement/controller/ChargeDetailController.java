package com.gjh.communitymanagement.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gjh.communitymanagement.common.MessageConstant;
import com.gjh.communitymanagement.common.PageResult;
import com.gjh.communitymanagement.common.Result;
import com.gjh.communitymanagement.common.StatusCode;
import com.gjh.communitymanagement.domain.Activity;
import com.gjh.communitymanagement.domain.Car;
import com.gjh.communitymanagement.domain.ChargeDetail;
import com.gjh.communitymanagement.service.ChargeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public Result add(@RequestBody ChargeDetail chargeDetail){
        Boolean add = chargeDetailService.add(chargeDetail);
        return new Result(add,StatusCode.OK,"");
    }

    @PostMapping("/update")
    public Result update(@RequestBody ChargeDetail chargeDetail){
        Boolean update = chargeDetailService.update(chargeDetail);
        return new Result(update,StatusCode.OK,"");
    }

    @GetMapping("/findById")
    public Result findById(Integer id){
        ChargeDetail chargeDetail = chargeDetailService.findById(id);
        return new Result(true,StatusCode.OK,"",chargeDetail);
    }

    @DeleteMapping ("/daleteById")
    public Result deleteById(@RequestParam Integer id){
        int i = chargeDetailService.deleteById(id);
        return new Result(i > 0 ? true : false, StatusCode.OK, "");
    }
}

