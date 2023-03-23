package com.gjh.communitymanagement.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gjh.communitymanagement.common.MessageConstant;
import com.gjh.communitymanagement.common.PageResult;
import com.gjh.communitymanagement.common.Result;
import com.gjh.communitymanagement.common.StatusCode;
import com.gjh.communitymanagement.domain.Community;
import com.gjh.communitymanagement.domain.Owner;
import com.gjh.communitymanagement.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 业主表 前端控制器
 * </p>
 *
 * @author Guo Jianhui
 * @since 2023-02-08
 */
@RestController
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap) {
        IPage<Owner> ownerIPage = ownerService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.COMMUNITY_SEARCH_SUCCESS, ownerIPage.getRecords(), ownerIPage.getTotal());
    }

    @RequestMapping("/findAllOwn")
    public Result findAllOwn(){
        List<Map<String, Object>> allComm = ownerService.findAllOwn();
        return new Result(true,StatusCode.OK,"ok",allComm);
    }

    @GetMapping("/searchCount")
    public Result searchCount(){
        Map<String,Integer> stringIntegerMap=ownerService.searchCount();
        return new Result(true,StatusCode.OK,"ok",stringIntegerMap);
    }
}

