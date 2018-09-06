package com.vt.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.vt.entity.Post;
import com.vt.entity.PostComment;
import com.vt.util.HibernateUtils;

public class Test {
	public static void main(String[] args) {

		Post post = new Post("First post");

		post.addComment(new PostComment("My first review"));
		post.addComment(new PostComment("My second review"));
		post.addComment(new PostComment("My third review"));

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			// Get Session
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			System.out.println("Session created");
			tx = session.beginTransaction();
			session.save(post);
			tx.commit();
		} catch (Exception e) {
			System.out.println("Exception occured. " + e.getMessage());
			tx.rollback();
		} finally {
			if (!sessionFactory.isClosed()) {
				System.out.println("Closing SessionFactory");
				sessionFactory.close();
			}
		}
	}
}
