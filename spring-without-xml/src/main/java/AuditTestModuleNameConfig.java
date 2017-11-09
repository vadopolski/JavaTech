import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuditTestModuleNameConfig {

    @Bean (name = "string")
    public String string(){
        String string = new String("AuditTestModule");
        return string;
    }
}
