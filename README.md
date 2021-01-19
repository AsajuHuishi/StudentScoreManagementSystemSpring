# Spring学生成绩管理系统（Service+Dao）

## 简介
本文基于Spring5框架实现一个简单的学生成绩管理系统。它使用Druid数据库连接池，以及Spring提供的JdbcTemplate模板，实现Dao层和Service层的基本功能。对应文章见[Spring 实现学生成绩管理系统](https://blog.csdn.net/qq_36937684/article/details/112844468)

## 任务
1.新增学生记录<br>
2.修改学生记录<br>
3.删除学生记录<br>
4.按姓名或学号查询学生记录<br>
5.按成绩排序<br>
6.分班级统计<br>
7.退出<br>

##  环境依赖
 - `JDK 1.8`   
 - `MySQL 5.5.15`
 - `JDBC 5.1.49`
 - `Spring 5.2.6`
 - `Intellij IDEA 2020.3.1`
 - 所需依赖：
<center><img src="https://img-blog.csdnimg.cn/2021011916413521.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM2OTM3Njg0,size_16,color_FFFFFF,t_70"/></center>

## 相关工作
[MySQL+java: 实现学生成绩管理系统（1.0版本）](https://blog.csdn.net/qq_36937684/article/details/108757156)<br>
[MySQL+java: 实现学生成绩管理系统（2.0版本）](https://blog.csdn.net/qq_36937684/article/details/112502793)

## 项目结构
<center><img src="https://img-blog.csdnimg.cn/20210119164304335.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM2OTM3Njg0,size_16,color_FFFFFF,t_70"/></center>

文件    | 功能
-------- | -----
StuScore.java  | 实体类，建立和stu_score表相同的字段
StuDao.java  | Dao层，数据库相关操作方法接口
StuDaoImpl.java | Dao层接口实现类，封装数据库连接，增删改查语句
StuService.java| Service层，实现具体业务操作（菜单）
TestMenu.java|测试主方法
bean.xml| 配置文件，配置`Druid`数据库连接池+`JdbcTemplate`

## 使用
使用MySQL生成表
包括 学号，姓名，成绩，班级四个字段。
```sql
USE db58;

DROP TABLE IF EXISTS stu_score;
CREATE TABLE IF NOT EXISTS stu_score(
	NO VARCHAR(10) unique,
	NAME VARCHAR(20),
	score FLOAT,
	className INT
);

DESC stu_score;
``` 

## 样例
见[Spring 实现学生成绩管理系统](https://blog.csdn.net/qq_36937684/article/details/112844468)
