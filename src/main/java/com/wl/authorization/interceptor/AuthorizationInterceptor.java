package com.wl.authorization.interceptor;

import com.wl.authorization.annotation.Authorization;
import com.wl.base.utils.ResponseUtils;
import com.wl.token.service.TokenService;
import org.springframework.http.MediaType;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;

/**
 * 自定义拦截器，对请求进行身份验证
 */
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
    /**
     * 存放登录用户模型Key的Request Key
     */
    public static final String REQUEST_CURRENT_KEY = "REQUEST_CURRENT_KEY";

    //管理身份验证操作的对象
    private TokenService manager;

    //存放鉴权信息的Header名称，默认是Authorization
    private String httpHeaderName = "Authorization";

    //鉴权信息的无用前缀，默认为空
    private String httpHeaderPrefix = "";

    //鉴权失败后返回的错误信息，默认为401 unauthorized
    private String unauthorizedErrorMessage = "401 unauthorized";

    //鉴权失败后返回的HTTP错误码，默认为401
    private int unauthorizedErrorCode = HttpServletResponse.SC_UNAUTHORIZED;

    public void setManager(TokenService manager) {
        this.manager = manager;
    }

    public void setHttpHeaderName(String httpHeaderName) {
        this.httpHeaderName = httpHeaderName;
    }

    public void setHttpHeaderPrefix(String httpHeaderPrefix) {
        this.httpHeaderPrefix = httpHeaderPrefix;
    }

    public void setUnauthorizedErrorMessage(String unauthorizedErrorMessage) {
        this.unauthorizedErrorMessage = unauthorizedErrorMessage;
    }

    public void setUnauthorizedErrorCode(int unauthorizedErrorCode) {
        this.unauthorizedErrorCode = unauthorizedErrorCode;
    }

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        //如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        //从header中得到token
        String token = (String) request.getParameter("token");
        System.out.println("token >>> " + token);
        if (token != null && manager.validateToken(token)) {
            request.setAttribute(REQUEST_CURRENT_KEY, manager.getKeyByToken(token));
            return true;
        }
        //如果验证token失败，并且方法注明了Authorization，返回401错误
        if (method.getAnnotation(Authorization.class) != null   //查看方法上是否有注解
                || handlerMethod.getBeanType().getAnnotation(Authorization.class) != null) {    //查看方法所在的Controller是否有注解
            response.setStatus(HttpServletResponse.SC_OK);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(response.getOutputStream()));
            writer.write(ResponseUtils.generFailedJsonStr(HttpServletResponse.SC_UNAUTHORIZED,
                    unauthorizedErrorMessage));
            writer.close();
            return false;
        }
        //为了防止以恶意操作直接在REQUEST_CURRENT_KEY写入key，将其设为null
        request.setAttribute(REQUEST_CURRENT_KEY, null);
        return true;
    }
}
