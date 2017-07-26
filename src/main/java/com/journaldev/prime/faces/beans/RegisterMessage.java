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
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;

@ManagedBean
@ViewScoped
public class RegisterMessage {
    @ManagedProperty("#{messageService}")
    private MessageService messageService;
    
    private LazyDataModel<Message> lazyModel;
   
    private Message selectedMessage;
    
    private Message message = new Message();
   
    
    @PostConstruct
    public void init() {
        lazyModel = new LazyMessageDataModel(messageService.getAllMessages());
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

    public LazyDataModel<Message> getLazyModel() {
        return lazyModel;
    }

    public Message getSelectedMessage() {
        return selectedMessage;
    }

    public void setSelectedMessage(Message selectedMessage) {
        this.selectedMessage = selectedMessage;
    }
    
    
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Message Selected", ((Message) event.getObject()).getSubject());
        FacesContext.getCurrentInstance().addMessage(null, msg);
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
