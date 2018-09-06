package com.vt.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEST_SEQUENCE")
	@SequenceGenerator(name = "TEST_SEQUENCE", sequenceName = "TEST_SEQUENCE", allocationSize = 1)
	@Column(name = "ID")
	private Long id;

	@Column(name = "title")
	private String title;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PostComment> comments = new ArrayList<PostComment>();

	public Post() {
		super();
	}

	public Post(String title) {
		this.title = title;

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

	public List<PostComment> getComments() {
		return comments;
	}

	public void setComments(List<PostComment> comments) {
		this.comments = comments;
	}

	public void addComment(PostComment postComment) {
		comments.add(postComment);
		postComment.setPost(this);
	}

	public void removeComment(PostComment comment) {
		comments.remove(comment);
		comment.setPost(null);
	}
}