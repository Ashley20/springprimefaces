package com.journaldev.prime.faces.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import com.journaldev.hibernate.data.Message;
import com.journaldev.spring.service.MessageService;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;


import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;



@ManagedBean
@ViewScoped
public class RegisterMessage implements Serializable{
      @ManagedProperty(value="#{messageService}") 
      MessageService messageService;  
    
    
    private LazyDataModel<Message> lazyModel;
    private Message selectedMessage;
    private int countFirst;
    private int countNext;
   
  
    @PostConstruct
    public void init() {
        
        lazyModel = new LazyMessageDataModel(messageService);
        countFirst = messageService.getCount();
        
    }
   
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }
    
    public MessageService getMessageService(){
        return messageService;
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
       
        messageService.changeReadProperty(selectedMessage);
       
    
    }
    
   
    
    public void register() {
		// Calling Business Service
                Message message = new Message();
		messageService.register(message);
		// Add message
		createFacesMessage("The Message  Is Registered Successfully");
                
    }
    
    public void delete(Message message){
        
        messageService.delete(message.getMessageId()); 
        createFacesMessage("You have successfully deleted the message!");
        System.out.println("maskdmasdas");
    }
    
    public void checkNewMessages(){
     
    
      countNext = messageService.getCount();
       
      if(countNext > countFirst){
          
          countFirst = countNext;
          
          // Create faces message 
          createFacesMessage("Hey you have some new messages!");
                
      }else if(countNext < countFirst){
          countFirst = countNext;
         
      }
      
    }
    
    public String createFacesMessage(String message){
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
        return "";
    }
  
	
}
