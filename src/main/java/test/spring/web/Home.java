package test.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import test.spring.Database;
import test.spring.DatabaseRecord;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Home {
    private static Database database = new Database();
    static
    {
        database.add(new DatabaseRecord("first task"));
        database.add(new DatabaseRecord("second task"));
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String redirectToIndex()
    {
        return "redirect:index.html";
    }

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String init(@ModelAttribute("model") ModelMap model) {
		model.addAttribute("name", "Todo list");

		model.addAttribute("tasks", database.getAll());
		return "index";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(String newTaskName)
    {
        database.add(new DatabaseRecord(newTaskName));
        return "redirect:index.html";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String remove(@RequestParam("id") int id)
    {
        database.remove(id);

        return "redirect:index.html";
    }

    @RequestMapping(value = "/changeDoneMark", method = RequestMethod.POST)
    public String changeDoneMark(String index)
    {
        database.changeDoneMark(castFreemarkerInputToInt(index));

        return "redirect:index.html";
    }

    private Integer castFreemarkerInputToInt(String argString)
    {
        return Integer.parseInt(argString.substring(0, argString.length() - 1));
    }
}
