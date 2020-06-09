package blog.service;

import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import blog.entity.Story;
import blog.repo.CatRepository;
import blog.repo.StoryRepository;
import blog.repo.UserRepository;

@Service
public class StoryService {

	private StoryRepository storyRepo;
	private UserRepository userRepo;
	private CatRepository catRepo;
	private LinkedHashMap<String, String> counted;

	@Autowired
	public void setStoryRepo(StoryRepository storyRepo) {
		this.storyRepo = storyRepo;
	}

	@Autowired
	public void setUserRepo(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@Autowired
	public void seCatRepo(CatRepository catRepo) {
		this.catRepo = catRepo;
	}

	public List<Story> getStories() {
		return storyRepo.findAll();
	}

	public Story getStory() {
		return storyRepo.findFirstByOrderByPostedDesc();
	}

	public Story getSpecificStory(String title) {
		return storyRepo.findByTitle(title);
	}

	public List<Story> getStoriesByCategoryName(String category) {
		return storyRepo.findAllByCategoryIgnoreCaseOrderByPostedDesc(category);
	}

	public List<Story> getFirstByCategoryName(String category) {
		return storyRepo.findFirstByCategoryIgnoreCaseOrderByPostedDesc(category);
	}

	public List<Story> getAllByLimited4() {
		return storyRepo.findAllLimitedTo4();
	}

	public List<String> getDistinctLowerCategory() {
		return storyRepo.findDistinctLowerCategory();
	}

	public LinkedHashMap<String, String> getCounted() {
		counted = new LinkedHashMap<>();
		for (String category : getDistinctLowerCategory()) {
			counted.put(category, storyRepo.countByCategoryIgnoreCase(category));
		}
		return counted;
	}

	public void save(Story story) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		story.setPosted(timestamp);
		story.setCat(catRepo.findByCat(story.getCategory()));

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();

		story.setUser(userRepo.findByFullName(currentPrincipalName));

		storyRepo.save(story);
	}

	public void delete(Story story) {
		storyRepo.delete(story);
	}

}