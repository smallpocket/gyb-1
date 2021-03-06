package cn.wizzer.app.xm.modules.models;

import cn.wizzer.app.gy.modules.services.impl.GyInfServiceImpl;
import cn.wizzer.app.gz.modules.models.gz_inf;
import cn.wizzer.app.library.modules.models.lib_task;
import cn.wizzer.app.web.commons.util.NumberUtil;
import cn.wizzer.app.xm.modules.services.Impl.XmTaskServiceImpl;
import cn.wizzer.framework.base.model.BaseModel;
import cn.wizzer.framework.util.DateUtil;
import org.nutz.dao.DB;
import org.nutz.dao.Dao;
import org.nutz.dao.entity.annotation.*;
import org.nutz.log.Logs;
import org.nutz.mvc.Mvcs;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by 89792 on 2017/11/17 0017.
 */

@Table("xm_task")
@View("v_xmtask")
public class xm_task extends BaseModel implements Serializable {

    @Column
    @Name
    @Comment("任务书编号")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    @Prev(els = {@EL("$me.taskid()")})
    private String id;

    @Column
    @Comment("任务书名称")
    @ColDefine(type = ColType.VARCHAR, width = 100)
    private String taskname;

    @Column
    @Comment("原始订单编号")
    @ColDefine(type = ColType.VARCHAR, width = 100)
    private String original_order;

    @Column
    @Comment("任务书种类编号")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String category;

    @Column
    @Comment("酬金")
    @ColDefine(type = ColType.FLOAT)
    private float award;

    @Column
    @Comment("设计方案")
    @ColDefine(type = ColType.INT)
    private Integer designnum;

    @Column
    @Comment("发布者编号")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String author;

    @Column
    @Comment("终稿时间")
    @ColDefine(type = ColType.INT)
    private Integer endtime;

    @Column
    @Comment("初稿时间")
    @ColDefine(type = ColType.INT)
    private Integer firstcommit;

    @Column
    @Comment("申报截止时间")
    @ColDefine(type = ColType.INT)
    private Integer applyendtime;

    @Column
    @Comment("任务书摘要")
    @ColDefine(type = ColType.VARCHAR, width = 500)
    private String info;

    @Column
    @Comment("任务书内容")
    @ColDefine(type = ColType.TEXT)
    private String content;

    @Column
    @Comment("发布时间")
    @ColDefine(type = ColType.INT)
    private Integer publishAt;

    @Column
    @Comment("阅读次数")
    @ColDefine(type = ColType.INT)
    private Integer readnum;

    @Column
    @Comment("排序字段")
    @Prev({
            @SQL(db= DB.MYSQL,value = "SELECT IFNULL(MAX(location),0)+1 FROM cms_article"),
            @SQL(db= DB.ORACLE,value = "SELECT COALESCE(MAX(location),0)+1 FROM cms_article")
    })
    private Integer location;

    @Column
    @Comment("附件")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String fileurl;

    @Column
    @Comment("是否禁用")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean disabled;

    @Column
    @Comment("状态")
    @ColDefine(type = ColType.INT)
    private int status;

    // 试图
    @Column
    @Readonly
    private String xmtaskstatus;

    @Column
    @Readonly
    private String authorrealname;

    //参照
    @One(field = "category")
    private lib_task libtask;

    @One(field = "author")
    private gz_inf gzinf;

    @Many(field = "xmtaskid")
    private List<xm_limit> xmlimits;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getAward() {
        return award;
    }

    public void setAward(float award) {
        this.award = award;
    }

    public Integer getDesignnum() {
        return designnum;
    }

    public void setDesignnum(Integer designnum) {
        this.designnum = designnum;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getEndtime() {
        return endtime;
    }

    public void setEndtime(Integer endtime) {
        this.endtime = endtime;
    }

    public Integer getFirstcommit() {
        return firstcommit;
    }

    public void setFirstcommit(Integer firstcommit) {
        this.firstcommit = firstcommit;
    }

    public Integer getApplyendtime() {
        return applyendtime;
    }

    public void setApplyendtime(Integer applyendtime) {
        this.applyendtime = applyendtime;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPublishAt() {
        return publishAt;
    }

    public void setPublishAt(Integer publishAt) {
        this.publishAt = publishAt;
    }

    public Integer getReadnum() {
        return readnum;
    }

    public void setReadnum(Integer readnum) {
        this.readnum = readnum;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public lib_task getLibtask() {
        return libtask;
    }

    public void setLibtask(lib_task libtask) {
        this.libtask = libtask;
    }

    public gz_inf getGzinf() {
        return gzinf;
    }

    public void setGzinf(gz_inf gzinf) {
        this.gzinf = gzinf;
    }

    public List<xm_limit> getXmlimits() {
        return xmlimits;
    }

    public void setXmlimits(List<xm_limit> xmlimits) {
        this.xmlimits = xmlimits;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getXmtaskstatus() {
        return xmtaskstatus;
    }

    public void setXmtaskstatus(String xmtaskstatus) {
        this.xmtaskstatus = xmtaskstatus;
    }

    public String getAuthorrealname() {
        return authorrealname;
    }

    public void setAuthorrealname(String authorrealname) {
        this.authorrealname = authorrealname;
    }

    public String getOriginal_order() {
        return original_order;
    }

    public void setOriginal_order(String original_order) {
        this.original_order = original_order;
    }

    /**
     * @function: 雇员编号
     * @param:
     * @return:
     * @note: 编号说明:17年份,10497学校代码,0学历:(0本科1研究生2博士),0性别 (0女生 ,1男生),010顺序码
     */
    public String taskid() {
        String id = new String();
        //顺序码
        Dao dao =  Mvcs.getIoc().get((Dao.class));
        XmTaskServiceImpl xmTaskService = new XmTaskServiceImpl(dao);
        try {
            int count = Mvcs.getIoc().get(XmTaskServiceImpl.class).count();
            return  id =  Mvcs.getIoc().get(NumberUtil.class).XmtaskidGenerator(count,dao.fetch(lib_task.class,this.category).getUnitcode());
        }catch (Exception e){
            Logs.get().debug(e);
        }
        return id;
    }
}
