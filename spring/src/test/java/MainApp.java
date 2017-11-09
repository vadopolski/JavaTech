import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("D:\\Projects\\JavaTech\\spring\\src\\main\\resources\\Beans.xml");
//        test.HelloWorld obj = (test.HelloWorld)context.getBean("helloWorld");
//        obj.getMessage();
    }
}
