package blog.service;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.entity.Cat;
import blog.repo.CatRepository;

@Service
public class CatService {

	private CatRepository catRepo;
	LinkedHashMap<String, Cat> completeCats = new LinkedHashMap<>();

	@Autowired
	public void setCatRepo(CatRepository catRepo) {
		this.catRepo = catRepo;
	}

	public LinkedHashMap<String, Cat> getCompleteCats() {
		List<Cat> items = catRepo.findAll();
		for (Cat item : items) {
			completeCats.put(item.getCat(), item);
		}
		return completeCats;
	}

}
