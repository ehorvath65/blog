package blog.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import blog.entity.Story;
import blog.service.StoryService;

@Controller
public class HomeController {

	private StoryService storyService;
	private HashSet<String> categories = new HashSet<>(Arrays.asList("java", "r", "sql", "gis"));

	private void extracted(Model model) {
		model.addAttribute("limit4", storyService.getAllByLimited4());
		model.addAttribute("countJava", storyService.countByCategoryIgnoreCase("java"));
		model.addAttribute("countR", storyService.countByCategoryIgnoreCase("r"));
		model.addAttribute("countSql", storyService.countByCategoryIgnoreCase("sql"));
		model.addAttribute("countGis", storyService.countByCategoryIgnoreCase("gis"));
		model.addAttribute("countTech", storyService.countByCategoryIgnoreCase("tech"));
		model.addAttribute("countData", storyService.countByCategoryIgnoreCase("data"));
	}

	@Autowired
	public void setStoryService(StoryService storyService) {
		this.storyService = storyService;
	}

	@RequestMapping("/")
	public String home4(Model model, Locale locale) {
		extracted(model);
		return "index";
	}
	
	@RequestMapping("/createposts")
	public String createposts(Model model) {
		model.addAttribute("story", new Story());
		extracted(model);
		return "createposts";
	}

	// @RequestMapping(value = "/create", method = RequestMethod.POST)
	@PostMapping("/create")
	public String postSubmit(@ModelAttribute Story story) {
		storyService.save(story);
		return "created";
	}
	
	@RequestMapping("/{control}")
	public String searchForCategory(@PathVariable(value = "control") String control, Model model) throws Exception {
		extracted(model);
		if (control == null)
			throw new Exception("Nincs ilyen oldal!");
		if (categories.contains(control)) {
			model.addAttribute(control, storyService.getStoriesByCategoryName(control));
			model.addAttribute(control + "All", storyService.getStoriesByCategoryName(control));		
			return (control);
		} else {
			model.addAttribute("story", storyService.getSpecificStory(control));
			return "story";
		}
	}

}