package cn.wizzer.app.gy.modules.services.impl;

import cn.wizzer.app.gy.modules.models.gy_inf;
import cn.wizzer.app.gy.modules.services.GyPayService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.gy.modules.models.gy_pay;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class GyPayServiceImpl extends BaseServiceImpl<gy_pay> implements GyPayService {
    public GyPayServiceImpl(Dao dao) {
        super(dao);
    }

    public gy_pay getFirstPay(String gyid){
        return this.fetch(Cnd.where("gyid","=",gyid).and("first","=",true));
    }

    public gy_inf getGyByPayid(String payid){
        gy_pay pay = this.fetch(payid);
        pay = this.fetchLinks(pay,"gy");
        return pay.getGy();
    }
}
