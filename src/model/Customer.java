/**
 * 
 */
package model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.regex.Pattern;


/**
 * @author Mahshid Farrahinia
 * This class which contains the following variables. Form a Customer entity
 * Annotate the POJO classes with Java annotations so that they are mapped to database tables
 * JavaBeans conventions are followed  
 * id (must be unique)
 * e-mail
 * name
 * age
 * Also following conditions should be enforced
 * Customer.email (must be in the form xxx@xxx)
 * Customer.name (must be between 1-40 characters long)
 * Customer.age (must be between 18-25)
 *
 */

@Entity
@Table(name="Customer")
@NamedQuery(name="Customer.listAll", query="SELECT c.name, c.email FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "Customer_ID", unique = true, nullable = false, updatable = false) 
	private int id;
	@Column(name="Customer_Email")
	private String email;
	@Column(name="Customer_Name")
	private String name;
	@Column(name="Customer_Age")
	private int age;
	
	/*@ManyToOne
	@JoinColumn(name="SalesRepresentative_ID")
	private SalesRepresentative salesRepresentative;*/
	
	@OneToOne(mappedBy="customer")
	@JoinColumn(name="Contract_ID")
	private Contract contract;
	
	
	public Customer() {
		super();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		if (pattern.matcher(email).matches()){
			this.email = email;
		} else {
			throw new IllegalArgumentException("Email must be in the form xxx@xxx");
			   }	
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if (1 > name.length() && name.length() > 40){
			throw new IllegalArgumentException("Name must be between 1-40 characters long");
		}
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		if (18 > age && age > 25){
			throw new IllegalArgumentException("Age must be between 18 and 25");
		}
		this.age = age;
	}
	
	/*@ManyToOne
	public SalesRepresentative getSalesRepresentative() {
		return salesRepresentative;
	}

	public void setSalesRepresentative(SalesRepresentative salesRepresentative) {
		this.salesRepresentative = salesRepresentative;
	}*/
	
	@OneToOne
	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}
	
	//Print Customer's Information 
    @Override
    public String toString() {
        return "Customer_ID:"       + id +
        		"|Customer_Name:"    + name +
               "|Customer_Email:"   + email + 
               "|Customer_Age:"     + age;
    }


	
}
