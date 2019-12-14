package cn.edut.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edut.domain.User;
import cn.edut.service.UserService;
import cn.edut.service.imp.UserServiceImp;

/**
 * Servlet implementation class TestServlet
 */
public class UserListService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserListService() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 转发查找到的信息
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//不加这个，有中文，一定乱码
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		UserService userService = new UserServiceImp();
		List<User> userList = userService.finAll();
		System.out.println(userList);
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
