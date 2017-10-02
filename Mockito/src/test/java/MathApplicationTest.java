import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTest {

    @InjectMocks
    private MathApplication mathApplication = new MathApplication();

    @Mock
    private CalculatorService service;

    @Test
    public void testAddFunctionality_twoNumbers() throws Exception {
        when(service.add(10.00, 20.00)).thenReturn(30.00);

        Assert.assertThat(mathApplication.add(10.00, 20.00), Is.is(30.00));
    }
}