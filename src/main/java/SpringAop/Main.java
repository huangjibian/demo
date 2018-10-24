package SpringAop;

import mybatis.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Administrator on 2018/9/20.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AopConfig.class);

        RoleService roleService = (RoleService)ctx.getBean(RoleService.class);
        Role role = new Role();
        role.setId(1L);
        role.setRoleName("张三");
        role.setNote("1");
        roleService.printRole(role);
        System.out.println("################");
       // 测试异常通知
       // role=null;
        roleService.printRole(role);

    }
}
