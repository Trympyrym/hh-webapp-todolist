package test.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import test.spring.Database;
import test.spring.DatabaseRecord;


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
    public String add(@RequestParam("newTaskName") String newTaskName)
    {
        database.add(new DatabaseRecord(newTaskName));
        return "redirect:index.html";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String remove(@RequestParam("id") String index)
    {
        database.remove(index);

        return "redirect:index.html";
    }

    @RequestMapping(value = "/changeDoneMark", method = RequestMethod.POST)
    public String changeDoneMark(@RequestParam("id") String index)
    {
        database.changeDoneMark(index);

        return "redirect:index.html";
    }

    @RequestMapping(value = "/Edit", method = RequestMethod.GET)
    public String openEditForm(@RequestParam("id") String index, @ModelAttribute("model") ModelMap model)
    {
        model.addAttribute("name", "Editing");
        model.addAttribute("index", index);
        model.addAttribute("taskName", database.getName(index));
        return "edit";
    }

    @RequestMapping(value = "/rename", method = RequestMethod.POST)
    public String renameTask(@RequestParam("id") String index, @RequestParam("newName") String newName)
    {
        database.setName(index, newName);
        return "redirect:index.html";
    }

}
