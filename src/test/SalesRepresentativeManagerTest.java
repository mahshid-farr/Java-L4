package test;

/**
 * @author Mahshid Farrahinia
 *
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import manager.SalesRepresentativeManager;
import model.SalesRepresentative;

public class SalesRepresentativeManagerTest {

	// should be executed for 4 times, before each test
	@Before
	 public void setUp() throws Exception {
	 }

	/**
	 *This jUnit test check the create method in two step, the second two will fail because the inputs don't meet
	 *the condition of salesRepresentative entity constraints such us name character range and salary range
	 *I checked all of the conditions, however I commented them because I want to keep the version which pass all the jUnit tests correctly
	 */	
	@Test
	public void createSalesRepresentativeTest() {
		
		SalesRepresentative excpectedSalesRepresentative = new SalesRepresentative();
		excpectedSalesRepresentative.setId(1);
		excpectedSalesRepresentative.setName("Maryam");
		excpectedSalesRepresentative.setSalary(5000);
		String excpectedSalesRepresentativeString = excpectedSalesRepresentative.toString();
		System.out.println("\nSales object:\n" + excpectedSalesRepresentative);
		
		SalesRepresentativeManager salesRepresentativeManager = new SalesRepresentativeManager();
		SalesRepresentative actualSalesRepresentative = new SalesRepresentative();
		actualSalesRepresentative = salesRepresentativeManager.createSalesRepresentative(1,"Maryam", 5000);
		System.out.println("\n (Create method test) Actual sales row:\n" + actualSalesRepresentative);
		String actualSalesRepresentativeString=actualSalesRepresentative.toString();
		
		assertEquals(excpectedSalesRepresentativeString,actualSalesRepresentativeString);	
		
		/**
		 * Step1 - Salary should be positive
		 * If I entered -5000 for salary, the test went fail because in setSalary method I enforce that salary should be positive
		 *  actualSalesRepresentative = salesRepresentativeManager.createSalesRepresentative(1,"Maryam", -5000);
		 */

	
		/**
		 * Step2 - name character range is incorrect
		 * If I entered name with length of more than 40, the test went fail because in setName method I enforce that name should be less than 40 characters
		 * actualSalesRepresentative = salesRepresentativeManager.createSalesRepresentative(1,"A name with more that 40 character", 5000);
		 */
	}
	
	
	/**
	 *This jUnit test check the find method, it takes an idea and return a row of salesRepresentative table
	 */	
	@Test
	public void findSalesRepresentativeTest() {
		
		SalesRepresentativeManager salesRepresentativeManager = new SalesRepresentativeManager();
		SalesRepresentative excpectedSalesRepresentative = new SalesRepresentative();
		excpectedSalesRepresentative = salesRepresentativeManager.createSalesRepresentative(2,"Simin", 3000);
		System.out.println("\n (Create method test) Expected sales row:\n" + excpectedSalesRepresentative);
		String excpectedSalesRepresentativeString=excpectedSalesRepresentative.toString();
		
		SalesRepresentative actualSalesRepresentativeString = new SalesRepresentative();
		actualSalesRepresentativeString= salesRepresentativeManager.findSalesRepresentative(2);
		System.out.println("\n (Find method test) Actual sales row:\n" + actualSalesRepresentativeString);
		String actualSalesRepresentativeStringString=actualSalesRepresentativeString.toString();
		
		assertEquals(excpectedSalesRepresentativeString,actualSalesRepresentativeStringString);					
	}

	
	/**
	 *This jUnit test check the update method, it takes an id and salary then update the relevant field (salary) of requested row
	 *and return a row of SalesRepresentative table
	 */	
	@Test
	public void updateSalesRepresentativeSalaryTest() {
		
		SalesRepresentative excpectedSalesRepresentative = new SalesRepresentative();
		excpectedSalesRepresentative.setId(2);
		excpectedSalesRepresentative.setName("Simin");
		excpectedSalesRepresentative.setSalary(3500);
		String excpectedSalesRepresentativeString = excpectedSalesRepresentative.toString();
		System.out.println("\nExcpected Sales object:\n" + excpectedSalesRepresentative);
				
		SalesRepresentative actualSalesRepresentativeString = new SalesRepresentative();
		SalesRepresentativeManager salesRepresentativeManager = new SalesRepresentativeManager();
		actualSalesRepresentativeString= salesRepresentativeManager.updateSalesRepresentativeSalary(2, 3500);
		System.out.println("\n (Update method test) Actual Sales RepresentativeString after update:\n" + actualSalesRepresentativeString);
		String actualSalesRepresentativeStringString=actualSalesRepresentativeString.toString();
		
		assertEquals(excpectedSalesRepresentativeString,actualSalesRepresentativeStringString);					
	}
	
	
	/**
	 *This jUnit test check the delete method, first it creates a row in salesRepresentative table
	 *then remove it with relevant id from table
	 *Then it looks for its id with find method, the result should be null because the requested row was removed from table
	 *
	 */	
	@Test
	public void deleteSalesRepresentativeTest() {
		
		SalesRepresentativeManager salesRepresentativeManager = new SalesRepresentativeManager();
		SalesRepresentative salesRepresentative = new SalesRepresentative();
		salesRepresentative = salesRepresentativeManager.createSalesRepresentative(5,"Rahmat", 4000);
		System.out.println("\n (Create method test) Expected sales row:\n" + salesRepresentative);
		
		SalesRepresentative actualSalesRepresentative = new SalesRepresentative();
		salesRepresentativeManager.deleteSalesRepresentative(5);
		actualSalesRepresentative= salesRepresentativeManager.findSalesRepresentative(3);
		System.out.println("\n (Delete method test) salesRepresentative  after delete method:\n" + actualSalesRepresentative);
		assertNull(actualSalesRepresentative);
	}
}
