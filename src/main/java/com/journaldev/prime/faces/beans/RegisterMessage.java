package com.journaldev.prime.faces.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.journaldev.hibernate.data.Message;
import com.journaldev.spring.service.MessageService;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class RegisterMessage {
    @ManagedProperty("#{messageService}")
    private MessageService messageService;
    private Message message = new Message();
    
    private List<Message> messageList = new ArrayList<Message>();

    public List<Message> getMessageList() {
        messageList.addAll(messageService.getAllMessages());
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }
    
    

    public MessageService getMessageService() {
        return messageService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
    
    
    
    public String register() {
		// Calling Business Service
               
		messageService.register(message);
		// Add message
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("The Message  Is Registered Successfully"));
		return "";
    }
    
    


        
        

    
	
}
