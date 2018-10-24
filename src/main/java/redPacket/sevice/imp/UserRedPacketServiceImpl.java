package redPacket.sevice.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import redPacket.dao.RedPacketDao;
import redPacket.dao.UserRedPacketDao;
import redPacket.pojo.RedPacket;
import redPacket.pojo.UserRedPacket;
import redPacket.sevice.UserRedPacketService;

/**
 * Created by Administrator on 2018/10/16.
 */
@Service
public class UserRedPacketServiceImpl implements UserRedPacketService {

    // private Logger logger =
    // LoggerFactory.getLogger(UserRedPacketServiceImpl.class);

    @Autowired
    private UserRedPacketDao userRedPacketDao;

    @Autowired
    private RedPacketDao redPacketDao;

    // 失败
    private static final int FAILED = 0;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int grapRedPacket(Long redPacketId, Long userId) {
        // 获取红包信息
        RedPacket redPacket = redPacketDao.getRedPacket(redPacketId);
        int leftRedPacket = redPacket.getStock();
        // 当前小红包库存大于0
        if (leftRedPacket > 0) {
            redPacketDao.decreaseRedPacket(redPacketId);
            // logger.info("剩余Stock数量:{}", leftRedPacket);
            // 生成抢红包信息
            UserRedPacket userRedPacket = new UserRedPacket();
            userRedPacket.setRedPacketId(redPacketId);
            userRedPacket.setUserId(userId);
            userRedPacket.setAmount(redPacket.getUnitAmount());
            userRedPacket.setNote("redpacket- " + redPacketId);
            // 插入抢红包信息
            int result = userRedPacketDao.grapRedPacket(userRedPacket);
            return result;
        }
        // logger.info("没有红包啦.....剩余Stock数量:{}", leftRedPacket);
        // 失败返回
        return FAILED;
    }


}
