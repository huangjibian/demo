package SpringAop;

import mybatis.Role;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/9/20.
 */
@Component
public class RoleServiceImpl implements RoleService {
    @Override
    public void printRole(Role role){
        System.out.println("【id】 = "+role.getId()
                +"\n"+"【name】 = "+role.getRoleName()
                +"\n"+"【note】 = "+role.getNote());
    }
}
