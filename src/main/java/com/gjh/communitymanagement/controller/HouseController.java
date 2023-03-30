package com.gjh.communitymanagement.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gjh.communitymanagement.common.MessageConstant;
import com.gjh.communitymanagement.common.PageResult;
import com.gjh.communitymanagement.common.Result;
import com.gjh.communitymanagement.common.StatusCode;
import com.gjh.communitymanagement.domain.House;
import com.gjh.communitymanagement.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 房屋表 前端控制器
 * </p>
 *
 * @author Guo Jianhui
 * @since 2023-02-08
 */
@RestController
@RequestMapping("/house")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap) {
        IPage<House> houseIPage = houseService.search(searchMap);
        return new PageResult(true, StatusCode.OK, "房产列表查询成功", houseIPage.getRecords(), houseIPage.getTotal());
    }

    @GetMapping("/findById")
    public Result findById(Integer id) {
        House house = houseService.findById(id);
        return new Result(true, StatusCode.OK, "查询成功", house);
    }
    @DeleteMapping("/deleteById")
    public Result deleteById(@RequestParam Integer id) {
        int delete = houseService.deleteById(id);
        return new Result(delete > 0 ? true : false, StatusCode.OK, MessageConstant.COMMUNITY_DELETE_SUCCESS);
    }

    @PostMapping("/add")
    public Result add(@RequestBody House house) {
        Boolean add = houseService.add(house);
        return new Result(add, StatusCode.OK, "");
    }

    @PostMapping("/update")
    public Result update(@RequestBody House house) {
        Boolean update = houseService.update(house);
        return new Result(update, StatusCode.OK, "");
    }

    @RequestMapping("/findAllHou")
    public Result findAllHou(){
        List<Map<String, Object>> allComm = houseService.findAllHou();
        return new Result(true,StatusCode.OK,"ok",allComm);
    }
}

