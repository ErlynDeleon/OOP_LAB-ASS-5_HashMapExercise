import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class EmployeeDA {
    private Employee employee;

    public EmployeeDA(String empNo) {
        this.employee = readEmployeeFile(empNo);
    }

    public Employee getEmployee() {
        return employee;
    }

    private Employee readEmployeeFile(String empNo) {
        Employee emp = new Employee();
        try {
            Scanner employeeFile = new Scanner(new FileReader("C:\\Users\\Admin\\SnapSack\\OOP_LAB-ASS-5_HashMapExercise\\emp.csv"));
            while (employeeFile.hasNext()) {
                String empLine = employeeFile.nextLine();
                String[] empArr = empLine.split(",");
                if (empArr[0].trim().equals(empNo)) {
                    emp.setEmpNo(empArr[0].trim());
                    emp.setLastName(empArr[1].trim());
                    emp.setFirstName(empArr[2].trim());
                    break;
                }
            }
            employeeFile.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return emp;
    }
}
