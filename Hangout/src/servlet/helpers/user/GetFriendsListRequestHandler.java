package servlet.helpers.user;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;
import servlet.helpers.ServletRequestHandler;
import utility.ActionCodes;

public class GetFriendsListRequestHandler implements ServletRequestHandler {

	private final int code = ActionCodes.GET_USER_FRIEND_LIST;
	@Override
	public int getRequestActionCode() {
		return code;
	}

	@Override
	public void handleGetRequest(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			response.getWriter().print(Database.createInstance(null, null).getUserFriendListById(request.getParameter("userId")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void handlePostRequest(HttpServletRequest request,
			HttpServletResponse response) {

	}

}
