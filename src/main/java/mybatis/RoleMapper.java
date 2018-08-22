package mybatis;

import java.util.List;

/**
 * Created by Administrator on 2018/8/15.
 */
public interface RoleMapper {
    public int insertRolo(Role role);
    public int deleteRolo(Role role);
    public int updateRolo(Role role);
    public Role getRole(Long id);
    public List<Role> findRole(String roleName);

}
