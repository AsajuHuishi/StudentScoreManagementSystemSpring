package indi.huishi.studentscore.test;

import indi.huishi.studentscore.service.StuService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.ws.Service;

public class TestMenu {
    /**
     * 测试
     */
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        StuService stuService = context.getBean("stuService", StuService.class);
        stuService.menu();
    }
}
