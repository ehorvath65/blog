package blog.controller;

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

//	private void extracted(Model model) {
//		model.addAttribute("limit4", storyService.getAllByLimited4());
//		model.addAttribute("countJava", storyService.getCountCategories("java"));
//		model.addAttribute("countR", storyService.getCountCategories("r"));
//		model.addAttribute("countSql", storyService.getCountCategories("sql"));
//		model.addAttribute("countGis", storyService.getCountCategories("gis"));
//		model.addAttribute("countTech", storyService.getCountCategories("tech"));
//		model.addAttribute("countData", storyService.getCountCategories("data"));
//	}
	
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
		model.addAttribute("tech2", storyService.getFirstByCategoryName("tech"));
		model.addAttribute("data2", storyService.getFirstByCategoryName("data"));
		model.addAttribute("java2", storyService.getFirstByCategoryName("java"));
		model.addAttribute("r2", storyService.getFirstByCategoryName("r"));
		model.addAttribute("gis2", storyService.getFirstByCategoryName("gis"));
		model.addAttribute("sql2", storyService.getFirstByCategoryName("sql"));
		extracted(model);
		return "index";
	}

	@RequestMapping("/{title}")
	public String searchForUser(@PathVariable(value = "title") String title, Model model) throws Exception {
		if (title == null)
			throw new Exception("Nincs ilyen címmel sztorink!");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + title);
		model.addAttribute("story", storyService.getSpecificStory(title));
		model.addAttribute("limit4", storyService.getAllByLimited4());

		extracted(model);
		return "story";
	}

//	@RequestMapping("/{category}")
//	public String searchForCategory(@PathVariable(value = "category") String category, Model model) throws Exception {
//		if (category == null)
//			throw new Exception("Nincs ilyen kategória!");
//		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + category);
//		model.addAttribute(category, storyService.getStoriesByCategoryName(category));
//		model.addAttribute(category + "All", storyService.getStoriesByCategoryName(category));
//		extracted(model);
//		return category;
//	}

	@RequestMapping("/java")
	public String java(Model model, Locale locale) {
		model.addAttribute("java", storyService.getStoriesByCategoryName("java"));
		model.addAttribute("javaAll", storyService.getStoriesByCategoryName("java"));
		extracted(model);
		return "java";
	}

	@RequestMapping("/gis")
	public String gis(Model model, Locale locale) {
		model.addAttribute("gis", storyService.getStoriesByCategoryName("gis"));
		model.addAttribute("gisAll", storyService.getStoriesByCategoryName("gis"));
		extracted(model);
		return "gis";
	}

	@RequestMapping("/r")
	public String r(Model model, Locale locale) {
		model.addAttribute("r", storyService.getStoriesByCategoryName("r"));
		model.addAttribute("rAll", storyService.getStoriesByCategoryName("r"));
		extracted(model);
		return "r";
	}

	@RequestMapping("/data")
	public String data(Model model, Locale locale) {
		model.addAttribute("data", storyService.getStoriesByCategoryName("data"));
		model.addAttribute("dataAll", storyService.getStoriesByCategoryName("data"));
		extracted(model);
		return "data";
	}

	@RequestMapping("/sql")
	public String sql(Model model, Locale locale) {
		model.addAttribute("sql", storyService.getStoriesByCategoryName("sql"));
		model.addAttribute("sqlAll", storyService.getStoriesByCategoryName("sql"));
		extracted(model);
		return "sql";
	}

	@RequestMapping("/tech")
	public String tech(Model model, Locale locale) {
		model.addAttribute("tech", storyService.getStoriesByCategoryName("tech"));
		model.addAttribute("techAll", storyService.getStoriesByCategoryName("tech"));
		extracted(model);
		return "tech";
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

}