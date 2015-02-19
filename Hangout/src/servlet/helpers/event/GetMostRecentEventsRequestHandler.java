package servlet.helpers.event;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;
import servlet.helpers.ServletRequestHandler;
import utility.ActionCodes;
import utility.ReturnCodes;

public class GetMostRecentEventsRequestHandler implements ServletRequestHandler {

	private final int code = ActionCodes.GET_MOST_RECENT_EVENTS_ACTION;
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
			int count = Integer.parseInt(request.getParameter("count"));
			Database db = Database.createInstance(null, null);
			
			writer.print(db.getMostRecentEventsJson(count));
			
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
