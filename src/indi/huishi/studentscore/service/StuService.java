package indi.huishi.studentscore.service;

import indi.huishi.studentscore.dao.StuDao;
import indi.huishi.studentscore.entity.StuScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StuService {
    @Autowired
    private StuDao stuDao;
    private static Scanner s;
    private StuScore stuScore;
    public void menu() {
        //菜单
        int choose,choose2;
        List<Integer> chos = new ArrayList<Integer>();
        for (int i=1;i<8;i++) {
            chos.add(i);
        }
        Set<Integer> chooseSet = new HashSet<Integer>(chos);
        do {
            System.out.println("=======欢迎进入学生成绩管理系统=======");
            System.out.println("1.新增学生记录");
            System.out.println("2.修改学生记录");
            System.out.println("3.删除学生记录");
            System.out.println("4.按姓名或学号查询学生记录");
            System.out.println("5.按成绩排序");
            System.out.println("6.分班级统计");
            System.out.println("7.退出");
            System.out.println("请选择（1-7）：");

            Scanner scanner = new Scanner(System.in);
            choose = scanner.nextInt();
            while (!chooseSet.contains(choose)) {
                System.out.println("请选择（1-7）：");
                choose = scanner.nextInt();
            }

            System.out.println("******************************");
            switch (choose) {
                case 1:
                    myAdd(); //菜单选择1，是新增学生
                    break;
                case 2:
                    myUpdate();  //菜单选择2，是修改学生
                    break;
                case 3:
                    myDel();  //菜单选择3，是删除学生
                    break;
                case 4:       //菜单选择4，是查询学生
                    System.out.print("请选择按姓名查询还是按照学号查询(1姓名 2学号):");
                    Scanner sc2 = new Scanner(System.in);
                    choose2 = sc2.nextInt();
                    if (choose2==1) {
                        myListByName();
                    }else if (choose2==2) {
                        myListByNo();
                    }
                    break;
                case 5:    //菜单选择5，按成绩排序
                    mySort();
                    break;
                case 6:    //菜单选择6，统计
                    myStatistic();
                    break;
                case 7:     //菜单选择7，是退出该系统
                    System.out.println("您选择了退出系统，确定要退出吗？(y/n)");
                    Scanner sc3 = new Scanner(System.in);
                    String scanExit = sc3.next();
                    if(scanExit.equals("y")){
                        System.exit(-1);
                        System.out.println("您已成功退出系统，欢迎您再次使用！");
                    }
                    break;
                default:
                    break;
            }
        } while (choose!=7);
    }
    //新增学生信息
    public void myAdd() {
        String continute;
        do {
            s = new Scanner(System.in);
            String no, name;
            float score;
            int className;
            System.out.println("====新增学生====");
            System.out.println("学号(长度不超过10)：");
            no = s.next();
            System.out.println("班级(整数):");
            className = s.nextInt();
            System.out.println("姓名：");
            name = s.next();
            System.out.println("成绩：");
            score = s.nextFloat();
            //调用StuScoreOperation
            stuDao.add(new StuScore(no, name, score, className));
            System.out.println("是否继续添加(y/n)：");
            s = new Scanner(System.in);
            continute = s.next();
        } while (continute.equals("y"));
    }
    //修改学生信息
    public void myUpdate(){
        s = new Scanner(System.in);
        String no;
        System.out.println("====修改学生====");
        System.out.println("请输入要修改的学生学号：");
        no = s.next();
        stuScore = stuDao.queryByNo(no);
        if(stuScore!=null) {
            System.out.println("查询到该姓名记录");
            System.out.println(stuScore.toString());
            System.out.println("请输入新的学生信息：");
            s = new Scanner(System.in);
            String name;
            float score;
            int className;
            System.out.println("学生班级：");
            className = s.nextInt();
            System.out.println("学生姓名：");
            name = s.next();
            System.out.println("学生成绩：");
            score = s.nextFloat();
            stuDao.update(new StuScore(no, name, score, className));
        }else{
            System.out.println("未查询到该学号记录");
        }
    }
    //删除学生信息
    public void myDel(){
        s = new Scanner(System.in);
        String no;
        System.out.println("====删除学生====");
        System.out.println("请输入要删除的学生学号：");
        no = s.next();
        stuScore = stuDao.queryByNo(no);

        if(stuScore!=null) {
            System.out.println(stuScore.toString());
            System.out.println("是否真的删除(y/n)：");
            s = new Scanner(System.in);
            String x = s.next();
            if (x.equals("y")) {
                stuDao.delete(no);
            }
        }else{
            System.out.println("未查询到该姓名记录");
        }
    }
    //按姓名查询学生信息
    public void myListByName(){
        s = new Scanner(System.in);
        System.out.println("====查询学生====");
        System.out.println("请输入要查看的学生姓名：");
        StuScore stuScore = stuDao.queryByName(s.next());
        if(stuScore!=null) {
            System.out.println("查询到该姓名记录");
            System.out.println(stuScore.toString());
        }else{
            System.out.println("未查询到该姓名记录");
        }
    }
    //按学号查询学生信息
    public void myListByNo(){
        s = new Scanner(System.in);
        System.out.println("====查询学生====");
        System.out.println("请输入要查看的学生学号：");
        StuScore stuScore = stuDao.queryByNo(s.next());
        if(stuScore!=null) {
            System.out.println("查询到该学号记录");
            System.out.println(stuScore.toString());
        }else{
            System.out.println("未查询到该学号记录");
        }
    }
    //排序
    public void mySort() {
        System.out.println("按成绩升序显示");
        System.out.println("学号\t\t班级\t姓名\t成绩");
        stuDao.querySort();
    }
    //统计
    public void myStatistic() {
        System.out.println("统计(分班级统计学生数量,最高分,最低分,平均值)");
        List<Object> result = stuDao.statistics();
        for (Object obj:result){
            System.out.println(obj.toString());
        }
    }
}

