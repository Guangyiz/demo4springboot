package edu.hust.se.app.walk.dao;

import edu.hust.se.app.walk.entity.TWalkData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TWalkData)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-25 14:56:20
 */
@Mapper
public interface TWalkDataDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TWalkData queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TWalkData> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tWalkData 实例对象
     * @return 对象列表
     */
    List<TWalkData> queryAll(TWalkData tWalkData);

    /**
     * 新增数据
     *
     * @param tWalkData 实例对象
     * @return 影响行数
     */
    int insert(TWalkData tWalkData);

    /**
     * 修改数据
     *
     * @param tWalkData 实例对象
     * @return 影响行数
     */
    int update(TWalkData tWalkData);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}