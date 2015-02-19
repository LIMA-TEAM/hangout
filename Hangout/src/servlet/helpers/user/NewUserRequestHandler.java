package servlet.helpers.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.helpers.ServletRequestHandler;
import utility.ActionCodes;
import utility.ReturnCodes;
import database.Database;
import event.NewUserEvent;

public class NewUserRequestHandler implements ServletRequestHandler {

	private final int code = ActionCodes.NEW_USER_ACTION;
	
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
			Database db = Database.createInstance(null, null);
			NewUserEvent event = new NewUserEvent();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String id = UUID.randomUUID().toString();
			
			event.setTimeUserCreated(System.currentTimeMillis());
			event.setUsername(username);
			event.setEncryptedPassword(password);
			event.setId(id);
			event.setName(name);
			
			writer.print(db.saveNewUser(event));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getRequestActionCode() {
		return code;
	}

}
