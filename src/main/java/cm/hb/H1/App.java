package cm.hb.H1;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import cm.hb.H1.domain.Category;
import cm.hb.H1.domain.Product;

public class App 
{
    public static void main( String[] args )
    {
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	System.out.println("Opening session");
    	session.beginTransaction();
        
        Category category = new Category("Computer");
         
        Product pc = new Product("DELL PC", "Quad-core PC", 1200, category);
         
        Product laptop = new Product("MacBook", "Apple High-end laptop", 2100, category);
         
        Product phone = new Product("iPhone 5", "Apple Best-selling smartphone", 499, category);
         
        Product tablet = new Product("iPad 3", "Apple Best-selling tablet", 1099, category);
        /*Product pc = new Product("DELL PC", "Quad-core PC", 1200);
        
        Product laptop = new Product("MacBook", "Apple High-end laptop", 2100);
         
        Product phone = new Product("iPhone 5", "Apple Best-selling smartphone", 499);
         
        Product tablet = new Product("iPad 3", "Apple Best-selling tablet", 1099);*/
         
        Set<Product> products = new HashSet<Product>();
        products.add(pc);
        products.add(laptop);
        products.add(phone);
        products.add(tablet);
         
        category.setProducts(products);
         
        session.save(category);
         
        session.getTransaction().commit();
        session.close();  
    }
}
