package com.vilens.linzi.em.crm.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用于封装 Request 与 Response 对象
 *
 * @since 1.0.0
 */
public class WebContext {

    private static ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<HttpServletRequest>();
    private static ThreadLocal<HttpServletResponse> responseHolder = new ThreadLocal<HttpServletResponse>();

    /**
     * 初始化
     */
    public static void init(HttpServletRequest request, HttpServletResponse response) {
        requestHolder.set(request);
        responseHolder.set(response);
    }

    /**
     * 销毁
     */
    public static void destroy() {
        requestHolder.remove();
        responseHolder.remove();
    }

    /**
     * 获取 Request 对象
     */
    public static HttpServletRequest getRequest() {
        return requestHolder.get();
    }

    /**
     * 获取 Response 对象
     */
    public static HttpServletResponse getResponse() {
        return responseHolder.get();
    }
}
