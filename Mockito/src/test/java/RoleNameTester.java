import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RoleNameTester {

    SysEnvService sysEnvService;
    SysEnv sysEnv;

    public static void main(String[] args) {
        RoleNameTester roleNameTester = new RoleNameTester();
        roleNameTester.setup();
        System.out.println(roleNameTester.testMesosRole() ? "pass" : "fail");
        System.out.println(roleNameTester.testMesosName() ? "pass" : "fail");
    }

    private boolean testMesosRole() {
        when(sysEnvService.getRole()).thenReturn("test_role");
        return sysEnv.getMesosRole() == "test_role";
    }

    private boolean testMesosName() {
        when(sysEnvService.getName()).thenReturn("test_name");
        return sysEnv.getMesosName() == "test_name";
    }

    private void setup() {
        sysEnv = new SysEnv();
        sysEnvService = mock(SysEnvService.class);
        sysEnv.setSysEnvService(sysEnvService);
    }
}