package com.wl.aspect;

import com.wl.base.utils.LogUtils;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 类名称：	ApiControllerLogAspect
 * 类描述：	统一日志处理
 *
 * @version 1.0.0
 */
@Aspect
@Component
public class ApiControllerLogAspect {
    // 注意切入的方法一定要为public的，否则切入失败
    @Pointcut("execution(* com.wl.controller.*Controller.*(..))")
    public void pointCut() {
    }

    @Pointcut("execution(* com.wl.controller.api.*Controller.*(..))")
    public void pointCutApi() {
    }

    /**
     * 记录controller的操作日志
     *
     * @throws Exception
     */
    @Before("pointCut()")
    public void beforeController() throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();

        LogUtils.logAspectControllerBegin(request);
    }

    /**
     * 记录controller的操作日志
     *
     * @throws Exception
     */
    @Before("pointCutApi()")
    public void beforeApiController() throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        LogUtils.logAspectControllerBegin(request);
    }

    /**
     * 拦截controller层所有带有注解的方法
     *
     * @throws Exception
     */
    @AfterReturning("pointCut()")
    public void AfterReturning() throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        LogUtils.logAspectControllerEnd(request);
    }

    /**
     * 拦截controller层所有带有注解的方法
     *
     * @throws Exception
     */
    @AfterReturning("pointCutApi()")
    public void AfterApiReturning() throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        LogUtils.logAspectControllerEnd(request);
    }

}
