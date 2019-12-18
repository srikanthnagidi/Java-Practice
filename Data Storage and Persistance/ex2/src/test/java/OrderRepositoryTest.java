import com.example.entity.Order;
import com.example.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderRepositoryTest {
    //@Autowired private DataSource dataSource;
    @Autowired private JdbcTemplate jdbcTemplate;
    @Autowired private EntityManager entityManager;
    @Autowired private TestEntityManager testEntityManager;
    @Autowired private OrderRepository orderRepository;

    @Test
    public void injectedComponentsAreNotNull(){

        assertThat(jdbcTemplate, is(notNullValue()));
        //assertThat(entityManager).isNotNull();
        assertThat(entityManager, is(notNullValue()));
        //assertThat(testEntityManager).isNotNull();
        assertThat(testEntityManager, is(notNullValue()));
        //assertThat(orderRepository).isNotNull();
        assertThat(orderRepository, is(notNullValue()));
    }

    @Test
    public void testFindByCustomerName(){
        // create Order
        Order order = new Order();
        // set fields
        order.setCustomerName("John Doe");

        entityManager.persist(order);

        Optional<Order> actual = orderRepository.findByCustomerName("John Doe");
        assertThat(actual, is(notNullValue()));
        //assertEquals(order.getId(), actual.getId());
    }
}
