import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import({ServiceConfig.class, RepositoryConfig.class, AuditTestModuleNameConfig.class})
@ImportResource("AbcConfig.xml")
public class SystemTestConfig {

    @Bean (name = "dataSource")
    public DataSource dataSource() {
        DataSource dataSource = new DataSource();
        return dataSource;
    }
}
