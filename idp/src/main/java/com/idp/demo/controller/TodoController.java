package com.idp.demo.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.idp.demo.model.Todo;
import com.idp.demo.services.TodoService;

@Controller
@SessionAttributes("name")
@RequestMapping(value = "/todo")
public class TodoController {

	@Autowired
	TodoService service; // = new LoginSerive();

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String login(ModelMap model, @RequestParam String user) {
		
		System.out.println("Name : "+model.get("name"));
		model.put("todoList", service.retrieveTodos(user));
		return "todo-list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap model) {
		model.addAttribute("todo", new Todo(0, "mk", "Default Desc", new Date(), false));
		return "todo-add";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(ModelMap model, @RequestParam int id) {
		model.addAttribute("todo", service.retrieveTodo(id));
		return "todo-add";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()){
			System.out.println("ERRORs FOUND in Bean Validation!");
			return "todo-add";
		}
		
		service.updateTodo(todo);
		
		model.put("todoList", service.retrieveTodos(todo.getUser()));
		return "todo-list";
				
	}
	
	//Command Bean or Form Backing Bean
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(ModelMap model, @Valid Todo todo, BindingResult result) {

		if(result.hasErrors()){
			System.out.println("ERRORs FOUND in Bean Validation!");
			return "todo-add";
		}
		//String name = model.get("name").toString();
		service.addTodo(todo.getUser(), todo.getDesc(), new Date(), todo.isDone());
		
		model.put("todoList", service.retrieveTodos(todo.getUser()));
		return "todo-list";
		//return "redirect:/todo/list";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(ModelMap model, @RequestParam int id) {
		
		System.out.println("Delete : "+id);
		service.deleteTodo(id);
		model.put("todoList", service.retrieveTodos("mk"));
		return "todo-list";
	}
}
