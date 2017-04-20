import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Created by sbt-opolskiy-va on 20.04.2017.
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(Static.class)
public class MainClass {

    @Test
    public void testMethodThatCallStaticMethod(){
        PowerMockito.mockStatic(Static.class);

        Mockito.when(Static.firstStaticMethod()).thenReturn(123);

        classCallStaticMethodObj.execute();


        // https://github.com/powermock/powermock/wiki/mockitousage

    }


}
