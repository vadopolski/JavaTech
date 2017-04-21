import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Home on 20.04.2017.
 */
public class ServiceRegistrator {

    public long registerService() {
        final long id = IdGenerator.generateNewId();
        return id;
    }

}
