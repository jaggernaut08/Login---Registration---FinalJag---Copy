package com.jag.users.dao;

import java.util.ArrayList;
import java.util.List;
//import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import com.jag.users.model.User;
//import org.hibernate.Transaction;
//import org.hibernate.SQLQuery;


public class MobileDaoImpl implements MobileDao {

	private SessionFactory sessionFactory;
	
/*    @Autowired
    public void save(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        session.save(user);
        
        SQLQuery insertQuery = session.createSQLQuery("" +"UPDATE `test`.`users` SET `enabled`='1' WHERE `username`=?");
        insertQuery.setParameter(0, user.getUsername());
        insertQuery.executeUpdate();
        transaction.commit();
        session.close();
        
        Session session1 = sessionFactory.openSession();
        Transaction transaction1 = session1.beginTransaction();
        SQLQuery insertQuery1 = session1.createSQLQuery("" +"INSERT INTO user_roles (user_role_id,username, role) VALUES (?,?, ?)");
        insertQuery1.setParameter(0, 0);        
        insertQuery1.setParameter(1, user.getUsername());
        insertQuery1.setParameter(2, "ROLE_ADMIN");
        insertQuery1.executeUpdate();
        transaction1.commit();
        session1.close();
    }*/

	@SuppressWarnings("unchecked")
	public User findByNumber(String number) {

		List<User> numbers = new ArrayList<User>();

		numbers = getSessionFactory().getCurrentSession().createQuery("from User where number=?")
				.setParameter(0, number).list();

		if (numbers.size() > 0) {
			return numbers.get(0);
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