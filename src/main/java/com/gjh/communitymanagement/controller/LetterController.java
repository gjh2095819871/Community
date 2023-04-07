package com.gjh.communitymanagement.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gjh.communitymanagement.common.MessageConstant;
import com.gjh.communitymanagement.common.PageResult;
import com.gjh.communitymanagement.common.Result;
import com.gjh.communitymanagement.common.StatusCode;
import com.gjh.communitymanagement.domain.Activity;
import com.gjh.communitymanagement.domain.Device;
import com.gjh.communitymanagement.domain.Letter;
import com.gjh.communitymanagement.service.LetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 信件表 前端控制器
 * </p>
 *
 * @author Guo Jianhui
 * @since 2023-02-08
 */
@RestController
@RequestMapping("/letter")
public class LetterController {

    @Autowired
    private LetterService letterService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap) {
        IPage<Letter> letterIPage = letterService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.COMMUNITY_SEARCH_SUCCESS, letterIPage.getRecords(), letterIPage.getTotal());
    }

    @PostMapping("/add")
    public Result add(@RequestBody Letter letter){
        Boolean add = letterService.add(letter);
        return new Result(add,StatusCode.OK,"");
    }

    @PostMapping("/update")
    public Result update(@RequestBody Letter letter){
        Boolean update = letterService.update(letter);
        return new Result(update,StatusCode.OK,"");
    }

    @GetMapping("/findById")
    public Result findById(Integer id){
        Letter letter = letterService.findById(id);
        return new Result(true,StatusCode.OK,"",letter);
    }

    @DeleteMapping ("/daleteById")
    public Result deleteById(@RequestParam Integer id){
        int i = letterService.deleteById(id);
        return new Result(i > 0 ? true : false, StatusCode.OK, "");
    }
}

