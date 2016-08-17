package fooddata.adapter.service;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import model.source.Product;

@WebService
@SOAPBinding(style=Style.DOCUMENT)
public interface RetrieveInterface {

	@WebMethod
	public List<Product> getProducts(String search_phrase);

}