package com.delphinium.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.delphinium.dao.BoardDAO;
import com.delphinium.util.Action;

public class PromotionDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int b_num = Integer.parseInt(request.getParameter("b_num"));

		BoardDAO bDao = BoardDAO.getInstance();
		bDao.boardDelete(1, b_num);

		new PromotionListAction().execute(request, response);
	}

}
