package servlet.helpers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.helpers.event.GetEventInfoRequestHandler;
import servlet.helpers.event.GetMostRecentEventsRequestHandler;
import servlet.helpers.event.NewEventRequestHandler;
import servlet.helpers.user.NewUserRequestHandler;
import servlet.helpers.user.UpdatePasswordRequestHandler;
import servlet.helpers.user.UserLoginRequestHandler;
import utility.ActionCodes;

public class RequestPipeline {

	public void pipeRequest(int action, HttpServletRequest request, HttpServletResponse response) {
		ServletRequestHandler handler = null;
		switch (action) {
		case ActionCodes.NEW_USER_ACTION:
			handler = new NewUserRequestHandler();
			break;
		case ActionCodes.USER_LOGIN_ACTION:
			handler = new UserLoginRequestHandler();
			break;
		case ActionCodes.UPDATE_USER_PASSWORD_ACTION:
			handler = new UpdatePasswordRequestHandler();
			break;
		case ActionCodes.NEW_EVENT_ACTION:
			handler = new NewEventRequestHandler();
			break;
		case ActionCodes.GET_EVENT_INFO_ACTION:
			handler = new GetEventInfoRequestHandler();
			break;
		case ActionCodes.GET_MOST_RECENT_EVENTS_ACTION:
			handler = new GetMostRecentEventsRequestHandler();
			break;
		default:
			// error!
			break;
		}
		
		switch (request.getMethod()) {
		case "GET":
			handler.handleGetRequest(request, response);
			break;
		case "POST":
			handler.handlePostRequest(request, response);
			break;
		default:
			
			break;
		}
	}
}
