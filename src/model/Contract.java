package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import model.SalesRepresentative;

/**
 * @author Mahshid Farrahinia
 * This class which contains the following variables. Form a contract entity
 * Annotate the POJO classes with Java annotations so that they are mapped to database tables
 * JavaBeans conventions are followed  
 * id (must be unique)
 * description
 * value
 * related customer and Sales Representative

 *
 */
@Entity
public class Contract implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "Contract_ID", unique = true, nullable = false, updatable = false) 
	private int id;
	@Column(name="Description")
	private String description;
	@Column(name="Value")
	private double value;
	
	@OneToOne 
	@JoinColumn(name = "SalesRepresentative_ID")
	private SalesRepresentative salesRepresentative;
	@OneToOne 
	@JoinColumn(name = "Customer_ID")
	private Customer customer;
	
	public Contract() {
		super();
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	
	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}

	@OneToOne
	public SalesRepresentative getSalesRepresentative() {
		return salesRepresentative;
	}

	public void setSalesRepresentative(SalesRepresentative salesRepresentative) {
		this.salesRepresentative = salesRepresentative;
	}

	@OneToOne
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	//Print Contract's Information 
    @Override
    public String toString() {
        return "Contract_ID:"  + id +
               "|Description:" + description + 
               "|Value:"       + value ;
    }
	

}
