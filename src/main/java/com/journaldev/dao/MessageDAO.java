/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.journaldev.dao;

import com.journaldev.hibernate.data.Message;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



/**
 *
 * @author xdidemk
 */

@Component
public class MessageDAO  {
    
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    

    public List<Message> getPaginatedMessages() {
       return (List<Message>)sessionFactory.getCurrentSession().createQuery("from Message").list();
    }


    public void register(Message message) {
        sessionFactory.getCurrentSession().save(message);
    }


    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete Message where messageId = : ID");
        query.setParameter("ID", id);
        
        int result = query.executeUpdate();
        
    }
    
}
