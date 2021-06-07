package MyTest;

import com.pojo.Admin;
import com.service.AdminService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyTest {

    @Test
    public void serviceTest() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminService adminService = (AdminService) applicationContext.getBean("adminService");

//        for (Admin admin : adminService.getAdmins()) {
//            System.out.println(admin);
//        }

        Admin admin = adminService.getAdminByYhm("haha");
        System.out.println(admin);

    }

}
