
import java.util.Scanner;

public class Oop2 {
    public static void main(String[] args) {
        String name;
        TaskList taskList = new TaskList(10);  // Example: Maximum of 10 tasks
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            switch(choice) {
                case 1:
                     System.out.print("Enter task name: ");
                     name=scanner.next();
                     taskList.addTask(name);
                    break;
                case 2:
                    if (!taskList.isEmpty()) {
                        taskList.listTasks();
                        System.out.println("Enter the task number to remove: ");
                        int taskNumber = scanner.nextInt();
                        if (taskList.isValidTaskNumber(taskNumber)) {
                            taskList.removeTask(taskNumber);
                        } else {
                            System.out.println("Invalid task number.");
                        }
                    } else {
                        System.out.println("No tasks to remove.");
                    }
                    break;
                case 3:
                    if (!taskList.isEmpty()) {
                        taskList.listTasks();
                    } else {
                        System.out.println("No tasks to list.");
                    }
                    break;
                case 4:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }while(choice!=4);
            
        
    }

    private static void displayMenu() {
        System.out.println("Task List Application");
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. List Tasks");
        System.out.println("4. Quit");
        System.out.print("Select an option: ");
    }
}

class TaskList {
    private String[] tasks;
    private int taskCount;

    public TaskList(int maxTasks) {
        tasks = new String[maxTasks];
        taskCount = 0;
    }

    public void addTask(String name) {
        if (taskCount < tasks.length) {
            tasks[taskCount] = name;
            taskCount++;
            System.out.println("Task added.");
        } else {
            System.out.println("Cannot add task. Task list is full.");
        }
    }

    public void removeTask(int taskNumber) {
        for (int i = taskNumber - 1; i < taskCount - 1; i++) {
            tasks[i] = tasks[i + 1];
        }
        tasks[taskCount - 1] = null; // Clear last task
        taskCount--;
        System.out.println("Task removed.");
    }

    public void listTasks() {
        for (int i = 0; i < taskCount; i++) {
            System.out.println((i + 1) + ". " + tasks[i]);
        }
    }

    public boolean isEmpty() {
        return taskCount == 0;
    }

    public boolean isValidTaskNumber(int taskNumber) {
        return taskNumber >= 1 && taskNumber <= taskCount;
    }
}
