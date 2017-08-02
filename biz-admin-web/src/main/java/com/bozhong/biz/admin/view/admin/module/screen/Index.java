package com.bozhong.biz.admin.view.admin.module.screen;

import com.yx.eweb.main.EWebContext;
import com.yx.eweb.main.ScreenInter;
import org.springframework.stereotype.Controller;

/**
 * Created by xiezg@317hu.com on 2017/8/2 0002.
 */
@Controller
public class Index implements ScreenInter {
    @Override
    public void excute(EWebContext eWebContext) {
        System.out.println("主页面");
    }
}
