package utils;

import model.Task;
import servieses.TaskServieces;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class AutoSaveTask extends Thread {
    private TaskServieces taskServieces;

    public AutoSaveTask(TaskServieces taskServieces) {
        this.taskServieces = taskServieces;
    }

    @Override
    public void run() {
        while (true) {
            try {
                List<Task> tasks = taskServieces.getAllTasks();
                FileWriter writer = new FileWriter("tasks_backup.txt");
                for (Task task : tasks) {
                    writer.write(task.toString() + "\n");
                }
                writer.close();
                System.out.println("Auto-saved tasks to file.");
                Thread.sleep(300000);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
