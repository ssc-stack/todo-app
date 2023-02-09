package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.ITodoService;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

////https://github.com/ssc-stack/todo-app/tree/master/
/* TODO-APP: CREATE, FETCH, UPDATE, DELETE */

@RestController
@RequestMapping("/api/v1/todo-app")
public class TodoController {



     // Used to inject Dependency
    @Autowired
    private ITodoService todoService;



    //http://localhost:8080/api/v1/todo-app/add-todo
    @PostMapping("/add-todo")
    public void addTodo(@RequestBody Todo todo) {
        todoService.addTodo(todo);
    }

    //http://localhost:8080/api/v1/todo-app/find-todo/id/2
    @GetMapping("/find-todo/id/{id}")
    //@RequestMapping(value="/find-todo/id/{id}")
    public Todo findTodoById(@PathVariable int id) {
        return todoService.findById(id);
    }

    //http://localhost:8080/api/v1/todo-app/find-all
    @GetMapping("find-all")
    public List<Todo> findAllTodos() { // controller is talking to the service layer
        return todoService.findAll();
    }

    //http://localhost:8080/api/v1/todo-app/update-todo/id/4
    //@RequestMapping(value="url",method=HttpRequest.PUT)
    @PutMapping("update-todo/id/{id}")
    public void updateTodo(@PathVariable int id,@RequestBody Todo todo) {
        todoService.updateTodo(id,todo);
    }

    //http://localhost:8080/api/v1/todo-app/delete-todo/id/3
    @DeleteMapping("delete-todo/id/{id}")
    public void deleteTodo(@PathVariable int id) {
        todoService.deleteTodo(id);
    }

}
