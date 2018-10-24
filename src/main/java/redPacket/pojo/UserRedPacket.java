package redPacket.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2018/10/15.
 */
public class UserRedPacket implements Serializable {

    private static final long serialVersionUID = 7049215937937620886L;

    // 用户红包id
    private Long id;
    // 红包id
    private Long redPacketId;
    // 抢红包的用户的id
    private Long userId;
    // 抢红包金额
    private Double amount;
    // 抢红包时间
    private Timestamp grabTime;
    // 备注
    private String note;
    // 省略set/get

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRedPacketId() {
        return redPacketId;
    }

    public void setRedPacketId(Long redPacketId) {
        this.redPacketId = redPacketId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Timestamp getGrabTime() {
        return grabTime;
    }

    public void setGrabTime(Timestamp grabTime) {
        this.grabTime = grabTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

