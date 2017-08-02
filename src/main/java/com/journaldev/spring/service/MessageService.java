package com.journaldev.spring.service;

import com.journaldev.dao.MessageDAO;
import com.journaldev.hibernate.data.Message;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Component
public class MessageService{
	
    @Autowired
    private MessageDAO messageDAO;

    public MessageDAO getMessageDAO() {
        return messageDAO;
    }

    
    public void setMessageDAO(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }
        
    @Transactional
    public void register(Message message){
        messageDAO.register(message);
    }
        
    @Transactional
    public List<Message> getPaginatedMessages(int first, int pageSize){
        return messageDAO.getPaginatedMessages(first, pageSize);
  }

    @Transactional
    public void delete(Integer id) {
        messageDAO.delete(id);
            
    }

    @Transactional
    public int getCount() {
        return messageDAO.getCount();
    }

      

}
