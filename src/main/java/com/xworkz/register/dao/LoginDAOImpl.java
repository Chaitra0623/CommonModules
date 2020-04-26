package com.xworkz.register.dao;

import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.register.entity.RegisterEntity;
@Component
public class LoginDAOImpl implements LoginDAO {
	@Autowired
	private SessionFactory factory;

	public void setFactory(SessionFactory factory) {
		System.out.println("created \t"+this.getClass().getSimpleName());
		this.factory = factory;
	}

	public RegisterEntity feachbyemail(String email) {
		System.out.println("invoking feachbyemail method - LoginDAOImpl ");
		Session session = factory.openSession();
		try {
			Query query = session.getNamedQuery("fetchbyemail");
			query.setParameter("email", email);
			System.out.println("query " + query);
			Object out = query.uniqueResult();
			if (Objects.nonNull(out)) {
				RegisterEntity registerEntity = (RegisterEntity) out;
				return registerEntity;
			}
			else {
				System.out.println("not available");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();

		}
		return null;
	}

	public RegisterEntity fetchbypassword(String password) {
		System.out.println("invoking fetchbypassword method - LoginDAO Impl");
		Session session = factory.openSession();
		try {
			Query query = session.getNamedQuery("fetchbypassword");
			query.setParameter("password", password);
			System.out.println("query " + query);
			Object out = query.uniqueResult();
			if (Objects.nonNull(out)) {
				RegisterEntity registerEntity = (RegisterEntity) out;
				return registerEntity;
			}
			else {
				System.out.println("not available");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();

		}
		return null;
	}

	public Integer validLoginUser(String email, String password) {
		System.out.println("Invoking validLoginUser method - loginDAOImpl");
		Session session = factory.openSession();
		Integer count =0;
		try {
			Query query = session.getNamedQuery("countbyemailpassword");
			query.setParameter("email", email);
			query.setParameter("password", password);
			System.out.println("query " + query);
			Object out = query.uniqueResult();
			if (Objects.nonNull(out)) {
				 count =((Long) out).intValue();
				return count;
			}

			else {
				System.out.println("not available");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();

		}
		return count;
	}

	public Integer feachAttempt(String email) {
		System.out.println("invoking feachAttempt method - LoginDAOImpl");
		Session session = factory.openSession();
		Integer count =0;
		try {

			Query query = session.getNamedQuery("countbyemail");
			query.setParameter("email", email);
			System.out.println("query " + query);
			Object out = query.uniqueResult();
			if (Objects.nonNull(out)) {			
				 count =(Integer) out;
				return count;
			}

			else {
				System.out.println("not available");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();

		}
		return count;
	}

	public Integer updateAttempt(String email, int noOfAttempt) {
		System.out.println("invoking updateAttempt method - loginDAOImpl ");
		Session session = factory.openSession();
		Integer count =0;
		try {
			session.getTransaction().begin();
			Query query = session.getNamedQuery("incCountbyemail");
			query.setParameter("email", email);
			query.setParameter("noOfAttempt",noOfAttempt);
			System.out.println("query--> " + query);
			Object out = query.executeUpdate();//query.uniqueResult();
			session.getTransaction().commit();
			if (Objects.nonNull(out)) {
				 count =(Integer) out;
				return count;
			}

			else {
				System.out.println("not available");
			}

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();

		}
		return count;
	}
}


