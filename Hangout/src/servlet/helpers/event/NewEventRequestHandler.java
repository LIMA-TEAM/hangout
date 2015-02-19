package servlet.helpers.event;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;
import event.NewEventEvent;
import servlet.helpers.ServletRequestHandler;
import utility.ActionCodes;
import utility.ReturnCodes;

public class NewEventRequestHandler implements ServletRequestHandler {

	private final int code = ActionCodes.NEW_EVENT_ACTION;
	
	@Override
	public int getRequestActionCode() {
		return code;
	}

	@Override
	public void handleGetRequest(HttpServletRequest request,
			HttpServletResponse response) {

	}

	@Override
	public void handlePostRequest(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/json");
		response.setStatus(200);
	      
		PrintWriter writer;
		try {
			writer = response.getWriter();
			NewEventEvent event = new NewEventEvent();
			String title = request.getParameter("title");
			String hostId = request.getParameter("host");
			String lat = request.getParameter("lat");
			String lon = request.getParameter("lon");
			String startTimeString = request.getParameter("startTime");
			String endTimeString = request.getParameter("endTime");
			long startTime = Long.parseLong(startTimeString);
			long endTime = Long.parseLong(endTimeString);
			String id = UUID.randomUUID().toString();
			
			event.setId(id);
			event.setStartTime(startTime);
			event.setEndTime(endTime);
			event.setHostId(hostId);
			event.setTitle(title);
			event.setLat(Double.parseDouble(lat));
			event.setLon(Double.parseDouble(lon));
			
			writer.print(Database.createInstance(null, null).saveNewEvent(event));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
			
}
