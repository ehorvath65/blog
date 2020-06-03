package blog.controller;

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
import blog.service.CatService;
import blog.service.StoryService;

@Controller
public class HomeController {

	private StoryService storyService;
	private CatService catService;
	private LinkedHashMap<String, String> counted = new LinkedHashMap<>();

	@Autowired
	public void setStoryService(StoryService storyService) {
		this.storyService = storyService;
	}
	
	@Autowired
	public void setCatService(CatService catService) {
		this.catService = catService;
	}

	private void extracted(Model model) {
		model.addAttribute("completeCats", catService.getCompleteCats());
		model.addAttribute("limit4", storyService.getAllByLimited4());
		model.addAttribute("catDist", storyService.getDistinctLowerCategory());
		for (String category : storyService.getDistinctLowerCategory()) {
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
		if (storyService.getDistinctLowerCategory().contains(control)) {
			model.addAttribute("controlAll", storyService.getStoriesByCategoryName(control));
			return "categories";
		} else {
			model.addAttribute("story", storyService.getSpecificStory(control));
			return "story";
		}
	}

}