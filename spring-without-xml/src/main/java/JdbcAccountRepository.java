
import org.springframework.stereotype.Component;

@Component
public class JdbcAccountRepository extends AccountRepository {

    public JdbcAccountRepository (DataSource dataSource){}
}
