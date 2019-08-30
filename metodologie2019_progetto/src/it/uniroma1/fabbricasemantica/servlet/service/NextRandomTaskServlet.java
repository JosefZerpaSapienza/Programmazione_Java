package it.uniroma1.fabbricasemantica.servlet.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.data.StandardTask;
import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

@WebServlet(name = "NextRandomServlet", urlPatterns = "/nextTask.jsp")
public class NextRandomTaskServlet extends BaseServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// reinderizzare a un task a caso.
		StandardTask nextTask = StandardTask.getRandomTask();
		response.sendRedirect(nextTask.getTaskUrl());
	}

}
