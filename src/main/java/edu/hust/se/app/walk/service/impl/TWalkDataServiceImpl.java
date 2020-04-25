package edu.hust.se.app.walk.service.impl;

import edu.hust.se.app.walk.entity.TWalkData;
import edu.hust.se.app.walk.dao.TWalkDataDao;
import edu.hust.se.app.walk.service.TWalkDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TWalkData)表服务实现类
 *
 * @author makejava
 * @since 2020-04-25 14:56:21
 */
@Service("tWalkDataService")
public class TWalkDataServiceImpl implements TWalkDataService {
    @Resource
    private TWalkDataDao tWalkDataDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TWalkData queryById(Integer id) {
        return this.tWalkDataDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TWalkData> queryAllByLimit(int offset, int limit) {
        return this.tWalkDataDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tWalkData 实例对象
     * @return 实例对象
     */
    @Override
    public TWalkData insert(TWalkData tWalkData) {
        this.tWalkDataDao.insert(tWalkData);
        return tWalkData;
    }

    /**
     * 修改数据
     *
     * @param tWalkData 实例对象
     * @return 实例对象
     */
    @Override
    public TWalkData update(TWalkData tWalkData) {
        this.tWalkDataDao.update(tWalkData);
        return this.queryById(tWalkData.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tWalkDataDao.deleteById(id) > 0;
    }
}