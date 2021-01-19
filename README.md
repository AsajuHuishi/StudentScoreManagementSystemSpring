Spring学生成绩管理系统（Service+Dao）
## 任务
<center><img src="https://img-blog.csdnimg.cn/20200923171232277.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM2OTM3Njg0,size_16,color_FFFFFF,t_70#pic_center"/></center>

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

## 实现结果

```bash
=======欢迎进入学生成绩管理系统=======
1.新增学生记录
2.修改学生记录
3.删除学生记录
4.按姓名或学号查询学生记录
5.按成绩排序
6.分班级统计
7.退出
请选择（1-7）：
1
******************************
====新增学生====
学号(长度不超过10)：
201
班级(整数):
1
姓名：
M7
成绩：
82
一月 19, 2021 3:53:26 下午 com.alibaba.druid.support.logging.JakartaCommonsLoggingImpl info
信息: {dataSource-1} inited
添加成功
是否继续添加(y/n)：
y
====新增学生====
学号(长度不超过10)：
202
班级(整数):
2
姓名：
4D
成绩：
81
添加成功
是否继续添加(y/n)：
y
====新增学生====
学号(长度不超过10)：
203
班级(整数):
3
姓名：
A20
成绩：
84
添加成功
是否继续添加(y/n)：
y
====新增学生====
学号(长度不超过10)：
213
班级(整数):
3
姓名：
A32
成绩：
85
添加成功
是否继续添加(y/n)：
y
====新增学生====
学号(长度不超过10)：
212
班级(整数):
2
姓名：
38tnA
成绩：
86
添加成功
是否继续添加(y/n)：
n
=======欢迎进入学生成绩管理系统=======
1.新增学生记录
2.修改学生记录
3.删除学生记录
4.按姓名或学号查询学生记录
5.按成绩排序
6.分班级统计
7.退出
请选择（1-7）：
2
******************************
====修改学生====
请输入要修改的学生学号：
202
查询到该姓名记录
StuScore{no='202', name='4D', score=81.0, className=2}
请输入新的学生信息：
学生班级：
2
学生姓名：
4D
学生成绩：
82.5
修改成功
=======欢迎进入学生成绩管理系统=======
1.新增学生记录
2.修改学生记录
3.删除学生记录
4.按姓名或学号查询学生记录
5.按成绩排序
6.分班级统计
7.退出
请选择（1-7）：
3
******************************
====删除学生====
请输入要删除的学生学号：
213
StuScore{no='213', name='A32', score=85.0, className=3}
是否真的删除(y/n)：
y
删除成功
=======欢迎进入学生成绩管理系统=======
1.新增学生记录
2.修改学生记录
3.删除学生记录
4.按姓名或学号查询学生记录
5.按成绩排序
6.分班级统计
7.退出
请选择（1-7）：
4
******************************
请选择按姓名查询还是按照学号查询(1姓名 2学号):1
====查询学生====
请输入要查看的学生姓名：
M7
查询到该姓名记录
StuScore{no='201', name='M7', score=82.0, className=1}
=======欢迎进入学生成绩管理系统=======
1.新增学生记录
2.修改学生记录
3.删除学生记录
4.按姓名或学号查询学生记录
5.按成绩排序
6.分班级统计
7.退出
请选择（1-7）：
4
******************************
请选择按姓名查询还是按照学号查询(1姓名 2学号):2
====查询学生====
请输入要查看的学生学号：
201
查询到该学号记录
StuScore{no='201', name='M7', score=82.0, className=1}
=======欢迎进入学生成绩管理系统=======
1.新增学生记录
2.修改学生记录
3.删除学生记录
4.按姓名或学号查询学生记录
5.按成绩排序
6.分班级统计
7.退出
请选择（1-7）：
5
******************************
按成绩升序显示
学号		班级	姓名	成绩
StuScore{no='201', name='M7', score=82.0, className=1}
StuScore{no='202', name='4D', score=82.5, className=2}
StuScore{no='203', name='A20', score=84.0, className=3}
StuScore{no='212', name='38tnA', score=86.0, className=2}
=======欢迎进入学生成绩管理系统=======
1.新增学生记录
2.修改学生记录
3.删除学生记录
4.按姓名或学号查询学生记录
5.按成绩排序
6.分班级统计
7.退出
请选择（1-7）：
6
******************************
统计(分班级统计学生数量,最高分,最低分,平均值)
一月 19, 2021 4:38:05 下午 com.alibaba.druid.support.logging.JakartaCommonsLoggingImpl info
信息: {dataSource-1} inited
{max_score=86.0, count=2, className=2, min_score=82.5, avg_score=84.25}
{max_score=84.0, count=1, className=3, min_score=84.0, avg_score=84.0}
{max_score=82.0, count=1, className=1, min_score=82.0, avg_score=82.0}
=======欢迎进入学生成绩管理系统=======
1.新增学生记录
2.修改学生记录
3.删除学生记录
4.按姓名或学号查询学生记录
5.按成绩排序
6.分班级统计
7.退出
请选择（1-7）：
7
******************************
您选择了退出系统，确定要退出吗？(y/n)
y

Process finished with exit code -1
```
