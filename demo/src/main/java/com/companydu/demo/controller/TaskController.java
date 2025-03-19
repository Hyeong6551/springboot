package com.companydu.demo.controller;

import com.example.model.Task;
import com.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {
	
    @Autowired
    private TaskService taskService;

    @GetMapping
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        // View Resolver로 보냄
        return "task/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("task", new Task());
        return "task/form";
    }
    
    // example
    @GetMapping("/newForm")
    public String newForm() {
    	return "task/newForm";
    }

    @GetMapping("/result")
	public String getResult(@RequestParam String name, Model model) {
    	System.out.println("get : "+name);
    	model.addAttribute("resultName",name);
		return "task/result";
	}
    
    @PostMapping("/result")
	public String postResult(@RequestParam String name, Model model) {
    	System.out.println("post : "+name);
    	model.addAttribute("resultName",name);
		return "task/result";
	}
    //
    
    @PostMapping
    public String createTask(@ModelAttribute Task task) {
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("task", taskService.getTaskById(id));
        return "task/form";
    }

    @PostMapping("/update")
    public String updateTask(@ModelAttribute Task task) {
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }
} 