import java.util.HashMap;

public class Department {
    private String depCode;
    private String  depName;
    private Double depTotalSalary;

    private HashMap<String, Employee> empMap;

    public String getDepCode() {
        return depCode;
    }
    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }
    public String getDepName() {
        return depName;
    }
    public void setDepName(String depName) {
        this.depName = depName;
    }
    public Double getDepTotalSalary() {
        return depTotalSalary;
    }
    public void setDepTotalSalary(Double depTotalSalary) {
        this.depTotalSalary = depTotalSalary;
    }
    public HashMap<String, Employee> getEmpMap() {
        return empMap;
    }

    public void setEmpMap(HashMap<String, Employee> empMap) {
        this.empMap = empMap;
    }

}
