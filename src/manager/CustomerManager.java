
package manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Customer;
import model.SalesRepresentative;

/**
 * @author Mahshid Farrahinia
 * This manager class provides CRUD (create, read, update, delete) methods for Customer entity
 * It contain four methods one for create rows or object in related table
 * The other one is for find a row, also it has two method for update and delete a row
 *
 */
public class CustomerManager {

	/**
	 * Create method create a row in table
	 * @param id, customer name and email, age and relevant salesRepresentative
	 */	        
    public  Customer createCustomer (int id, String email, String name, int age, SalesRepresentative salesRepresentative){
    //
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "CJV805-Lab4" );
    EntityManager entityManager = entityManagerFactory.createEntityManager( );
    entityManager.getTransaction( ).begin( );
    
    Customer customer = new Customer();
    customer.setId(id);
    customer.setEmail(email);
    customer.setName(name);
    customer.setAge(age);
    //customer.setSalesRepresentative(salesRepresentative);
    entityManager.persist(customer);
    salesRepresentative.getCustomeSet().add(customer);
   // entityManager.persist(salesRepresentative);

    
    entityManager.getTransaction( ).commit( );
    
    entityManager.close( );
    entityManagerFactory.close( );
    
    return customer;
    }
    
    
	/**
	 * Find method which query a table based on requested id
	 * @param id
	 */	
    public Customer findCustomer (int id){
    	 EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "CJV805-Lab4" );
    	 EntityManager entityManager = entityManagerFactory.createEntityManager( );
    	 Customer customer = entityManager.find(Customer.class, id);
    	 
    	 entityManager.close( );
    	 entityManagerFactory.close( );
    	    
    	 return customer;   	
    }
    
    
	/**
	 * Update method which update a filed based on requested id
	 * @param id, new age 
	 */	
    public Customer updateCustomerAge(int id, int age){
    	 EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "CJV805-Lab4" );
    	 EntityManager entityManager = entityManagerFactory.createEntityManager( );
    	 entityManager.getTransaction( ).begin( );
    	 Customer customer = entityManager.find(Customer.class, id);
    	 
    	//before update
         System.out.println( customer );
    	 customer.setAge(age);
    	 
         entityManager.getTransaction( ).commit( );
         
         entityManager.close( );
    	 entityManagerFactory.close( );
    	 
    	 return customer;
    }
    
    
	/**
	 * Update method which delete a row based on requested id
	 * @param id
	 */
    public Customer deleteCustomer(int id){
   	    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "CJV805-Lab4" );
   	    EntityManager entityManager = entityManagerFactory.createEntityManager( );
   	    entityManager.getTransaction( ).begin( );
   	    Customer customer = entityManager.find(Customer.class, id);
   	 
   	    //before delete
        System.out.println( customer );
        
        entityManager.remove( customer );
        entityManager.getTransaction( ).commit( );
        
        entityManager.close( );
   	    entityManagerFactory.close( );
   	 
   	    return customer;  	
    }
	
}
