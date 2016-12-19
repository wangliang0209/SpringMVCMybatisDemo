package com.wl.base.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangliang on 16-12-19.
 */
public class LogUtils {
    private static Logger logger = LoggerFactory.getLogger(LogUtils.class);

    public static void logAspectControllerBegin(HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        logger.info("------------------------------begin----------------------------------");
        logger.info("{}", new Object[]{url});

        Map<String, String> params = new HashMap<String, String>();
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            params.put(name, request.getParameter(name));
        }

        logger.info("{}\tparams[{}]", new Object[]{url, params});

        Map<String, String> heads = new HashMap<String, String>();
        Enumeration<String> names1 = request.getHeaderNames();
        while (names1.hasMoreElements()) {
            String name = names1.nextElement();
            heads.put(name, request.getHeader(name));
        }

        logger.info("{}\theads[]", url, heads);
    }

    /**
     * logAspectControllerEnd(controller层日志记录结束)
     *
     * @param request HTTP请求对象
     */
    public static void logAspectControllerEnd(HttpServletRequest request) {
        logger.info("------------------------------api end----------------------------------");
    }
}
