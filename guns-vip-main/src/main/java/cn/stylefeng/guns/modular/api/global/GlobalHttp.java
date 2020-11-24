package cn.stylefeng.guns.modular.api.global;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author ：Super张
 * @date ：Created in 2020-10-30 10:22
 * @description：
 * @modified By：
 * @version:
 */
public class GlobalHttp {

    public static HttpServletRequest getHttpservletRequest(){
        //将拿到的token放到session中，
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes())
                .getRequest();
        return request;
    }

    public static HttpSession getHttpSession(){
        return getHttpservletRequest().getSession();
    }

}
