package com.gjh.communitymanagement.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gjh.communitymanagement.common.MessageConstant;
import com.gjh.communitymanagement.common.PageResult;
import com.gjh.communitymanagement.common.Result;
import com.gjh.communitymanagement.common.StatusCode;
import com.gjh.communitymanagement.domain.Activity;
import com.gjh.communitymanagement.domain.Owner;
import com.gjh.communitymanagement.domain.Repair;
import com.gjh.communitymanagement.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 维修表 前端控制器
 * </p>
 *
 * @author Guo Jianhui
 * @since 2023-02-08
 */
@RestController
@RequestMapping("/repair")
public class RepairController {

    @Autowired
    private RepairService repairService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap) {
        IPage<Repair> repairIPage = repairService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.COMMUNITY_SEARCH_SUCCESS, repairIPage.getRecords(), repairIPage.getTotal());
    }

    @RequestMapping("/searchten")
    public Result searchten(){
        List<Repair> repairs = repairService.searchten();
        return new Result(true,StatusCode.OK,"",repairs);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Repair repair){
        Boolean add = repairService.add(repair);
        return new Result(add,StatusCode.OK,"");
    }

    @PostMapping("/update")
    public Result update(@RequestBody Repair repair){
        Boolean update = repairService.update(repair);
        return new Result(update,StatusCode.OK,"");
    }

    @GetMapping("/findById")
    public Result findById(Integer id){
        Repair repair = repairService.findById(id);
        return new Result(true,StatusCode.OK,"",repair);
    }

    @DeleteMapping ("/daleteById")
    public Result deleteById(@RequestParam Integer id){
        int i = repairService.deleteById(id);
        return new Result(i > 0 ? true : false, StatusCode.OK, "");
    }
}

