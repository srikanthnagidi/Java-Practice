import com.example.entity.Order;
import org.hibernate.PersistentObjectException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class OrderTest {

    private static final String PERSISTENCE_UNIT_NAME = "Order";

    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        //create a factory for the persistence unit
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        //create an EntityManager
        EntityManager em = factory.createEntityManager();

        //Start a transaction
        em.getTransaction().begin();

        //Create an order
        Order order =  new Order();
        order.setCustomerName("Vasista");
        order.setCustomerAddress("857 Spiros Ct DeKalb IL 60115");
        order.setCredatedTime(Timestamp.valueOf(LocalDateTime.now()));

        // persist the order entity
        em.persist(order);

        System.err.println("Order ID:" + order.getOrderId());

        em.getTransaction().commit();
        em.close();

        //Example to read an entity
        readOrder(order.getOrderId(), factory);

        factory.close();
    }

    private static void readOrder(Integer orderId, EntityManagerFactory factory) {
        EntityManager entityManager = factory.createEntityManager();

        Order order = entityManager.find(Order.class, orderId);

        System.err.println("Order: " + order);

        entityManager.close();
    }
}
