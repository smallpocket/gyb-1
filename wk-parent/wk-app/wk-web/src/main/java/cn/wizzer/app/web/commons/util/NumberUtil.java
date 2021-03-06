package cn.wizzer.app.web.commons.util;

import cn.wizzer.framework.util.DateUtil;
import org.nutz.ioc.loader.annotation.IocBean;

import java.util.Date;



//单例用户模式参考链接
// http://blog.csdn.net/csdn759322423/article/details/70230076
/**
 * 自用编号生产器
 *
 * @Author Marveliu
 * @Create 2018/1/6 0006.
 */


@IocBean
public class NumberUtil {

    /**
     * 根据时间生成唯一雇员编号
     * @param num
     * @param schoolcode
     * @param stulevel
     * @param sex
     * @return
     */

    public String GyIdGeneraotr(int num,String schoolcode,int stulevel,String sex){
        int number=10+(int)(Math.random()*90);
        StringBuilder str = new StringBuilder();
        str.append("gy");
        str.append(DateUtil.format(new Date(),"yyyyMMdd").substring(2,6));
//        str.append(schoolcode);
//        str.append(stulevel);
//        str.append(sex);
        str.append(number);
        return str.toString();
    }



    /**
     * 雇员验证id
     * @param gyid
     * @return
     */
    public String GyAuthIdGeneraotr(String gyid){
        StringBuilder str = new StringBuilder();
        str.append("Au");
        str.append(gyid);
        return str.toString();
    }


    /**
     * 根据时间生成唯一员工编号
     * @param num
     * @param sex
     * @return
     */
    public String GyberIdGeneraotr(int num,String sex){
        StringBuilder str = new StringBuilder();
        str.append("gyb");
        str.append(DateUtil.format(new Date(),"yyyy").substring(0,4));
        str.append(sex);
        str.append(num);
        return str.toString();
    }


    /**
     * 根据时间生成唯一员工编号
     * @param num
     * @param sex
     * @return
     */
    public String GzIdGeneraotr(int num,String sex){
        StringBuilder str = new StringBuilder();
        str.append("gz");
        str.append(DateUtil.format(new Date(),"yyyy").substring(0,4));
        str.append(sex);
        str.append(num);
        return str.toString();
    }


    /**
     * 任务书编号生成
     * @param num
     * @param category
     * @return
     */
    public String XmtaskidGenerator(int num,String category){
        StringBuilder str = new StringBuilder();
        str.append("rws_");
        str.append(category);
        str.append(DateUtil.format(new Date(),"yyyyMMdd").substring(0,8));
        str.append(num);
        return str.toString();
    }


    /**
     * 任务申请单编号生成
     * @param num
     * @param task
     * @return
     */
    public String XmapplyidGenerator(int num,String task){
        StringBuilder str = new StringBuilder();
        str.append("apply");
        String[] arr = task.split("_");
        str.append(arr[1]);
        str.append(num);
        return str.toString();
    }


    /**
     * 任务编号生成
     * @param num
     * @param task
     * @return
     */
    public String XminfidGenerator(int num,String task){
        StringBuilder str = new StringBuilder();
        str.append("rw_");
        String[] arr = task.split("_");
        str.append(arr[1]);
        str.append(num);
        return str.toString();
    }


    /**
     * 任务反馈编号生成
     * @param num
     * @param xminfid
     * @return
     */
    public String XfdIdGenerator(int num,String xminfid){
        StringBuilder str = new StringBuilder();
        str.append("fk_");
        String[] arr = xminfid.split("_");
        str.append(arr[1]);
        str.append("_"+num);
        return str.toString();
    }

    /**
     * 账单生成编号
     * @param infid
     * @return
     */
    public String XmbillidGenerator(String infid){
        StringBuilder str = new StringBuilder();
        String[] arr = infid.split("_");
        str.append("bill_");
        str.append(arr[1]);
        return str.toString();
    }


    /**
     * 任务评价单生成编号
     * @param infid
     * @return
     */
    public String XmEvaidGenerator(String infid){
        StringBuilder str = new StringBuilder();
        String[] arr = infid.split("_");
        str.append("eva_");
        str.append(arr[1]);
        return str.toString();
    }


    /**
     * 雇员支付方式编码
     * @param gyid
     * @param num
     * @return
     */
    public String GyPayidGenerator(String gyid,int num){
        StringBuilder str = new StringBuilder();
        str.append("pay"+num+"_");
        str.append(gyid);
        return str.toString();
    }




}
