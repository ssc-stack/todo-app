package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

////https://github.com/ssc-stack/todo-app/tree/master/
/* TODO-APP: CREATE, FETCH, UPDATE, DELETE */

@RestController
@RequestMapping("/api/v1/todo-app")
public class TodoController {


    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService=todoService;
    }

    @PostMapping
    public void addTodo(@RequestBody Todo todo) {

    }

    @GetMapping("/find-todo/id/{id}")
    public Todo findTodoById(@PathVariable int id) {
        return todoService.findById(id);
    }

    //http://localhost:8080/api/v1/todo-app/find-all
    @GetMapping("find-all")
    public List<Todo> findAllTodos() { // controller is talking to the service layer
        return todoService.findAll();
    }

    //@RequestMapping(value="url",method=HttpRequest.PUT)
    @PutMapping
    public void updateTodo(@PathVariable int id, @RequestBody Todo todo) {

    }

    @DeleteMapping
    public void deleteTodo(@PathVariable int id) {

    }
}
