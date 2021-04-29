
package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author Mahshid Farrahinia
 * This class which contains the following variables. Form a SalesRepresentative entity
 * Annotate the POJO classes with Java annotations so that they are mapped to database tables
 * JavaBeans conventions are followed  
 * id (must be unique)
 * name
 * salary
 * related customers
 * Also following conditions should be enforced
 * SalesRepresentative.name (must be between 1-40 characters long)
 * SalesRepresentative.salary (must be a positive amount)
 *
 */
@Entity
public class SalesRepresentative implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "SalesRepresentative_ID", unique = true, nullable = false, updatable = false) 
	private int id;
	@Column(name="SalesRepresentative_Name")
	private String name;
	@Column(name="SalesRepresentative_Salary")
	private double salary;
	//(mappedBy="salesRepresentative", cascade=CascadeType.PERSIST)
	@OneToMany
	@JoinColumn(name="Customer_ID")
    private Set<Customer> customeSet = new HashSet<>();
	
	/*@OneToOne(mappedBy="salesRepresentative")
	@JoinColumn(name="Contract_ID")
	private Contract contract;*/
	
	
	public SalesRepresentative() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		if (salary <= 0){
			throw new IllegalArgumentException("Salary must be a positive amount");
		}
		this.salary = salary;
	}
	//(mappedBy="salesRepresentative")
	@OneToMany
	public Set<Customer> getCustomeSet() {
		return customeSet;
	}

	public void setCustomeSet(Set<Customer> customeSet) {
		this.customeSet = customeSet;
	}
	
	/*@OneToOne
	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}
	*/
	//Print SalesRepresentative's Information 
    @Override
    public String toString() {
        return "SalesRepresentative_ID:"       + id +
               "|SalesRepresentative_Name:"   + name + 
               "|SalesRepresentative_Salary:"    + salary ;
    }




}
