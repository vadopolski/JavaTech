public class SysEnv {

    private String mesosName;
    private String mesosRole;
    private SysEnvService sysEnvService;

    public SysEnvService getSysEnvService() {
        return sysEnvService;
    }

    public void setSysEnvService(SysEnvService sysEnvService) {
        this.sysEnvService = sysEnvService;
    }

    public String getMesosName() {
        return sysEnvService.getName();
    }

    public String getMesosRole() {
        return sysEnvService.getRole();
    }
}