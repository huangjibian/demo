package redPacket.dao;

import org.springframework.stereotype.Repository;
import redPacket.pojo.RedPacket;

/**
 * Created by Administrator on 2018/10/15.
 */
@Repository
public interface RedPacketDao {

    /**
     * 获取红包信息.
     * @param id --红包id
     * @return 红包具体信息
     */
    public RedPacket getRedPacket(Long id);

    /**
     * 扣减抢红包数.
     * @param id -- 红包id
     * @return 更新记录条数
     */
    public int decreaseRedPacket(Long id);


}
