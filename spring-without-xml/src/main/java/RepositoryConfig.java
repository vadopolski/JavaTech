import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Autowired
    public DataSource dataSource;

    @Bean (name = "accountRepository")
    public AccountRepository accountRepository(){
        JdbcAccountRepository repository = new JdbcAccountRepository(dataSource);
        return repository;
    }
}