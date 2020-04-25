package edu.hust.se.app.walk.controller;

import edu.hust.se.app.walk.entity.TWalkData;
import edu.hust.se.app.walk.service.TWalkDataService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TWalkData)表控制层
 *
 * @author makejava
 * @since 2020-04-25 14:56:22
 */
@RestController
@RequestMapping("tWalkData")
public class TWalkDataController {
    /**
     * 服务对象
     */
    @Resource
    private TWalkDataService tWalkDataService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TWalkData selectOne(Integer id) {
        return this.tWalkDataService.queryById(id);
    }

}