import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DepartmentDA {
    private HashMap<String, Employee> employeeMap;

    public DepartmentDA() {
        this.employeeMap = new HashMap<>();
        double totalSalary = 0.0;
        try (Scanner departmentFile = new Scanner(new FileReader("C:\\Users\\Admin\\SnapSack\\OOP_LAB-ASS-5_HashMapExercise\\dep.csv"))) {
            while (departmentFile.hasNext()) {
                String departmentLine = departmentFile.nextLine();
                String[] departmentData = departmentLine.split(",");

                String deptCode = departmentData[0].trim();
                String deptName = departmentData[1].trim();

                Department department = new Department();
                department.setDepCode(deptCode);
                department.setDepName(deptName);

                Scanner deptEmpFile = new Scanner(new FileReader("C:\\Users\\Admin\\SnapSack\\OOP_LAB-ASS-5_HashMapExercise\\deptemp.csv"));

                while (deptEmpFile.hasNext()) {
                    String deptEmpFileLine = deptEmpFile.nextLine();
                    String[] deptEmpFileData = deptEmpFileLine.split(",");

                    if (deptEmpFileData[0].trim().equals(department.getDepCode())) {
                        String empNo = deptEmpFileData[1].trim();

                        EmployeeDA employeeDA = new EmployeeDA(empNo);
                        Employee employee = employeeDA.getEmployee();
                        employee.setSalary(Double.parseDouble(deptEmpFileData[2].trim()));

                        employeeMap.put(empNo, employee);
                        totalSalary += employee.getSalary();
                    }
                }
                department.setEmpMap(employeeMap);
                department.setDepTotalSalary(totalSalary);
                printDepartment(department);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void printDepartment(Department department) {
      DecimalFormat df = new DecimalFormat("#,###.00");
      System.out.println("Department Code: " + department.getDepCode());
      System.out.println("Department Name: " + department.getDepName());
      System.out.println("Department Total Salary: " + df.format(department.getDepTotalSalary()));
      System.out.println("------------Details----------------");
      System.out.printf("%-8s %-25s %10s\n", "EmpNo", "Employee Name", "Salary");
      for (Map.Entry<String, Employee> entryMap : department.getEmpMap().entrySet()) {
          Employee employee = entryMap.getValue();
          if (employee.getSalary() == null) continue;
          System.out.printf("%-8s %-25s %10s\n", entryMap.getKey(),
                  employee.getLastName() + ", " + employee.getFirstName(), df.format(employee.getSalary()));
      }
      System.out.println();
      System.out.println();
  }  
}