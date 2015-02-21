package servlet.helpers.user;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Database;
import servlet.helpers.ServletRequestHandler;
import utility.ActionCodes;
import utility.ReturnCodes;

public class GetUserInfoRequestHandler implements ServletRequestHandler {

	private final int code = ActionCodes.GET_USER_INFO_ACTION;
	
	@Override
	public int getRequestActionCode() {
		return code;
	}

	@Override
	public void handleGetRequest(HttpServletRequest request,
			HttpServletResponse response) {

		Database db = Database.createInstance(null, null);
		String userId = request.getParameter("userId");
		try {
			String resp = db.getUserInfoJson(userId);
			if (resp == null) {
				response.getWriter().print(ReturnCodes.GET_USER_DOES_NOT_EXIST);
			}
			else {
				response.getWriter().print(resp);
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
