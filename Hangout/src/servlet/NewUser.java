package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;

import utility.ReturnCodes;
import container.NewUserEventContainer;
import database.Database;
import database.DatabaseConnection;
import database.DatabaseConstants;
import event.LoginEvent;
import event.NewUserEvent;

/**
 * Servlet implementation class NewUser
 */
@WebServlet("/NewUser")
public class NewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*PrintWriter writer = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		writer.println("Username: " + username);
		writer.println("Password: " + password);
		writer.close();*/
		
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
		
		NewUserEvent event = new NewUserEvent();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if (Database.createInstance(username, null).getAccountPassword(username).equals("")) {
			event.setTimeUserCreated(System.currentTimeMillis());
			event.setUsername(username);
			event.setPassword(password);
			
			NewUserEventContainer container = new NewUserEventContainer();
			container.setEvent(event);
			
			dbClient.save(container);
			writer.println(ReturnCodes.NEW_USER_SUCCESS);
		} 
		else {
			writer.println(ReturnCodes.NEW_USER_USERNAME_ALREADY_EXISTS);
		}
		//https://3b8d7b13-d98d-4bb1-9451-12c2c57a6e29-bluemix.cloudant.com/hangout/_design/user/_list/listuser/getuser?key=%22test%22
	}

}
