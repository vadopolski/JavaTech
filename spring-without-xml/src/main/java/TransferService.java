import org.springframework.stereotype.Component;

@Component
public class TransferService {

    private String test;

    public TransferService() {
        test = "Test1";
    }

    public TransferService(AccountRepository accountRepository) {
        test = "Test2";
    }

    public TransferService(String string) {
        test = string;
    }

    public String transfer(Double d, String s1, String s2) {
        return test;
    }
}
