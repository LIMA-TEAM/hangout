package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;

import utility.ReturnCodes;
import container.NewEventEventContainer;
import container.NewUserEventContainer;
import database.Database;
import database.DatabaseConstants;
import event.NewEventEvent;

/**
 * Servlet implementation class NewEvent
 */
@WebServlet("/NewEvent")
public class NewEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewEvent() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json");
		response.setStatus(200);
	      
		PrintWriter writer = response.getWriter();
			
		CouchDbProperties properties = new CouchDbProperties()
		  .setDbName(DatabaseConstants.DB_NAME)
		  .setCreateDbIfNotExist(false)
		  .setProtocol("https")
		  .setHost(DatabaseConstants.HOST)
		  .setPort(443)
		  .setUsername(DatabaseConstants.USERNAME)
		  .setPassword(DatabaseConstants.PASSWORD)
		  .setMaxConnections(100)
		  .setConnectionTimeout(0);
		
		CouchDbClient dbClient = new CouchDbClient(properties);
		
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
		
		NewEventEventContainer container = new NewEventEventContainer();
		container.setEvent(event);
		
		dbClient.save(container);
		writer.print(ReturnCodes.NEW_EVENT_SUCCESS);
	}

}
