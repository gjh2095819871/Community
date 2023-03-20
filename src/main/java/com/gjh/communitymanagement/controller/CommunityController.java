package com.gjh.communitymanagement.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gjh.communitymanagement.common.MessageConstant;
import com.gjh.communitymanagement.common.PageResult;
import com.gjh.communitymanagement.common.Result;
import com.gjh.communitymanagement.common.StatusCode;
import com.gjh.communitymanagement.domain.Community;
import com.gjh.communitymanagement.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 健辉
 */
@RestController
@RequestMapping("/community")
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @GetMapping("/find")
    public Result find() {
        List<Community> all = communityService.findAll();
        return new Result(true, 200, "success", all);
    }

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap) {
        IPage<Community> communityIPage = communityService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.COMMUNITY_SEARCH_SUCCESS, communityIPage.getRecords(), communityIPage.getTotal());
    }

    @PostMapping("/add")
    public Result add(@RequestBody Community community) {
        Boolean add = communityService.add(community);
        return new Result(add, StatusCode.OK, MessageConstant.COMMUNITY_ADD_SUCCESS);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Community community) {
        Boolean update = communityService.update(community);
        return new Result(update, StatusCode.OK, MessageConstant.COMMUNITY_UPDATE_SUCCESS);
    }

    @GetMapping("/findById")
    public Result findById(Integer id) {
        Community community = communityService.findById(id);
        return new Result(true, StatusCode.OK, MessageConstant.COMMUNITY_FIND_BY_ID_SUCCESS, community);
    }

    @DeleteMapping("/deleteById")
    public Result deleteById(@RequestParam Integer id) {
        int delete = communityService.deleteById(id);
        return new Result(delete > 0 ? true : false, StatusCode.OK, MessageConstant.COMMUNITY_DELETE_SUCCESS);
    }

    @PostMapping("/deleteAll")
    public Result deleteAll(@RequestBody Map list){
        List list1= (List) list.get("ids");
        int deleteAll = communityService.deleteAll(list1);
        return new Result(deleteAll > 0 ? true : false, StatusCode.OK, MessageConstant.COMMUNITY_DELETE_SUCCESS);
    }

    @RequestMapping("/findAllComm")
    public Result findAllComm(){
        List<Map<String, Object>> allComm = communityService.findAllComm();
        return new Result(true,StatusCode.OK,"ok",allComm);
    }

    @GetMapping("/searchCount")
    public Result searchCount(){
        Map<String,Integer> stringIntegerMap=communityService.searchCount();
        return new Result(true,StatusCode.OK,"ok",stringIntegerMap);
    }

}
