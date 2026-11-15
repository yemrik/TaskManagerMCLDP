
package com.todoapplication;

import com.todoapplication.controller.TaskManager;
import com.todoapplication.repository.DatabaseManager;
import com.todoapplication.repository.TaskRepository;
import com.todoapplication.service.TaskService;
import com.todoapplication.service.UserService;
import com.todoapplication.repository.UserRepository;
import com.todoapplication.view.TaskUI;

public class Main {

    public static void main(String[] args) {
        TaskRepository taskRepository = new TaskRepository();
        TaskService taskService = new TaskService(taskRepository);
     

        UserService userService =
            new UserService(new UserRepository(DatabaseManager.getConnection()));

        TaskManager taskManager =
            new TaskManager(taskService, userService);

        TaskUI taskUI = new TaskUI();

        while (true) {

            taskUI.displayTaskListMenu();

            int choice = taskUI.getUserInput();

            String result;

            switch (choice) {

                case 1:
                    result = taskManager.addTask(taskUI);
                    break;

                case 2:
                    result = taskManager.performTask(2, taskUI);
                    break;

                case 3:
                    result = taskManager.performTask(3, taskUI);
                    break;

                case 4:
                    result = taskManager.performTask(4, taskUI);
                    break;

                case 5:
                    result = taskManager.performTask(5, taskUI);
                    break;

                case 6:
                    result = taskManager.performTask(6, taskUI);
                    break;

                default:
                    result = "Invalid input. Please try again.";
            }

            taskUI.displayMessage(result);
        }
    }
}
