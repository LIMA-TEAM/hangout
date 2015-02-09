package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.ReturnCodes;
import database.Database;

/**
 * Servlet implementation class GetEventInfo
 */
@WebServlet("/GetEventInfo")
public class GetEventInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEventInfo() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json");
		response.setStatus(200);
	      
		PrintWriter writer = response.getWriter();
       
		String eventId = request.getParameter("eventId");
		Database connection = Database.createInstance(null, null);
		String eventInfoJson = connection.getEventJson(eventId);
		
		if (eventInfoJson.equals("")) {
			writer.print(ReturnCodes.GET_EVENT_DOES_NOT_EXIST);
		}
		else {
			writer.print(eventInfoJson);
		}
		
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
