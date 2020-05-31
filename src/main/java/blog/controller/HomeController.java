package blog.controller;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
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
	private LinkedHashMap<String, String> counted = new LinkedHashMap<>();

	@Autowired
	public void setStoryService(StoryService storyService) {
		this.storyService = storyService;
	}

	private HashSet<String> categories = new HashSet<>(Arrays.asList("java", "r", "sql", "gis", "springboot"));

	private void extracted(Model model) {
		model.addAttribute("limit4", storyService.getAllByLimited4());
		model.addAttribute("catDist", storyService.getDistinctLowerCategory());
		for (String category : categories) {
			counted.put(category, storyService.countByCategoryIgnoreCase(category));
		}
		model.addAttribute("counted", counted);
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
		if (categories.contains(control)) {
			model.addAttribute(control, storyService.getStoriesByCategoryName(control));
			model.addAttribute("controlAll", storyService.getStoriesByCategoryName(control));
			return "categories";
//
		} else {
			model.addAttribute("story", storyService.getSpecificStory(control));
			return "story";
		}
	}

}