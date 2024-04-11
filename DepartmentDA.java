import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class DepartmentDA {
  private HashMap<String, Employee> employeeMap;
  public DepartmentDA(){
    try{
      Scanner studentFile = new Scanner(new FileReader("dep.csv"));
      employeeMap = new  HashMap<>();

    }
    catch(FileNotFoundException e){
      throw new RuntimeException(e);
    }
  }
}
