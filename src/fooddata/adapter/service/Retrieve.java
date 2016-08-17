package fooddata.adapter.service;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;

import model.source.Hit;
import model.source.IngredientList;
import model.source.Product;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

@WebService(endpointInterface="fooddata.adapter.service.RetrieveInterface")
public class Retrieve implements RetrieveInterface {
	
	private static final Logger logger = LogManager.getFormatterLogger("FoodDataAdapterService");
	
	@Override	
	public List<Product> getProducts(String search_phrase){
		ClientConfig clientConfig = new ClientConfig();
		
		Client client = ClientBuilder.newClient(clientConfig).register(JacksonFeature.class);
        WebTarget service = client.target(getUri("https://nutritionix-api.p.mashape.com/v1_1/search/"));
        
        IngredientList result = service
        	.path(search_phrase)
        	.queryParam("fields", "*")
        	.request()
        	.header("X-Mashape-Key", System.getenv("mashape_key"))
        	.get()
        	.readEntity(IngredientList.class);
                
        Hit[] hits = result.getHits();
        List<Product> ret = new ArrayList<Product>(hits.length);
        
        for (int i = 0; i < hits.length; i++)
        	ret.add(hits[i].getIngredient());
        
        logger.info("Found %d products.", ret.size());
        logger.debug(ret);
        return ret;
	}
	
	private URI getUri(String string) {
		URI ret = null;
		ret = UriBuilder.fromUri(string).build();
		return ret;
	}

	public static void main(String[] args) {
		Retrieve r = new Retrieve();
		List<Product> list = r.getProducts("egg");
		
		System.out.print(list.size() + " items");
	}
}
