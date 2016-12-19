package com.wl.base.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangliang on 16-12-19.
 */
public class SessionUtils {

    public static boolean isLogined(HttpServletRequest req) {
        if (req != null && req.getSession() != null) {
            return req.getSession().getAttribute("user_id") != null;
        }

        return false;
    }

    public static void setUserId(HttpServletRequest req, String account) {
        req.getSession().setAttribute("user_id", account);
    }
}
