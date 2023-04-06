package com.gjh.communitymanagement.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gjh.communitymanagement.common.MessageConstant;
import com.gjh.communitymanagement.common.PageResult;
import com.gjh.communitymanagement.common.Result;
import com.gjh.communitymanagement.common.StatusCode;
import com.gjh.communitymanagement.domain.Activity;
import com.gjh.communitymanagement.domain.ChargeDetail;
import com.gjh.communitymanagement.domain.ChargeItem;
import com.gjh.communitymanagement.service.ChargeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 收费项目表 前端控制器
 * </p>
 *
 * @author Guo Jianhui
 * @since 2023-02-08
 */
@RestController
@RequestMapping("/charge_item")
public class ChargeItemController {


    @Autowired
    private ChargeItemService chargeItemService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap) {
        IPage<ChargeItem> chargeItemIPage = chargeItemService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.COMMUNITY_SEARCH_SUCCESS, chargeItemIPage.getRecords(), chargeItemIPage.getTotal());
    }

    @PostMapping("/add")
    public Result add(@RequestBody ChargeItem chargeItem){
        Boolean add = chargeItemService.add(chargeItem);
        return new Result(add,StatusCode.OK,"");
    }

    @PostMapping("/update")
    public Result update(@RequestBody ChargeItem chargeItem){
        Boolean update = chargeItemService.update(chargeItem);
        return new Result(update,StatusCode.OK,"");
    }

    @GetMapping("/findById")
    public Result findById(Integer id){
        ChargeItem chargeItem = chargeItemService.findById(id);
        return new Result(true,StatusCode.OK,"",chargeItem);
    }

    @DeleteMapping ("/daleteById")
    public Result deleteById(@RequestParam Integer id){
        int i = chargeItemService.deleteById(id);
        return new Result(i > 0 ? true : false, StatusCode.OK, "");
    }
}

