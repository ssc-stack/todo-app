package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/* TODO-APP: CREATE, FETCH, UPDATE, DELETE */

@RestController
public class TodoController {

    @RequestMapping("/api/username/{username}")
    public String helloUser(@PathVariable String username) {
        return "hello " + username;
    }

}
