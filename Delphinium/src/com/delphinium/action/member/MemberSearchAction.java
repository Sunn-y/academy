package com.delphinium.action.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.delphinium.dao.MemberDAO;
import com.delphinium.dto.MemberVO;
import com.delphinium.util.Action;

public class MemberSearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/member/searchMemberList.jsp";

		String where = request.getParameter("where");
		String query = request.getParameter("query");

		MemberDAO mDao = MemberDAO.getInstance();
		ArrayList<MemberVO> mVoQueryList = mDao.memberSearch(where, query);

		request.setAttribute("mVoQueryList", mVoQueryList);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
