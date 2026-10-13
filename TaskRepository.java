package com.example.ss02.exer02.repositories;

import com.example.ss02.exer02.models.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {

    private List<Task> tasks = new ArrayList<>();

    public TaskRepository() {
        tasks.add(new Task(1L, "Thực hành Spring Boot", "Học cấu trúc 3 tầng", "high", 1L));
        tasks.add(new Task(2L, "Thiết kế REST API", "Viết chuẩn endpoint", "medium", 2L));
        tasks.add(new Task(3L, "Cài đặt môi trường", "Cấu hình Maven và JDK", "low", 1L));
        tasks.add(new Task(4L, "Tạo Git repository", "Tạo repo đẩy bài tập", "medium", 3L));
        tasks.add(new Task(5L, "Đọc tài liệu DI", "Tìm hiểu Constructor Injection", "high", 2L));
        tasks.add(new Task(6L, "Làm bài tập Session 02", "Hoàn thiện các yêu cầu", "high", 1L));
        tasks.add(new Task(7L, "Viết Unit Test", "Test logic service", "low", 3L));
        tasks.add(new Task(8L, "Review code", "Xem lại cấu trúc code", "medium", 2L));
        tasks.add(new Task(9L, "Tối ưu code", "Rà soát lỗi cú pháp", "low", 1L));
        tasks.add(new Task(10L, "Chuẩn bị nộp bài", "Commit và push code lên GitHub", "high", 2L));
    }

    public List<Task> findAll() {
        return tasks;
    }
}