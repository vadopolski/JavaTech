import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



import static org.assertj.core.api.Assertions.assertThat;

public class ThrowerTest {
    private final Thrower thrower = new Thrower();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void throwsRuntime_runtimeException() throws Exception {
            try {
                thrower.throwsRuntime();

                Assert.fail("Expected exception to be thrown.");
            } catch (RuntimeException ignored) {
                assertThat(ignored)
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage("My custom runtime exception");

            }

    }

}