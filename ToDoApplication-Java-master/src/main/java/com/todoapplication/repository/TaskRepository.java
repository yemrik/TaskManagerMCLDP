
package com.todoapplication.repository;

import com.todoapplication.model.Task;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    private final List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        task.setId(tasks.size() + 1);
        tasks.add(task);
    }

    public void deleteTask(int taskId) {
        tasks.removeIf(task -> task.getId() == taskId);
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }
}
