package servlet.helpers.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;
import servlet.helpers.ServletRequestHandler;
import utility.ActionCodes;
import utility.ReturnCodes;

public class UserLoginRequestHandler implements ServletRequestHandler {

	private final int code = ActionCodes.USER_LOGIN_ACTION;
	
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
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			Database connection = Database.createInstance(username, null);
			String expectedPass = connection.getAccountPassword(username);
			
			if (expectedPass.equals("")) {
				writer.print(ReturnCodes.LOGIN_USERNAME_DOES_NOT_EXIST);
			}
			else if (password.equals(expectedPass)) {
				String id = connection.getUserId(username);
				String name = connection.getUserStringName(id);
				writer.print(ReturnCodes.LOGIN_SUCCESS + "," + id + "," + name);
			}
			else {
				writer.print(ReturnCodes.LOGIN_INCORRECT_PASSWORD);
			}
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
       
	}

}
