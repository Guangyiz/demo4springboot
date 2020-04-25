package edu.hust.se.app.walk.service.impl;

import edu.hust.se.app.walk.entity.TWalkUserinfo;
import edu.hust.se.app.walk.dao.TWalkUserinfoDao;
import edu.hust.se.app.walk.service.TWalkUserinfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TWalkUserinfo)表服务实现类
 *
 * @author makejava
 * @since 2020-04-25 14:56:24
 */
@Service("tWalkUserinfoService")
public class TWalkUserinfoServiceImpl implements TWalkUserinfoService {
    @Resource
    private TWalkUserinfoDao tWalkUserinfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TWalkUserinfo queryById(Integer id) {
        return this.tWalkUserinfoDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TWalkUserinfo> queryAllByLimit(int offset, int limit) {
        return this.tWalkUserinfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tWalkUserinfo 实例对象
     * @return 实例对象
     */
    @Override
    public TWalkUserinfo insert(TWalkUserinfo tWalkUserinfo) {
        this.tWalkUserinfoDao.insert(tWalkUserinfo);
        return tWalkUserinfo;
    }

    /**
     * 修改数据
     *
     * @param tWalkUserinfo 实例对象
     * @return 实例对象
     */
    @Override
    public TWalkUserinfo update(TWalkUserinfo tWalkUserinfo) {
        this.tWalkUserinfoDao.update(tWalkUserinfo);
        return this.queryById(tWalkUserinfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tWalkUserinfoDao.deleteById(id) > 0;
    }
}