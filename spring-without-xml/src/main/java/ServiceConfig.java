import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Autowired
    public AccountRepository accountRepository;

    @Autowired
    public String string;

    @Bean(name = "transferService")
    public TransferService transferService() {
//        TransferService transferService = new TransferService(accountRepository);
        TransferService transferService = new TransferService(string);
//        TransferService transferService = new TransferService();
        return transferService;
    }
}
