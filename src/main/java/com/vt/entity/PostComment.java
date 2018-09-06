package com.vt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "post_comment")
public class PostComment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEST_SEQUENCE")
	@SequenceGenerator(name = "TEST_SEQUENCE", sequenceName = "TEST_SEQUENCE", allocationSize = 1)
	@Column(name = "ID")
	private Long id;

	@Column(name = "review")
	private String review;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id")
	private Post post;

	public PostComment() {
		super();
	}

	public PostComment(String review) {
		this.review = review;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
}
