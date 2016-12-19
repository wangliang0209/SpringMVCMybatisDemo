package com.wl.base.exception;

import com.wl.base.common.CodeConstans;
import com.wl.base.common.Constants;
import com.wl.base.common.json.FastJsonUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangliang on 16-12-19.
 */
public class GlobalExceptionResolver implements HandlerExceptionResolver {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {
        //1.默认500错误
        Map<String, Object> map = new HashMap<String, Object>();
        // 异常后台信息
        map.put("exception", ex.getMessage());
        // 异常编码
        map.put("code", CodeConstans.ERROR_500.getCode());
        // 异常前端信息
        map.put("msg", CodeConstans.ERROR_500.getMsg());
        //2.自定义异常时输出详细错误信息
        if (ex instanceof GlobalException) {
            GlobalException e = (GlobalException) ex;
            map.put("code", e.getCode());
            map.put("msg", e.getMessage());
        }
        // 日志记录异常message和stackTrace
        logger.error(map.get("message") + "", ex);
        // 处理异步请求
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
            pw.write(FastJsonUtils.map2Json(map));
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pw != null)
                pw.close();
        }
        request.setAttribute(Constants.CUSTOM_ERROR, map);
        return null;
    }
}
