import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.*;
import static org.powermock.api.easymock.PowerMock.*;


/**
 * Created by sbt-opolskiy-va on 21.04.2017.
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(IdGenerator.class)
public class ServiceRegistratorTest {

    @Test
    public void testRegisterService() throws Exception{
        long expectedId = 42;

        // We create a new instance of test class under test as usually.
        ServiceRegistrator tested = new ServiceRegistrator();

        // This is the way to tell PowerMock to mock all static methods of a
        // given class
        mockStatic(IdGenerator.class);

	/*
	 * The static method call to IdGenerator.generateNewId() expectation.
	 * This is why we need PowerMock.
	 */
        expect(IdGenerator.generateNewId()).andReturn(expectedId);

        // Note how we replay the class, not the instance!
        replay(IdGenerator.class);

        long actualId = tested.registerService();

        // Note how we verify the class, not the instance!
        verify(IdGenerator.class);

        // Assert that the ID is correct
        assertEquals(expectedId, actualId);

    }
}