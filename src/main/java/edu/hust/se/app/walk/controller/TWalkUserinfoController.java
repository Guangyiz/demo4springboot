package edu.hust.se.app.walk.controller;

import edu.hust.se.app.walk.entity.TWalkUserinfo;
import edu.hust.se.app.walk.service.TWalkUserinfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TWalkUserinfo)表控制层
 *
 * @author makejava
 * @since 2020-04-25 14:56:24
 */
@RestController
@RequestMapping("tWalkUserinfo")
public class TWalkUserinfoController {
    /**
     * 服务对象
     */
    @Resource
    private TWalkUserinfoService tWalkUserinfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TWalkUserinfo selectOne(Integer id) {
        return this.tWalkUserinfoService.queryById(id);
    }

}