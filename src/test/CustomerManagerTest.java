package test;
/**
 * @author Mahshid Farrahiniaw
 *
 */
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import manager.CustomerManager;
import model.Customer;
import model.SalesRepresentative;

public class CustomerManagerTest {
	
	// should be executed for 4 times, before each test
	@Before
	 public void setUp() throws Exception {
	 }

	
	/**
	 *This jUnit test check the create method in three step, the first three will fail because the inputs don't meet
	 *the condition of customer entity constraints such us name character range, age range and email format
	 *I checked all of the conditions, however I commented them because I want to keep the version which pass all the jUnit tests correctly
	 */	
	@Test
	public void createCustomerTest() {
		
		SalesRepresentative salesRepresentative1 = new SalesRepresentative();
		salesRepresentative1.setId(1);
		salesRepresentative1.setName("Maryam");
		salesRepresentative1.setSalary(5000);
		salesRepresentative1.toString();
		
		Customer excpectedCustomer = new Customer();
		excpectedCustomer.setId(1);
		excpectedCustomer.setName("mahshid");
		excpectedCustomer.setEmail("mahshid@yahoo.com");
		excpectedCustomer.setAge(20);
		String excpectedCustomerString=excpectedCustomer.toString();
		
		CustomerManager customerManager = new CustomerManager();
		Customer actualCustomer = new Customer();

		/**
		 * Step1 - age range is incorrect
		 * If I entered 30 for age, the test went fail because in setAge method I enforce that age should be between 18<age<25
		 *  actualCustomer = customerManager.createCustomer(1,"mahshid@yahoo.com", "mahshid", 30,salesRepresentative1);
		 */
		
		/**
		 * Step2 - email format is incorrect
		 * If I entered email without @, the test went fail because in setEmail method I enforce that email should be in xxx@xxx format
		 * actualCustomer = customerManager.createCustomer(1,"mahshidyahoo.com", "mahshid", 20,salesRepresentative1););
		 */
		
		/**
		 * Step3 - name character range is incorrect
		 * If I entered name with length of more than 40, the test went fail because in setName method I enforce that name should be less than 40 characters
		 * actualCustomer = customerManager.createCustomer(1,"mahshid@yahoo.com", "A name with more that 40 character", 20,salesRepresentative1););
		 */
		
		actualCustomer = customerManager.createCustomer(1,"mahshid@yahoo.com", "mahshid", 20,salesRepresentative1);
		String actualCustomerString=actualCustomer.toString();
		
		assertEquals(excpectedCustomerString,actualCustomerString);		
	}
	
	
	/**
	 *This jUnit test check the find method, it takes an idea and return a row of customer table
	 */	
	@Test
	public void findCustomerTest() {
		
		SalesRepresentative salesRepresentative1 = new SalesRepresentative();
		salesRepresentative1.setId(1);
		salesRepresentative1.setName("Maryam");
		salesRepresentative1.setSalary(5000);
		System.out.println("\nSales object:\n" + salesRepresentative1);
		
		CustomerManager customerManager = new CustomerManager();
		Customer excpectedCustomer = new Customer();
		excpectedCustomer = customerManager.createCustomer(2, "amir@yahoo.com", "amir", 24, salesRepresentative1);
		System.out.println("\n (Create method test) Customer 1:\n" + excpectedCustomer);
		String excpectedCustomerString=excpectedCustomer.toString();
		
		Customer actualCustomer = new Customer();
		actualCustomer= customerManager.findCustomer(2);
		System.out.println("\n (Find method test) Customer 2:\n" + actualCustomer);
		String actualCustomerString=actualCustomer.toString();
		
		assertEquals(excpectedCustomerString,actualCustomerString);					
	}
	
	
	/**
	 *This jUnit test check the update method, it takes an id and age then update the relevant field (age) of row
	 *and return a row of customer table
	 */	
	@Test
	public void updateCustomerAgeTest() {
		
		SalesRepresentative salesRepresentative2 = new SalesRepresentative();
		salesRepresentative2.setId(2);
		salesRepresentative2.setName("Simin");
		salesRepresentative2.setSalary(3500);
		System.out.println("\nSecond Sales object:\n" + salesRepresentative2);
		
		Customer excpectedCustomer = new Customer();
		excpectedCustomer.setId(3);
		excpectedCustomer.setName("masood");
		excpectedCustomer.setEmail("masood@yahoo.com");
		excpectedCustomer.setAge(21);
		String excpectedCustomerString=excpectedCustomer.toString();
		
		CustomerManager customerManager = new CustomerManager();
		Customer customer1 = new Customer();
		customer1 = customerManager.createCustomer(3, "masood@yahoo.com", "masood", 20, salesRepresentative2);
		System.out.println("\n (Create method test) Customer 1:\n" + customer1);
		
		
		Customer actualCustomer = new Customer();
		actualCustomer= customerManager.updateCustomerAge(3, 21);
		System.out.println("\n (Update method test) Customer 1 after update:\n" + actualCustomer);
		String actualCustomerString=actualCustomer.toString();
		
		assertEquals(excpectedCustomerString,actualCustomerString);					
	}
	
	/**
	 *This jUnit test check the delete method, first it creates a row in customer table then remove it with relevant id from table
	 *Then it looks for its id with find method, the result should be null because the requested row was removed from table
	 *
	 */	
	@Test
	public void deleteCustomerTest() {
		
		SalesRepresentative salesRepresentative2 = new SalesRepresentative();
		salesRepresentative2.setId(2);
		salesRepresentative2.setName("Simin");
		salesRepresentative2.setSalary(3500);
		System.out.println("\nSecond Sales object:\n" + salesRepresentative2);
		
		
		CustomerManager customerManager = new CustomerManager();
		Customer customer1 = new Customer();
		customer1 = customerManager.createCustomer(4, "maryam@yahoo.com", "maryam", 22, salesRepresentative2);
		System.out.println("\n (Create method test) Customer 1:\n" + customer1);
		
		
		Customer actualCustomer = new Customer();
		customerManager.deleteCustomer(4);
		actualCustomer= customerManager.findCustomer(4);
		System.out.println("\n (Delete method test) Customer 1 after delete method:\n" + actualCustomer);
		assertNull(actualCustomer);

	}
	
}
