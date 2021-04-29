import java.util.List;
import manager.ContractManager;
import manager.CustomerManager;
import manager.SalesRepresentativeManager;
import model.Customer;
import model.SalesRepresentative;

/**
 * @author Mahshid Farrahinia
 * This class is just for some manual testing 
 *
 */
public class Lab4App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*SalesRepresentativeManager salesRepresentativeManager = new SalesRepresentativeManager();
		salesRepresentativeManager.createSalesRepresentative(1, "Maryam", 5000);
		/*CustomerManager customerManager = new CustomerManager();
		//customerManager.createCustomer(1, "mahshid_668@yahoo.com", "Mahshid", 34, salesRepresentative);*/
		
		// Query all countries using named query
		    /*    ContractManager contract = new ContractManager();
				List<Customer> cList1 = contract.queryAllCustomer_UsingNamedQuery();
				System.out.println("\nCustomer list (using named query):\n" + cList1);*/
		
		SalesRepresentative salesRepresentative1 = new SalesRepresentative();
		salesRepresentative1.setId(1);
		salesRepresentative1.setName("Maryam");
		salesRepresentative1.setSalary(5000);
		System.out.println("\nSales:\n" + salesRepresentative1);
		
		
		Customer customer1 = new Customer();
		customer1.setId(1);
		customer1.setName("mahshid");
		customer1.setEmail("mahshid@yahoo.com");
		customer1.setAge(20);
		//salesRepresentative1.getCustomeSet().add(customer1);
		//customer1.setSalesRepresentative(salesRepresentative1);
		System.out.println("\n Create object test Customer 1:\n" + customer1);
				



				
				CustomerManager customerManager = new CustomerManager();
				Customer customer2 = new Customer();
				customer2 = customerManager.createCustomer(1, "mahshid@yahoo.com", "mahshid", 20, salesRepresentative1);
				System.out.println("\n (Create method test) Customer 2:\n" + customer2);
				
				/*SalesRepresentativeManager salesRepresentativeManager = new SalesRepresentativeManager();
				salesRepresentativeManager.createSalesRepresentative(1, "Maryam", 5000);*/
		
				Customer customer3 = new Customer();
				customer3= customerManager.findCustomer(1);
				System.out.println("\n (Find method test) Customer 3:\n" + customer3);
				
	}

}
