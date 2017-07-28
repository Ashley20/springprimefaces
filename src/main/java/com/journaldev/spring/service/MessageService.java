package com.journaldev.spring.service;

import com.journaldev.dao.MessageDAO;
import com.journaldev.hibernate.data.Message;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class MessageService implements IMessageService {
	
    @Autowired
    private MessageDAO messageDAO;

    public MessageDAO getMessageDAO() {
        return messageDAO;
    }

    public void setMessageDAO(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }
        
    @Transactional
    @Override
    public void register(Message message){
        messageDAO.register(message);
    }
        
    @Transactional
    @Override
    public List<Message> getPaginatedMessages(){
        return messageDAO.getPaginatedMessages();
            
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        messageDAO.delete(id);
            
    }

}
