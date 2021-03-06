package cn.wizzer.app.web.modules.controllers.platform.xm;

import cn.wizzer.app.xm.modules.services.XmPrepayService;
import cn.wizzer.app.web.commons.slog.annotation.SLog;
import cn.wizzer.app.xm.modules.models.xm_prepay;
import cn.wizzer.framework.base.Result;
import cn.wizzer.framework.page.datatable.DataTableColumn;
import cn.wizzer.framework.page.datatable.DataTableOrder;
import cn.wizzer.framework.util.StringUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@IocBean
@At("/platform/xm/prepay")
public class XmPrepayController{
    private static final Log log = Logs.get();

    @Inject
    private XmPrepayService xmPrepayService;

    @At("")
    @Ok("beetl:/platform/xm/prepay/index.html")
    @RequiresPermissions("platform.xm.prepay")
    public void index() {
    }

    @At("/data")
    @Ok("json")
    @RequiresPermissions("platform.xm.prepay")
    public Object data(@Param("length") int length, @Param("start") int start, @Param("draw") int draw, @Param("::order") List<DataTableOrder> order, @Param("::columns") List<DataTableColumn> columns) {
		Cnd cnd = Cnd.NEW();
    	return xmPrepayService.data(length, start, draw, order, columns, cnd, null);
    }

    @At("/add")
    @Ok("beetl:/platform/xm/prepay/add.html")
    @RequiresPermissions("platform.xm.prepay")
    public void add() {

    }

    @At("/addDo")
    @Ok("json")
    @RequiresPermissions("platform.xm.prepay.add")
    @SLog(tag = "xm_prepay", msg = "${args[0].id}")
    public Object addDo(@Param("..")xm_prepay xmPrepay, HttpServletRequest req) {
		try {
			xmPrepayService.insert(xmPrepay);
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }

    @At("/edit/?")
    @Ok("beetl:/platform/xm/prepay/edit.html")
    @RequiresPermissions("platform.xm.prepay")
    public void edit(String id,HttpServletRequest req) {
		req.setAttribute("obj", xmPrepayService.fetch(id));
    }

    @At("/editDo")
    @Ok("json")
    @RequiresPermissions("platform.xm.prepay.edit")
    @SLog(tag = "xm_prepay", msg = "${args[0].id}")
    public Object editDo(@Param("..")xm_prepay xmPrepay, HttpServletRequest req) {
		try {
            xmPrepay.setOpBy(StringUtil.getUid());
			xmPrepay.setOpAt((int) (System.currentTimeMillis() / 1000));
			xmPrepayService.updateIgnoreNull(xmPrepay);
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }

    @At({"/delete/?", "/delete"})
    @Ok("json")
    @RequiresPermissions("platform.xm.prepay.delete")
    @SLog(tag = "xm_prepay", msg = "${req.getAttribute('id')}")
    public Object delete(String id, @Param("ids")  String[] ids, HttpServletRequest req) {
		try {
			if(ids!=null&&ids.length>0){
				xmPrepayService.delete(ids);
    			req.setAttribute("id", org.apache.shiro.util.StringUtils.toString(ids));
			}else{
				xmPrepayService.delete(id);
    			req.setAttribute("id", id);
			}
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/detail/?")
    @Ok("beetl:/platform/xm/prepay/detail.html")
    @RequiresPermissions("platform.xm.prepay")
	public void detail(String id, HttpServletRequest req) {
		if (!Strings.isBlank(id)) {
            req.setAttribute("obj", xmPrepayService.fetch(id));
		}else{
            req.setAttribute("obj", null);
        }
    }

}
