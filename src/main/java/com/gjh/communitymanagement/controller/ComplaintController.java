package com.gjh.communitymanagement.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gjh.communitymanagement.common.MessageConstant;
import com.gjh.communitymanagement.common.PageResult;
import com.gjh.communitymanagement.common.Result;
import com.gjh.communitymanagement.common.StatusCode;
import com.gjh.communitymanagement.domain.Activity;
import com.gjh.communitymanagement.domain.ChargeItem;
import com.gjh.communitymanagement.domain.Complaint;
import com.gjh.communitymanagement.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 投诉表 前端控制器
 * </p>
 *
 * @author Guo Jianhui
 * @since 2023-02-08
 */
@RestController
@RequestMapping("/complaint")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap) {
        IPage<Complaint> complaintIPage = complaintService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.COMMUNITY_SEARCH_SUCCESS, complaintIPage.getRecords(), complaintIPage.getTotal());
    }

    @PostMapping("/add")
    public Result add(@RequestBody Complaint complaint){
        Boolean add = complaintService.add(complaint);
        return new Result(add,StatusCode.OK,"");
    }

    @PostMapping("/update")
    public Result update(@RequestBody Complaint complaint){
        Boolean update = complaintService.update(complaint);
        return new Result(update,StatusCode.OK,"");
    }

    @GetMapping("/findById")
    public Result findById(Integer id){
        Complaint complaint = complaintService.findById(id);
        return new Result(true,StatusCode.OK,"",complaint);
    }

    @DeleteMapping ("/daleteById")
    public Result deleteById(@RequestParam Integer id){
        int i = complaintService.deleteById(id);
        return new Result(i > 0 ? true : false, StatusCode.OK, "");
    }
}

