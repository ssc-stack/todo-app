package com.example.todo.service;


import com.example.todo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


@Service
public class TodoService implements  ITodoService {

    private static List<Todo> todos=new ArrayList<>(); // In-memory database
    private static int todoCount=0;

    static {
        todos.add(new Todo(++todoCount,"Learn Spring Boot",false));
        todos.add(new Todo(++todoCount,"Visit Grocery Store",false));
        todos.add(new Todo(++todoCount,"Learn AWS",false));
        todos.add(new Todo(++todoCount,"Swimming",false));
        todos.add(new Todo(++todoCount,"Yoga",false));
    }

    @Override
    public List<Todo> findAll() { // Business Logic
        return todos;
    }

    @Override
    public Todo findById(int id) { // business LOgic
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    @Override
    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    @Override
    public void deleteTodo(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    @Override
    public void updateTodo(int id,Todo newTodo) {
        //step 1: find todo to be update
        //Step 2: update todo

        Todo todo=findById(id);// step 1
        todo.setId(newTodo.getId());
        todo.setTitle(newTodo.getTitle());
        todo.setStatus(newTodo.isStatus());
    }
}



















// return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//return new ResponseEntity<>(todoService.getTodoById(todoId), HttpStatus.OK);
//return new ResponseEntity<>(todo, HttpStatus.CREATED);
/*

{
    "id":100,
    "title": "Buy eggs from supermarket",
    "status": false
}

Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;

Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);

 */