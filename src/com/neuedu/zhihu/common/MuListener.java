package com.neuedu.zhihu.common;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * jsp 九大内置对象
 */

public class MuListener implements HttpSessionListener{
    private int sun=0;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        sun++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
