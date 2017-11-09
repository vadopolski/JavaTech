import com.AbcConfig;
import com.yyy.A;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AbcTest {

    @Test
    public void loadBean_BeanNotNull() {
        //ApplicationContext context1 = new ClassPathXmlApplicationContext("AbcConfig.xml");
        ApplicationContext context2 = new AnnotationConfigApplicationContext(AbcConfig.class);

        A a = context2.getBean(A.class);
    }
}
