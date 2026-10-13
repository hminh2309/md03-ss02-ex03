package com.example.ss02.exer02.controllers;

import com.example.ss02.exer02.models.Task;
import com.example.ss02.exer02.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Lấy danh sách task, có hỗ trợ tìm kiếm gần đúng theo title
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(@RequestParam(required = false) String search) {
        List<Task> allTasks = taskService.findAllTasks();

        // Nếu không truyền tham số search thì trả về toàn bộ
        if (search == null || search.trim().isEmpty()) {
            return new ResponseEntity<>(allTasks, HttpStatus.OK);
        }

        // Lọc danh sách gần đúng bằng vòng lặp for
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : allTasks) {
            if (task.getTitle() != null && task.getTitle().toLowerCase().contains(search.toLowerCase())) {
                filteredTasks.add(task);
            }
        }

        return new ResponseEntity<>(filteredTasks, HttpStatus.OK);
    }
}