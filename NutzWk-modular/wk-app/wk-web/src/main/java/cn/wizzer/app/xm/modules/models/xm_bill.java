package cn.wizzer.app.xm.modules.models;

import cn.wizzer.app.web.commons.util.NumberUtil;
import cn.wizzer.app.xm.modules.services.Impl.XmTaskServiceImpl;
import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.Dao;
import org.nutz.dao.entity.annotation.*;
import org.nutz.log.Logs;
import org.nutz.mvc.Mvcs;

import java.io.Serializable;

/**
 * Created by 89792 on 2017/11/17 0017.
 */
@Table("xm_bill")
public class xm_bill extends BaseModel implements Serializable {

    @Column
    @Name
    @Comment("账单编号")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    @Prev(els = {@EL("$me.xmbillid()")})
    private String id;

    @Column
    @Comment("项目编号")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String xminfid;


    @Column
    @Comment("雇员要求付款方式")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String gypayid;

    @Column
    @Comment("实际付款方式")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String realgypayid;

    @Column
    @Comment("预付总额")
    @ColDefine(type = ColType.FLOAT)
    private float prepaysum;

    @Column
    @Comment("实际付款总额")
    @ColDefine(type = ColType.FLOAT)
    private float paysum;

    @Column
    @Comment("状态")
    @ColDefine(type = ColType.INT)
    private int status;

    @Column
    @Comment("说明")
    @ColDefine(type = ColType.VARCHAR,width = 200)
    private String note;

    @Column
    @Comment("付款人")
    @ColDefine(type = ColType.VARCHAR,width = 32)
    private String payby;

    @Column
    @Comment("付款时间")
    @ColDefine(type = ColType.INT)
    private int at;

    //参照


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGypayid() {
        return gypayid;
    }

    public void setGypayid(String gypayid) {
        this.gypayid = gypayid;
    }

    public String getRealgypayid() {
        return realgypayid;
    }

    public void setRealgypayid(String realgypayid) {
        this.realgypayid = realgypayid;
    }

    public float getPrepaysum() {
        return prepaysum;
    }

    public void setPrepaysum(float prepaysum) {
        this.prepaysum = prepaysum;
    }

    public float getPaysum() {
        return paysum;
    }

    public void setPaysum(float paysum) {
        this.paysum = paysum;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPayby() {
        return payby;
    }

    public void setPayby(String payby) {
        this.payby = payby;
    }

    public int getAt() {
        return at;
    }

    public void setAt(int at) {
        this.at = at;
    }

    public String getXminfid() {
        return xminfid;
    }

    public void setXminfid(String xminfid) {
        this.xminfid = xminfid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    /**
     * @function: 账单编号
     * @param:
     * @return:
     * @note:
     */
    public String xmbillid() {

        String id = new String();
        //顺序码
        Dao dao =  Mvcs.getIoc().get((Dao.class));
        try {
            return  id =  Mvcs.getIoc().get(NumberUtil.class).XmbillidGenerator(this.getXminfid());
        }catch (Exception e){
            Logs.get().debug("账单编号生产错误："+e);
        }

        return id;
    }
}
