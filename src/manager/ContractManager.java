
package manager;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.Customer;

/**
 * @author Mahshid Farrahinia
 * This manager class is responsible for jpql query on contract entity
 * It contain four methods one for create entity manager factory and manager and for close them
 * The others method is responsible for query the contract table based on question one is named query 
 * the other one is dynamic query which employs inner join between 3 tables
 *
 */
public class ContractManager {
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	
	
	 // Lists all customer names and their email addresses in the system using a named query
	public List<Customer> queryAllCustomer_UsingNamedQuery() {
		getEntityManager();
		List<Customer> customers = null;

		try {
			// Set the named query
			TypedQuery<Customer> query = entityManager.createNamedQuery("Customer.listAll", Customer.class);

			// Get result of named query
			customers = query.getResultList();
		} catch (Exception ex) {
		} finally {
			closeEntityManager();
		}
		return customers;
	}
	
	
	/**
	 * List the customer name, sales representative name,
	 * contract description and contract value for each
     * contract that a given sales representative secures
	 */
	
	//If the above code is compiled without @SuppressWarnings("unchecked") annotation, 
    //the compiler will complain like this: XYZ.java uses unchecked or unsafe operations. 
    //Without the @SuppressWarnings("deprecation") annotation, the compiler will issue this warning: XYZ.java uses or overrides a deprecated API.
	@SuppressWarnings("unchecked") 
	public List<Object[]> queryCotract_Customer_SalesRepresentative_UsingInnerJoin(int id) {
		getEntityManager();
		List<Object[]> results = null;

		try {
			
			// Define query String
			final String sql = "SELECT c.name, s.name, co.description, co.value FROM Customer c "
					           + " JOIN c.SalesRepresentative s "
					           + " JOIN c.Contract co "
					           + " WHERE s.id = ?";
			// Set the query
			Query query = entityManager.createQuery(sql);
			
			// set parameter
			query.setParameter(1, id);

			//Get the result of query
			results = query.getResultList();
			
		} catch (Exception ex) {
		} finally {
			closeEntityManager();
		}
		return results;
	}
	
	public void getEntityManager() {
		// Create the EntityManager
		entityManagerFactory = Persistence.createEntityManagerFactory("CJV805-Lab4");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public void closeEntityManager() {
		// Close the EntityManager
		entityManager.close();
		entityManagerFactory.close();
	}

}
