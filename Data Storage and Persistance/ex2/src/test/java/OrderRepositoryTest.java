import com.example.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertThat;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

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
       // assertThat(dataSource).isNotNull();
        assertThat(jdbcTemplate).isNotNull;

    }
}
