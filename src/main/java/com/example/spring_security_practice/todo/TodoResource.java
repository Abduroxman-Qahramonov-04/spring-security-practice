package com.example.spring_security_practice.todo;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;

@RestController
public class TodoResource {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private static final List<Todo> TODO_LIST = List.of(new Todo("in28minutes", "Learn AWS"),
            new Todo("in28minutes", "Get AWS Certified"));
    @GetMapping("/todos")
    public List<Todo> retrieveAllTodos(){
        return TODO_LIST;
    }
    @GetMapping("/users/{username}/todos")
    public Todo retrieveTodoByUsername(@PathVariable String username){
        return TODO_LIST.get(0);
    }
    @PostMapping("/users/{username}/todos")
    public void postTodo(@PathVariable String username, @RequestBody Todo todo){
        logger.info("Create {} for {}", todo, username);
    }

}
record Todo (String username,String description){}
