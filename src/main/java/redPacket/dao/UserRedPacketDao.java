package redPacket.dao;

import org.springframework.stereotype.Repository;
import redPacket.pojo.UserRedPacket;

/**
 * Created by Administrator on 2018/10/16.
 */
@Repository
public interface UserRedPacketDao {

    /**
     * 插入抢红包信息.
     * @param userRedPacket ——抢红包信息
     * @return 影响记录数.
     */
    public int grapRedPacket(UserRedPacket userRedPacket);
}
