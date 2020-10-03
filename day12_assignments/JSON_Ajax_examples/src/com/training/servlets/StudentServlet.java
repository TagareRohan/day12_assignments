package com.training.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.entity.Student;
import com.training.services.StudentServiceImpl;
import com.training.utils.MyGsonParser;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int studentId=0;
	String studentName=null;

    /**
     * Default constructor. 
     */
    public StudentServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		
		response.setContentType("application/json");
		
//		String employee="{'id':101,'name':'ram'}";
//		
//		//out.println("<h1>Using JSON</h1>");
//		
//		out.println(employee);
		
		StudentServiceImpl service=new StudentServiceImpl();
		service.init();
		//Student student=service.findById(1);
		
		
		
//		for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
//		    i += pair.getKey() + pair.getValue();
//		}
		
		
		
		
//		MyGsonParser parser=new MyGsonParser();
//		
//		String jsonResp=parser.transformToGson(student);
//		
//		out.println(jsonResp);
//		
//		String jsonRep=parser.transformToGson(service.findAll());
//		
//		out.println(jsonRep);
		
		//****************************************//
		
		studentId=Integer.parseInt(request.getParameter("studentId"));
		studentName=service.findById(studentId).getStudentName();
		
		
		out=response.getWriter();
		
		response.setContentType("application/json");
		
		out.println(studentName);
		
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		String name=request.getParameter("name");
		//int Id=Integer.parseInt(request.getParameter("studentId"));
		
		System.out.println(name);
		
		request.setAttribute("studentName", name);
		//request.setAttribute("studentId", Id);
		
		RequestDispatcher disp=request.getRequestDispatcher("studentInfo.jsp");
		disp.forward(request, response);
		
		//doGet(request, response);
	}

}
