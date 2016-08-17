package model.source;

import java.io.Serializable;
import java.text.DecimalFormat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown=true)
public class Product implements Serializable {
	
	@XmlAttribute(name="item_name")
	String name;
	
	@XmlAttribute(name="brand_name")
	String brand;
	
	@XmlAttribute(name="nf_calories")
	Double kcal;
	
	@XmlAttribute(name="nf_serving_size_qty")
	Double serving_size_quantity;
	
	@XmlAttribute(name="nf_serving_size_unit")
	String serving_size_unit;
	
	@XmlAttribute(name="nf_serving_weight_grams")
	Integer serving_weight;

	public Product() {}
	
	public String getName() { return name;}
	public String getBrand() { return brand; }
	public Double getKcal() { return kcal; }
	public Double getServing_size_quantity() { return serving_size_quantity; }
	public String getServing_size_unit() { return serving_size_unit; }
	public Integer getServing_weight() { return serving_weight; }
	
	public void setName(String name) { this.name = name; }
	public void setBrand(String brand) { this.brand = brand; }
	public void setKcal(Double kcal) { this.kcal = kcal; }
	public void setServing_size_quantity(Double serving_size_quantity) { this.serving_size_quantity = serving_size_quantity; }
	public void setServing_size_unit(String serving_size_unit) {  this.serving_size_unit = serving_size_unit; }
	public void setServing_weight(Integer serving_weight) { this.serving_weight = serving_weight; }
	
	 @Override
	public String toString() {
		 StringBuilder ret = new StringBuilder();
		 DecimalFormat df = new DecimalFormat("0.###");
		 
		 ret.append(String.format("%s (%s)\n", name, brand));
		 
		 if (serving_weight != null)
			 ret.append(String.format("%s %s (%dg) = %.2f kcal\n", df.format(serving_size_quantity), serving_size_unit,serving_weight ,kcal));
		 else
			 ret.append(String.format("%s %s = %.2f kcal\n", df.format(serving_size_quantity), serving_size_unit,kcal));
		 return ret.toString();
	}
}
