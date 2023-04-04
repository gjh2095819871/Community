package com.gjh.communitymanagement.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gjh.communitymanagement.common.MessageConstant;
import com.gjh.communitymanagement.common.PageResult;
import com.gjh.communitymanagement.common.Result;
import com.gjh.communitymanagement.common.StatusCode;
import com.gjh.communitymanagement.domain.Activity;
import com.gjh.communitymanagement.domain.Car;
import com.gjh.communitymanagement.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 活动表 前端控制器
 * </p>
 *
 * @author Guo Jianhui
 * @since 2023-02-08
 */
@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap) {
        IPage<Activity> activityIPage = activityService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.COMMUNITY_SEARCH_SUCCESS, activityIPage.getRecords(), activityIPage.getTotal());
    }

    @RequestMapping("/searchten")
    public Result searchten(){
        List<Activity> searchten = activityService.searchten();
        return new Result(true,StatusCode.OK,"",searchten);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Activity activity){
        Boolean add = activityService.add(activity);
        return  new Result(add,StatusCode.OK,"");
    }

    @PostMapping("/update")
    public Result update(@RequestBody Activity activity){
        Boolean update = activityService.update(activity);
        return  new Result(update,StatusCode.OK,"");
    }

    @GetMapping("/findById")
    public Result findById(Integer id){
        Activity activity = activityService.findById(id);
        return new Result(true,StatusCode.OK,"",activity);
    }

    @DeleteMapping ("/daleteById")
    public Result deleteById(@RequestParam Integer id){
        int i = activityService.deleteById(id);
        return new Result(i > 0 ? true : false, StatusCode.OK, "");
    }
}

