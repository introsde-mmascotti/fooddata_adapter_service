package model.source;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown=true)
public class Hit implements Serializable{
	//some properties to ignore ...
	
	@XmlElement(name="fields")
	Product ingredient;

	public Hit() { }
	
	public Product getIngredient() {
		return ingredient;
	}

	public void setIngredient(Product ingredient) {
		this.ingredient = ingredient;
	}
	
	@Override
	public String toString() {
		return ingredient.toString();
	}
	
	
}
