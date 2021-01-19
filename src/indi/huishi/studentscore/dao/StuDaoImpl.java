package indi.huishi.studentscore.dao;

import indi.huishi.studentscore.entity.StuScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StuDaoImpl  implements  StuDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(StuScore stuScore) {
        /**
         * 增加学生记录
         */
        Object[] params = {stuScore.getNo(),stuScore.getName(),stuScore.getScore(),stuScore.getClassName()};
        int add = 0;
        try {
            add = jdbcTemplate.update("insert into stu_score values(?,?,?,?)", params);
        } catch (DataAccessException e) {
            e.printStackTrace();
        } finally {
            System.out.println(add > 0 ? "添加成功" : "添加失败");
        }
    }

    @Override
    public void delete(String no) {
        /**
         * 按学号删除记录
         */
        int delete = 0;
        try {
            delete = jdbcTemplate.update("delete from stu_score where no=?",no);
        } catch (DataAccessException e) {
            e.printStackTrace();
        } finally {
            System.out.println(delete > 0 ? "删除成功" : "删除失败");
        }
    }

    @Override
    public void update(StuScore stuScore) {
        /**
         * 按学号修改记录
         */
        Object[] params = {stuScore.getName(),stuScore.getScore(),stuScore.getClassName(),stuScore.getNo()};
        int update = 0;
        try {
            update = jdbcTemplate.update("update stu_score set name=?,score=?,className=? where no=?",params);
        } catch (DataAccessException e) {
            e.printStackTrace();
        } finally {
            System.out.println(update > 0 ? "修改成功" : "修改失败");
        }
    }

    @Override
    public StuScore queryByName(String name) {
        /**
         * 按姓名查询记录
         */
        StuScore stuScore = null;
        try {
            stuScore = jdbcTemplate.queryForObject("select * from stu_score where name=?", new BeanPropertyRowMapper<>(StuScore.class), name);
        } catch (DataAccessException e) {
            e.printStackTrace();
        } finally {
            return stuScore;
        }
    }
    @Override
    public StuScore queryByNo(String no) {
        /**
         * 按学号查询记录
         */
        StuScore stuScore = null;
        try {
            stuScore = jdbcTemplate.queryForObject("select * from stu_score where no=?", new BeanPropertyRowMapper<>(StuScore.class), no);
        } catch (DataAccessException e) {
            e.printStackTrace();
        } finally {
            return stuScore;
        }
    }

    @Override
    public void querySort() {
        /**
         * 按C语言成绩排序
         */
        List<StuScore> result = null;
        try {
            result = jdbcTemplate.query("select * from stu_score order by score",new BeanPropertyRowMapper<>(StuScore.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        for (StuScore res:result) {
            System.out.println(res.toString());
        }
    }

    @Override
    public List<Object> statistics() {
        /**
         * 统计
         */
        List<Object> result = null;//保存集合的列表
        String sql="select count(*),max(score),min(score),round(avg(score),4),className from stu_score group by className order by avg(score) desc";
        try {
            result = jdbcTemplate.query(sql, new RowMapper() {
                @Override
                public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                    Map<String,Object> map = new HashMap<>();
                    map.put("count", resultSet.getObject(1));
                    map.put("max_score", resultSet.getObject(2));
                    map.put("min_score", resultSet.getObject(3));
                    map.put("avg_score", resultSet.getObject(4));
                    map.put("className", resultSet.getObject(5));
                    return map;
                }
            });
        } catch (DataAccessException e) {
            e.printStackTrace();
        } finally {
            return result;
        }

    }
}
