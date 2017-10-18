import com.baeldung.dependency.ApplicationContextTestAutowiredType;
import com.baeldung.dependency.ArbitraryDependency;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
    loader=AnnotationConfigContextLoader.class,
    classes=ApplicationContextTestAutowiredType.class)
public class FieldAutowiredTest {

//    @Autowired
//    @Qualifier("autowiredFieldDependency")
//    private ArbitraryDependency fieldDependency;

//    @Autowired
//    @Qualifier("anotherAutowiredFieldDependency")
//    private ArbitraryDependency anotherFieldDependency;

    @Autowired
    private ArbitraryDependency autowiredFieldDependency;

    @Autowired
    private ArbitraryDependency anotherAutowiredFieldDependency;
//    @Test
//    public void givenAutowired_WhenSetOnField_ThenDependencyResolved() {
//        assertNotNull(fieldDependency);
//    }
//
//    @Test
//    public void givenAutowired_WhenSetOnAnotherField_ThenDependencyResolved() {
//        assertNotNull(anotherFieldDependency);
//    }

    @Test
    public void givenAutowired_WhenSetOnField_ThenDependencyResolved() {
        assertNotNull(autowiredFieldDependency);
    }

    @Test
    public void givenAnotherAutowired_WhenSetOnField_ThenDependencyResolved() {
        assertNotNull(anotherAutowiredFieldDependency);
    }
}