package servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.loginDao;
import entity.User;

public class LoginServlet extends HttpServlet {
	private User userseachAll;

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			String username = request.getParameter("name");
			String password = request.getParameter("password");
			int time = Integer.parseInt(request.getParameter("time"));

			User seacrchUser = new User();
			seacrchUser.setName(username);
			seacrchUser.setPassword(password);
			loginDao ld = new loginDao();
			User user = ld.seachAll(userseachAll);

			if (user != null) {

				Cookie cookie = new Cookie("name", user.getName());
				if (time == 1) {
					cookie.setMaxAge(0);

				} else if (time == 2) {
					cookie.setMaxAge(30);

				} else if (time == 3) {
					cookie.setMaxAge(60);

				}

				cookie.setMaxAge(30);// √Î
				response.addCookie(cookie);

				try {
					response.sendRedirect("1.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}// ÷ÿ∂®œÚ
					// request.getRequestDispatcher("1.jsp")
					// .forward(request, response);
			} else {
				try {
					response.sendRedirect("2.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);

	}

}
