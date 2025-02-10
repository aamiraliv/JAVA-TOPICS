import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Employee {
    String name;
    int id;
    double salary;

    public Employee(int id, String name, double salary) {
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
        Scanner s = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(100, "amir", 50000));
        employees.add(new Employee(101, "adhil", 30000));
        employees.add(new Employee(102, "gani", 80000));

        employees.sort(Comparator.comparingDouble(emp -> emp.salary));

        while (true) {

            System.out.println("all the employees");
            for (Employee n : employees) {
                System.out.println(n);
            }
            System.out.println("1 . add employee");
            System.out.println("2 . remove employee");
            System.out.println("3 . update employee");
            System.out.println("4 . exit");
            System.out.println("5 . list all the employees");
            System.out.println("enter your choice: ");
            int choice = s.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("enter the name : ");
                    String name = s.nextLine();
                    s.nextLine();
                    System.out.println("enter the id : ");
                    int id = s.nextInt();
                    System.out.println("enter the salary: ");
                    double salary = s.nextDouble();
                    employees.add(new Employee(id, name, salary));
                    System.out.println("employee added successfully!");
                    break;
                case 2:
                    System.out.println("enter the employee id to remove: ");
                    int rm = s.nextInt();
                    employees.removeIf(emp -> emp.id == rm);
                    System.out.println("removed successfully !");
                    break;
                case 3:
                    System.out.println(" enter the employee id to update : ");
                    int eid = s.nextInt();
                    for (Employee emp : employees) {
                        if (emp.id == eid) {
                            s.nextLine();
                            System.out.println("enter the new name : ");
                            emp.name = s.nextLine();
                            System.out.println("enter the new salary: ");
                            emp.salary = s.nextDouble();
                            System.out.println("employee updated!!!");
                        }
                    }
                    break;
                case 4:
                    System.out.println("exiting....");
                    s.close();
                    return;
                case 5:
                    for (Employee emp : employees) {
                        System.out.println(emp);
                    }
                    break;
                default:
                    System.out.println("invalid choice!!!");
            }
        }
    }
}
