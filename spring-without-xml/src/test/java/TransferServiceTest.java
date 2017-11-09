import com.yyy.A;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class TransferServiceTest {

    @Test
    public void transfer() throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SystemTestConfig.class);
        TransferService transferService = ctx.getBean(TransferService.class);
        A a = ctx.getBean(A.class);

        String result = transferService.transfer(10D, "", "");

        assertNotNull(a);
        assertNotNull(transferService);
        assertEquals("AuditTestModule", result);
    }
}