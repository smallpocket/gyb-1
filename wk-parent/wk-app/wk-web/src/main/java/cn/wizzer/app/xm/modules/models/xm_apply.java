package cn.wizzer.app.xm.modules.models;

import cn.wizzer.app.web.commons.util.NumberUtil;
import cn.wizzer.app.xm.modules.services.Impl.XmTaskServiceImpl;
import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.entity.annotation.*;
import org.nutz.log.Logs;
import org.nutz.mvc.Mvcs;

import java.io.Serializable;

/**
 * Created by 89792 on 2017/11/22 0022.
 * 雇员表和任务书的多对多映射关系表
 */
@Table("xm_apply")
@View("v_xmapply")
public class xm_apply extends BaseModel implements Serializable {

    @Column
    @Name
    @Comment("申请编号")
    @ColDefine(type = ColType.VARCHAR, width = 50)
    @Prev(els = {@EL("$me.xmapplyid()")})
    private String id;

    @Column
    @Comment("雇员编号")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String gyid;

    @Column
    @Comment("任务书编号")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String xmtaskid;

    @Column
    @Comment("申请时间")
    @ColDefine(type = ColType.INT)
    private int at;

    @Column
    @Comment("状态")
    @ColDefine(type = ColType.INT)
    private int status;

    @Column
    @Comment("说明")
    @ColDefine(type = ColType.VARCHAR,width = 200)
    private String note;


    // 视图
    @Column
    @Readonly
    private String applystatus;

    @Column
    @Readonly
    private String taskname;


    @Column
    @Readonly
    private String gyrealname;


    @Column
    @Readonly
    private String author;

    @Column
    @Readonly
    private String authorrealname;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGyid() {
        return gyid;
    }

    public void setGyid(String gyid) {
        this.gyid = gyid;
    }

    public String getXmtaskid() {
        return xmtaskid;
    }

    public void setXmtaskid(String xmtaskid) {
        this.xmtaskid = xmtaskid;
    }

    public int getAt() {
        return at;
    }

    public void setAt(int at) {
        this.at = at;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getApplystatus() {
        return applystatus;
    }

    public void setApplystatus(String applystatus) {
        this.applystatus = applystatus;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getGyrealname() {
        return gyrealname;
    }

    public void setGyrealname(String gyrealname) {
        this.gyrealname = gyrealname;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorrealname() {
        return authorrealname;
    }

    public void setAuthorrealname(String authorrealname) {
        this.authorrealname = authorrealname;
    }

    /**
     * @function: 立项编号
     * @param:
     * @return:
     * @note:
     */
    public String xmapplyid() {

        String id = new String();
        //顺序码
        Dao dao =  Mvcs.getIoc().get((Dao.class));
        try {
            int count = Mvcs.getIoc().get(XmTaskServiceImpl.class).count(Cnd.where("id","=",this.getXmtaskid()));
            return  id =  Mvcs.getIoc().get(NumberUtil.class).XmapplyidGenerator(count,dao.fetch(xm_task.class,this.xmtaskid).getId());
        }catch (Exception e){
            Logs.get().debug(e);
        }

        return id;
    }
}
