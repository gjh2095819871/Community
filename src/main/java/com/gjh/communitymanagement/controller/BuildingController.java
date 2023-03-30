package com.gjh.communitymanagement.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gjh.communitymanagement.common.MessageConstant;
import com.gjh.communitymanagement.common.PageResult;
import com.gjh.communitymanagement.common.Result;
import com.gjh.communitymanagement.common.StatusCode;
import com.gjh.communitymanagement.domain.Building;
import com.gjh.communitymanagement.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 楼栋表 前端控制器
 * </p>
 *
 * @author Guo Jianhui
 * @since 2023-02-08
 */
@RestController
@RequestMapping("/building")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap) {
        IPage<Building> buildingIPage = buildingService.search(searchMap);
        return new PageResult(true, StatusCode.OK, "房产列表查询成功", buildingIPage.getRecords(), buildingIPage.getTotal());
    }

    @GetMapping("/findById")
    public Result findById(Integer id) {
        Building building = buildingService.findById(id);
        return new Result(true, StatusCode.OK, "查询成功", building);
    }
    @DeleteMapping("/deleteById")
    public Result deleteById(@RequestParam Integer id) {
        int delete = buildingService.deleteById(id);
        return new Result(delete > 0 ? true : false, StatusCode.OK, MessageConstant.COMMUNITY_DELETE_SUCCESS);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Building building){
        Boolean add = buildingService.add(building);
        return new Result(add,StatusCode.OK,"");
    }

    @PostMapping("/update")
    public Result update(@RequestBody Building building) {
        Boolean update = buildingService.update(building);
        return new Result(update, StatusCode.OK, "");
    }

    @RequestMapping("/findAllBuil")
    public Result findAllBuil(String cname){
        List<Map<String, Object>> allBuil = buildingService.findAllBuil(cname);
        return new Result(true,StatusCode.OK,"ok",allBuil);
    }
}

