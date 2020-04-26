package com.xworkz.register.dao;

import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.register.entity.RegisterEntity;
import com.xworkz.register.exceptions.DAOExceptions;

@Component
public class RegisterDAOImpl implements RegisterDAO {
	@Autowired
	private SessionFactory factory;

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public RegisterEntity save(RegisterEntity registerEntity) {
		System.out.println("Entered in to save");

		try {
			Session session = factory.openSession();
			session.beginTransaction();
			System.out.println("tx  is begin");
			System.out.println("data  is saving");
			if (Objects.nonNull(registerEntity)) {
				session.save(registerEntity);
			} else {
				System.out.println("cannot save");
			}

			session.getTransaction().commit();
			System.out.println("commited");

			System.out.println("all resource closed");
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registerEntity;

	}

	public RegisterEntity fetchbyuserId(String userId) {
		Session session = factory.openSession();
		System.out.println("searching userId..." + userId);
		try {
			System.out.println("invoked register fromIMPL");

			Query query = session.getNamedQuery("fetchbyuserId");
			query.setParameter("userId", userId);
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


	public RegisterEntity feachbyemail(String email) {
		Session session = factory.openSession();
		System.out.println("searching email..." + email);
		try {
			System.out.println("invoked register fromIMPL");

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
}
