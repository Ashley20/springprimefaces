/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.journaldev.dao;

import com.journaldev.hibernate.data.Message;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



/**
 *
 * @author xdidemk
 */

@Component
public class MessageDAO {
    
   
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
    @Transactional
    public List<Message> getPaginatedMessages(int first, int pageSize) {
        
        List<Message> messages = null;
      
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Message");
           
              query.setFirstResult(first);
              query.setMaxResults(pageSize);
              System.out.println(first + "Bu first " + pageSize + " buda pagesize");
              messages = (List<Message>) query.list();
              session.getTransaction().commit();
              
      
   
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return messages;   
    }

    @Transactional
    public void register(Message message) {
        sessionFactory.getCurrentSession().save(message);
    }

   
    @Transactional
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete Message where messageId=:ID");
        query.setParameter("ID", id);
        
        int result = query.executeUpdate();
        
    }
    
    @Transactional
    public int getCount() {
        int count = ((Long) sessionFactory.getCurrentSession()
                .createQuery("select count(*) from Message").uniqueResult())
                .intValue();
        System.out.println(" count size " + count);
        return count;
    }
    
    
    
     

    
}
