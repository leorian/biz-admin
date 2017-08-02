package com.bozhong.biz.admin.view.admin.module.screen;

import com.bozhong.config.util.CookiesUtil;
import com.bozhong.biz.admin.common.BizAdminConstants;
import com.bozhong.biz.admin.common.WebSettingParam;
import com.bozhong.myredis.MyRedisClusterForHessian;
import com.yx.eweb.main.EWebContext;
import com.yx.eweb.main.ScreenInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xiezg@317hu.com on 2016/12/30 0030.
 */
@Controller
public class Login implements ScreenInter {

    @Autowired
    private MyRedisClusterForHessian myRedisClusterForHessian;

    @Override
    public void excute(EWebContext eWebContext) {
        eWebContext.put("html_title", WebSettingParam.HTML_TITLE);
        eWebContext.put("biz_admin_crop", WebSettingParam.CORP);
        eWebContext.put("biz_admin_department", WebSettingParam.DEPARTMENT);
        System.out.println("Login当前线程：" + Thread.currentThread().getName());
        HttpServletRequest request = eWebContext.getRequest();
        HttpServletResponse response = eWebContext.getResponse();
        Cookie tokenCookie = CookiesUtil.getCookieByName(request, "biz_admin_token");
        if (tokenCookie != null) {
            String token = tokenCookie.getValue();
            tokenCookie = new Cookie("biz_admin_token", null);
            tokenCookie.setPath("/");
            tokenCookie.setMaxAge(0);
            response.addCookie(tokenCookie);
            myRedisClusterForHessian.delForStr(BizAdminConstants.BIZ_ADMIN_CENTER_USERNAME_PREFIX + token);
        }

    }
}
