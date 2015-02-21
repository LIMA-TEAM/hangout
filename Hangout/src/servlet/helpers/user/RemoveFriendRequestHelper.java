package servlet.helpers.user;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;
import servlet.helpers.ServletRequestHandler;
import utility.ActionCodes;

public class RemoveFriendRequestHelper implements ServletRequestHandler {

	private final int code = ActionCodes.REMOVE_FRIEND_ACTION;
	
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
		try {
			response.getWriter().print(Database.createInstance(null, null).removeFriend(request.getParameter("userId"), request.getParameter("friendId")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
