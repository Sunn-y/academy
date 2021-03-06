package com.delphinium.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.delphinium.dao.MemberDAO;
import com.delphinium.util.Action;

public class ConIDCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/member/conIDCheck.jsp";

		String userID = request.getParameter("userID");

		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.confirmID(userID);

		request.setAttribute("userID", userID);
		request.setAttribute("result", result);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
