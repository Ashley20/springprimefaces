package com.journaldev.spring.service;

import com.journaldev.hibernate.data.Message;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class MessageService {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public void register(Message message){
		// Acquire session
		Session session = sessionFactory.getCurrentSession();
		// Save message, saving behavior get done in a transactional manner
		session.save(message);		
	}
        
        @Transactional
        public List<Message> getAllMessages(){
            return (List<Message>)sessionFactory.getCurrentSession().createQuery("from Message").list();
        }

}
