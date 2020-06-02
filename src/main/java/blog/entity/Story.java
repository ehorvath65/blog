package blog.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Story {

	@GeneratedValue
	@Id
	private Long id;
	private String title;
	private String title_long;
	@Column(columnDefinition = "TEXT")
	private String content;
	private Date posted;
	private String category;
	private String logo;
	@ManyToOne
	private User user;
	@ManyToOne
	private Cat cat;

	public Story() {
	}

	public Story(String title, String title_long, String content, Date posted, String category, String logo, User user, Cat cat) {
		this.title = title;
		this.title_long = title_long;
		this.content = content;
		this.posted = posted;
		this.category = category;
		this.logo = logo;
		this.user = user;
		this.cat = cat;
	}

	public Cat getCat() {
		return cat;
	}

	public void setCat(Cat cat) {
		this.cat = cat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPosted() {
		return posted;
	}

	public void setPosted(Date posted) {
		this.posted = posted;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle_long() {
		return title_long;
	}

	public void setTitle_long(String title_long) {
		this.title_long = title_long;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Story [id=" + id + ", title=" + title + ", title_long=" + title_long + ", content=" + content + ", posted=" + posted + ", category="
				+ category + ", logo=" + logo + ", user=" + user + ", cat=" + cat + "]";
	}

}
