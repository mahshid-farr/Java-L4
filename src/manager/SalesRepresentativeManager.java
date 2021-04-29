package manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.SalesRepresentative;

/**
 * @author Mahshid Farrahinia
 * This manager class provides CRUD (create, read, update, delete) methods for SalesRepresentative entity
 * It contain four methods one for create rows or object in related table
 * The other one is for find a row, also it has two method for update and delete a row
 *
 */
public class SalesRepresentativeManager {
	
	/**
	 * Create method create a row in table
	 * @param id, sales representative name and salary
	 */	  
    public  SalesRepresentative createSalesRepresentative (int id, String name, double salary){
    	
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CJV805-Lab4");
        EntityManager entityManager = entityManagerFactory.createEntityManager( );
        entityManager.getTransaction( ).begin( );
    
        SalesRepresentative salesRepresentative = new SalesRepresentative();
        salesRepresentative.setId(id);
        salesRepresentative.setName(name);
        salesRepresentative.setSalary(salary);
    
        entityManager.persist(salesRepresentative);
    
        entityManager.getTransaction( ).commit( );
    
        entityManager.close( );
        entityManagerFactory.close( );
      
        return salesRepresentative;
    }
    
	/**
	 * Find method which query a table based on requested id
	 * @param id
	 */	
    public SalesRepresentative findSalesRepresentative (int id){
      	 EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "CJV805-Lab4" );
   	     EntityManager entityManager = entityManagerFactory.createEntityManager( );
   	     SalesRepresentative salesRepresentative = entityManager.find(SalesRepresentative.class, id);
   	 
   	     entityManager.close( );
   	     entityManagerFactory.close( );
   	      
   	     return salesRepresentative;   	
   }
    
	/**
	 * Update method which update a filed based on requested id
	 * @param id, new salary amount
	 */	
    public SalesRepresentative updateSalesRepresentativeSalary(int id, double salary){
   	     EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "CJV805-Lab4" );
   	     EntityManager entityManager = entityManagerFactory.createEntityManager( );
   	     entityManager.getTransaction( ).begin( );
   	     SalesRepresentative salesRepresentative = entityManager.find(SalesRepresentative.class, id);
   	 
   	    //before update
        System.out.println( salesRepresentative );
        salesRepresentative.setSalary(salary);
   	 
        entityManager.getTransaction( ).commit( );
        
        entityManager.close( );
        entityManagerFactory.close( );
   	 
   	    return salesRepresentative;
   }
    
    
	/**
	 * Update method which delete a row based on requested id
	 * @param id
	 */
    public SalesRepresentative deleteSalesRepresentative(int id){
   	    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "CJV805-Lab4" );
   	    EntityManager entityManager = entityManagerFactory.createEntityManager( );
   	    entityManager.getTransaction( ).begin( );
   	    SalesRepresentative salesRepresentative = entityManager.find(SalesRepresentative.class, id);
   	 
   	    //before delete
        System.out.println( salesRepresentative );
        
        entityManager.remove( salesRepresentative );
        entityManager.getTransaction( ).commit( );
        
        entityManager.close( );
   	    entityManagerFactory.close( );
   	 
   	    return salesRepresentative;  	
    }
}
