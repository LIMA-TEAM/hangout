package servlet.helpers.user;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;
import servlet.helpers.ServletRequestHandler;
import utility.ActionCodes;
import utility.ReturnCodes;

public class SearchUserNameRequestHandler implements ServletRequestHandler {

	private final int code = ActionCodes.SEARCH_BY_USERNAME;
	
	@Override
	public int getRequestActionCode() {
		return code;
	}

	@Override
	public void handleGetRequest(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String resp = Database.createInstance(null, null).getUserInfoByUsernameJson(request.getParameter("username"));
			if (resp == null) {
				response.getWriter().print(ReturnCodes.SEARCH_BY_USERNAME_FAILURE);
			}
			else {
				response.getWriter().print(Database.createInstance(null, null).getUserInfoByUsernameJson(request.getParameter("username")));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void handlePostRequest(HttpServletRequest request,
			HttpServletResponse response) {
		
	}

}
