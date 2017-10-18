import javax.ejb.Stateless;
import org.springframework.stereotype.Component;

@Stateless
public class ArbitraryDependency {

    private final String label = "Arbitrary Dependency";

    public String toString(){
        return label;
    }
}
