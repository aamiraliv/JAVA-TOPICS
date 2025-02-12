
import servieses.TaskServieces;
import utils.AutoSaveTask;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskServieces taskService = new TaskServieces();

        AutoSaveTask autoSave = new AutoSaveTask(taskService);
        autoSave.start();
        System.out.println("Task Management System Running...");
        while (true) {
            System.out.println("\nEnter task title (or type 'exit' to quit): ");
            String title = scanner.nextLine();
            if (title.equalsIgnoreCase("exit")) break;

            System.out.println("Enter task DESCRIPTION: ");
            String description = scanner.nextLine();

            System.out.println("Enter task assigned_to: ");
            String assigned_to = scanner.nextLine();

            System.out.println("Enter task status (Pending/In Progress/Completed): ");
            String status = scanner.nextLine();

            taskService.addtask(title,description,assigned_to,status);
        }

        scanner.close();
        System.out.println("📌 Exiting Task Management System...");
    }
}
