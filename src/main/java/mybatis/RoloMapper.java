package mybatis;

import java.util.List;

/**
 * Created by Administrator on 2018/8/15.
 */
public interface RoloMapper {
    public int insertRolo(Rolo role);
    public int deleteRolo(Rolo role);
    public int updateRolo(Rolo role);
    public Rolo getRolo(Long id);
    public List<Rolo> findRolo(String roleName);

}
