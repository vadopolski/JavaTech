import jdk.internal.dynalink.beans.StaticClass;

/**
 * Created by Home on 20.04.2017.
 */
public class ServiceRegistrator {

    public long registerService() {
        final long id = IdGenerator.generateNewId();
        return id;
    }

    public static String getMesosRole() {
        final String value = "TESTETST";
        return value;
    }

}
