/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.journaldev.dao;

import com.journaldev.hibernate.data.Message;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



/**
 *
 * @author xdidemk
 */

@Component
public class MessageDAO {
    
   
    @PersistenceContext
    private EntityManager em;
    
   
    @Transactional
    public List<Message> getPaginatedMessages(int first, int pageSize) {
        
        List<Message> messages;
 
       
        Query query = em.createQuery("Select m From Message m", Message.class);
        query
                .setFirstResult(first)
                .setMaxResults(pageSize);
        messages = (List<Message>) query.getResultList();
       
       
        return messages;   
    }

    @Transactional
    public void register(Message message) {
        em.persist(message);
    }

   
    @Transactional
    public void delete(Integer id) {
       
     Message m =  em.find(Message.class, id);
     em.remove(em.merge(m));
      
    }
    
    @Transactional
    public int getCount() {
        
          Query query = em.createNativeQuery("select count(*) from messages");
          int count = ((BigInteger) query.getSingleResult()).intValue();
          return count;
    }
    
    
    
     

    
}
