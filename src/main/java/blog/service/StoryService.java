package blog.service;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import blog.entity.Story;
import blog.repo.StoryRepository;
import blog.repo.UserRepository;

@Service
public class StoryService {

	private StoryRepository storyRepo;
	private UserRepository userRepo;
	private LinkedHashMap<String, String> counted;

	@Autowired
	public void setStoryRepo(StoryRepository storyRepo) {
		this.storyRepo = storyRepo;
	}

	@Autowired
	public void setUserRepo(UserRepository userRepo) {
		this.userRepo = userRepo;
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
		Date date = new Date();
		story.setPosted(date); // dátumot hozzáadjuk

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();

		System.out.println("szöveg: " + currentPrincipalName);
		story.setUser(userRepo.findByFullName(currentPrincipalName));

		storyRepo.save(story);
		// SQL-ben ezt kellett ehhez futtatni: CREATE SEQUENCE hibernate_sequence START
		// 1;
	}

	public void delete(Story story) {
		storyRepo.delete(story);
	}

}