package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;

import utility.URIFormulator;
import database.DatabaseConnection;
import event.LoginEvent;

@WebServlet("/Login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 7995117782161733798L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json");
		response.setStatus(200);
	      
		
		PrintWriter writer = response.getWriter();
			
		String remoteAddr = request.getRemoteAddr();
       
		DatabaseConnection dbinfo = new DatabaseConnection();
		
		CouchDbProperties properties = new CouchDbProperties()
		  .setDbName(dbinfo.getDbname())
		  .setCreateDbIfNotExist(false)
		  .setProtocol("https")
		  .setHost(dbinfo.getHost())
		  .setPort(443)
		  .setUsername(dbinfo.getUsername())
		  .setPassword(dbinfo.getPassword())
		  .setMaxConnections(100)
		  .setConnectionTimeout(0);
		
		CouchDbClient dbClient = new CouchDbClient(properties);
		
		LoginEvent event = new LoginEvent();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		PrintWriter out = new PrintWriter("out.txt");
		
		out.println(username);
		out.println(password);
		
		out.close();
		/*int code = validateUserInfo(username, password);
		if (code != 0) {
			// successful login
			long timeStamp = System.currentTimeMillis();
			
			event.setTimeStamp(timeStamp);
			event.setUsername(username);
			event.setPassword(password);
			
			System.out.println("Event info " + event.toString());
			
			LoginEventContainer t = new LoginEventContainer();
			t.setEvent(event);
			
			try {
				if (code == 2) {
					dbClient.save(t);
				}
				
				dbClient.shutdown();
				System.out.println("Successful login");
				writer.println(username);
				writer.close();
				return;
				
			} catch (DocumentConflictException e) {
				System.out.println("already registered ERROR");
			}
			catch (Exception e) {
				System.out.println("ERROR : " + e.getMessage());
			}
		}
		
		writer.println("invalid");
		
		writer.close();			*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
						
	}

	public int validateUserInfo(String username, String password) {
		
		String actualPassword = null;
		try {
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet(URIFormulator.formGetCredentialsURI(username));
			HttpResponse response = client.execute(request);
//			response.getParams().getParameter(arg0)
			BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			actualPassword = reader.readLine();
			if (actualPassword == null) {
				return 2;
			}
			else if (actualPassword.equals("")) {
				return 2;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (password.equals(actualPassword)) {
			return 1;
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		Login login = new Login();
		
		login.validateUserInfo("yes", "no");
	}
}