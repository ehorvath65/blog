package blog.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cat {

	@Id
	private Long id;

	private String cat;
	private String catname;
	private String catcolor;

	@OneToMany(mappedBy = "cat")
	private List<Story> stories;

	public Cat() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public String getCatname() {
		return catname;
	}

	public void setCatname(String catname) {
		this.catname = catname;
	}

	public String getCatcolor() {
		return catcolor;
	}

	public void setCatcolor(String catcolor) {
		this.catcolor = catcolor;
	}

	public List<Story> getStories() {
		return stories;
	}

	public void setStories(List<Story> stories) {
		this.stories = stories;
	}

	@Override
	public String toString() {
		return "Cat [id=" + id + ", cat=" + cat + ", catname=" + catname + ", catcolor=" + catcolor + "]";
	}

}
