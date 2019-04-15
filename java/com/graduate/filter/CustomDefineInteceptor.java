package com.graduate.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 
 * @Discription: TODO    
 * @Author: JiangChunLin  
 * @ClassName: CustomDefineInteceptor  
 * @Date: 2019年3月12日 下午4:35:20  
 * @Version: 1.0.0 Graduate
 */
@Component
public class CustomDefineInteceptor implements HandlerInterceptor {
	/**
	 * 
	 *  @Description: 完成后渲染前
	 *  @Author: JiangChunLin
	 *  @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	/**
	 * 
	 *  @Description: 方法完成后
	 *  @Author: JiangChunLin
	 *  @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	/**
	 * 
	 *  @Description: 进入处理方法前
	 *  @Author: JiangChunLin
	 *  @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		System.out.println("拦截器: "+request.getRequestURI());
//		HttpSession session=request.getSession();
//		String webHasLogin=(String) session.getAttribute("webBrowseLogin");
//		String account=request.getHeader("account");
//		String miniAppHasLogin=(String) request.getServletContext().getAttribute("miniApp"+account);
//		boolean flag=false;
//		System.out.println("success".equals(webHasLogin));
//		if(StringUtils.hasLength(webHasLogin)){
//			if("success".equals(webHasLogin)){
//				flag=true;
//			}
//		}else if(StringUtils.hasLength(miniAppHasLogin)){
//			if(miniAppHasLogin.equals("success")){
//				flag=true;
//			}
//		}
//		if(!flag){
//			request.getRequestDispatcher("/").forward(request, response);
//		}
//		
//		return flag;
		return true;
	}
	
}
