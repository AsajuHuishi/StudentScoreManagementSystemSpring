package indi.huishi.studentscore.dao;

import indi.huishi.studentscore.entity.StuScore;

import java.util.List;

public interface StuDao {
    /** dao接口,实现以下方法:
     * 数据库连接池的连接+增/删/改/查通用方法
     */
    void add(StuScore stuScore);
    void delete(String no);
    void update(StuScore stuScore);
    StuScore queryByName(String name);
    StuScore queryByNo(String no);
    void querySort();
    List<Object> statistics();

}
