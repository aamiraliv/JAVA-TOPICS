import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Employee{
    String name;
    int id;
    double salary;

    public Employee(int id,String name,double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return (id + "-" + name + "-" + salary);
    }
}

public class EmployeManagment {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(100,"amir",50000));
        employees.add(new Employee(101,"adhil",30000));
        employees.add(new Employee(102,"gani",80000));

        employees.sort(Comparator.comparingDouble(emp-> emp.salary));

        for(Employee n : employees){
            System.out.println(n);
        }
    }
}
