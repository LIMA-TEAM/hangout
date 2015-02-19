package servlet.helpers.event;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;
import servlet.helpers.ServletRequestHandler;
import utility.ActionCodes;
import utility.ReturnCodes;

public class GetEventInfoRequestHandler implements ServletRequestHandler {

	private final int code = ActionCodes.GET_EVENT_INFO_ACTION;
	
	@Override
	public int getRequestActionCode() {
		return code;
	}

	@Override
	public void handleGetRequest(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/json");
		response.setStatus(200);
	      
		PrintWriter writer;
		try {
			writer = response.getWriter();
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
		} catch (IOException e) {
			e.printStackTrace();
		}
       
	}

	@Override
	public void handlePostRequest(HttpServletRequest request,
			HttpServletResponse response) {
		
	}

}
