package br.com.escola.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginAdminInterceptor extends HandlerInterceptorAdapter {

		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
				Object handler) throws Exception {
			HttpSession session = request.getSession();
			if (session.getAttribute("adminLogado") == null) {
				response.sendRedirect("/admin");
				return false;
			}
			return true;
		}
}