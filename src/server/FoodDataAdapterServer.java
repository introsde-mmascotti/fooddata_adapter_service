package server;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.xml.ws.Endpoint;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fooddata.adapter.service.Retrieve;

public class FoodDataAdapterServer {
	private static final String MASHUP_KEY_VARIABLE_NAME = "mashape_key";	
	private static final Logger logger = LogManager.getFormatterLogger("FoodDataAdapterService");
	private static int port = 6100;

	public static void main(String[] args) throws UnknownHostException {
		checkSystemEnvironment();
		
		String hostname = InetAddress.getLocalHost().getHostAddress();
		if (hostname.equals("127.0.0.1"))
			hostname = "localhost";
		
		if (args.length >= 1)
			port = Integer.parseInt(args[0]);		
		else
			logger.info("Port not specified in arguments. Using default port: " + port);
		
		String url_str = String.format("http://%s:%d/", hostname, port);
		Endpoint.publish(url_str, new Retrieve());

		logger.info("FoodDataAdapterServer started: " + url_str);
	}
	
	private static void checkSystemEnvironment(){
        if (System.getenv(MASHUP_KEY_VARIABLE_NAME) == null){
        	logger.fatal("No system environment variable named '%s' containing the Mashape key.", MASHUP_KEY_VARIABLE_NAME);
        	logger.fatal("The adapter service is not functional. Exiting.");
        	System.exit(-1);
        }
	}
}
