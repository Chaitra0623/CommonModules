package com.xworkz.register.dao;

import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.register.entity.RegisterEntity;


@Component
public class ForgotPasswordDAOImpl implements ForgotPasswordDAO {
		@Autowired
		private SessionFactory factory;

		public void setFactory(SessionFactory factory) {
			this.factory = factory;
		}

			public Integer updateForgot(String password,int noOfAttempt ,String email) {
				System.out.println("Entered in to save");

				try {
					Session session = factory.openSession();
					session.beginTransaction();
					System.out.println("tx  is begin");
					System.out.println("data  is saving");
					Query query = session.getNamedQuery("updateForgotPassword");
					query.setParameter("password",password);
					query.setParameter("nao",noOfAttempt);
					query.setParameter("email",email);

					System.out.println("query " + query);
					Object out = query.executeUpdate();
					session.getTransaction().commit();
					System.out.println("commited");
					System.out.println("all resource closed");
					session.close();
					return 1;

				} catch (Exception e) {
					e.printStackTrace();
				}
				return 0;

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
			}

