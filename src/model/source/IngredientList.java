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
public class IngredientList implements Serializable {

	@XmlElement
	Hit [] hits;

	public IngredientList() {}
	
	public Hit[] getHits() {
		return hits;
	}

	public void setHits(Hit[] hits) {
		this.hits = hits;
	}
	
	
}
