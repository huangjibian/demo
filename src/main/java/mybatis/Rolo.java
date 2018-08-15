package mybatis;

/**
 * Created by Administrator on 2018/8/15.
 */
public class Rolo {
    private Long id;
    private String roloName;
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoloName() {
        return roloName;
    }

    public void setRoloName(String roloName) {
        this.roloName = roloName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
