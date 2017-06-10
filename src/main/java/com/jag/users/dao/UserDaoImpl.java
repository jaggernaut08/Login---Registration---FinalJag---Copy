package com.jag.users.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.jag.users.model.User;
import org.hibernate.Transaction;
import org.hibernate.SQLQuery;


public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;
	
    @Autowired
    public void save(User user) {
        Session session = sessionFactory.openSession();  
        Transaction transaction2 = session.beginTransaction();
        session.save(user);
        transaction2.commit();
        session.close();
             
        Session session2 = sessionFactory.openSession();
        Transaction transaction = session2.beginTransaction();
        SQLQuery insertQuery2 = session2.createSQLQuery("" +"UPDATE `test`.`users` SET `enabled`='1' WHERE `username`=?");
        insertQuery2.setParameter(0, user.getUsername());
        insertQuery2.executeUpdate();
        transaction.commit();
        session2.close();
        
        Session session1 = sessionFactory.openSession();
        Transaction transaction1 = session1.beginTransaction();
        SQLQuery insertQuery1 = session1.createSQLQuery("" +"insert into user_roles (user_role_id,username, role) values (?,?, ?)");
        insertQuery1.setParameter(0, 0);        
        insertQuery1.setParameter(1, user.getUsername());
        insertQuery1.setParameter(2, "ROLE_ADMIN");
        insertQuery1.executeUpdate();
        transaction1.commit();
        session1.close();
        
    }

	@SuppressWarnings("unchecked")
	@Override
	public User findByUserName(String username) {

		List<User> users = new ArrayList<User>();

		users = getSessionFactory().getCurrentSession().createQuery("from User where username=?")
				.setParameter(0, username).list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}