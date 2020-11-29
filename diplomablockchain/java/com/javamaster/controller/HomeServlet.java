package com.javamaster.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blockchain.AddData;
import blockchain.Block;

public class HomeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.equals("/")) {			
			request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
		} else if (path.equals("/welcome")) {
			request.getRequestDispatcher("/WEB-INF/view/welcome.jsp").forward(request, response);
		} else if (path.equals("/create")) {
			getServletContext().getRequestDispatcher("/WEB-INF/view/create.jsp").forward(request, response);

		}else  {
			 getServletContext().getRequestDispatcher("/WEB-INF/view/notfound.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.equals("/create")) {
			try {
				String name = request.getParameter("name");
				String surname = request.getParameter("surname");
				int mark = Integer.parseInt(request.getParameter("mark"));
				String markl = request.getParameter("markl");
				
				Block block = new Block(name, surname, mark, markl);
				
				AddData addData=  new AddData();
				addData.addBlock(block);
				
				response.sendRedirect(request.getContextPath()+"/welcome");
			} catch (Exception ex) {

				getServletContext().getRequestDispatcher("/WEB-INF/view/create.jsp").forward(request, response);
			}
		}
		
		
	}
}