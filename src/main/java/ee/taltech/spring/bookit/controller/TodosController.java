package ee.taltech.spring.bookit.controller;

import ee.taltech.spring.bookit.domain.Todo;
import ee.taltech.spring.bookit.domain.TodoValuesDto;
import ee.taltech.spring.bookit.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("todos")
public class TodosController {

    @Resource
    TodoService todoService;


    @GetMapping(value = "/{id}")
    public String hello(Model model, @PathVariable Long id) {
        Todo todo = todoService.getTodo(id);
        model.addAttribute(todo);
        return "todos";
    }

    @GetMapping()
    public String getAllTodos(Model model){
        List<Todo> allTodos = todoService.getAllTodos();
        model.addAttribute("todos", allTodos);
        return "todo_list";
    }

    @PostMapping("form")
    public @ResponseBody Todo addTodo(@ModelAttribute Todo todo) {
        Todo result = todoService.addTodo(todo);
        return result;
    }

    @GetMapping("form")
    public String getForm(Model model) {
        model.addAttribute("todo", new Todo());
        return "form";
    }
    @GetMapping("change")
    public String getChangeForm(Model model) {
        TodoValuesDto todoValuesDto = new TodoValuesDto();
        todoValuesDto.setTodos(todoService.getAllTodos());
        model.addAttribute("form", todoValuesDto);
        return "change-todos";
    }

    @PostMapping("change")
    public String saveChangeForm(Model model, @ModelAttribute TodoValuesDto dto) {
        todoService.saveAll(dto.getTodos());

        model.addAttribute("form", dto);
        return "change-todos";
    }
}
