import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.testng.annotations.BeforeMethod;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.spy;

/**
 * Created by sbt-opolskiy-va on 23.04.2017.
 */
public class MockitoSpyExmpl {

    private static Employee employee;
    private static Employee spyEmployee;

    @BeforeMethod
    public void buildSpy(){
        employee = new Employee("Anton", "Antonov", 33);
        spyEmployee = spy(employee);

    }

    @Test
    public void testSpyEffect(){
        spyEmployee.setAge(20);
        assertFalse(employee.getAge() == spyEmployee.getAge());
    }

//    public static void main(String[] args) {
//        System.out.println("Test" + "Test");
//
//        Employee emp = new Employee("Vadim", "Vadimov", 32);
//
//        System.out.println(emp.getAge());
//
//        Employee spyEmp = spy(emp);
//
//        System.out.println(spyEmp.getAge());
//
//        spyEmp.setAge(55);
//
//        System.out.println(spyEmp.getAge());
//    }
}
