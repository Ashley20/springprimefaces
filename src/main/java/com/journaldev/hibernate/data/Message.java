package com.journaldev.hibernate.data;

import com.journaldev.listeners.MessageListener;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PostRemove;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.Table;



@Table(name = "messages")
@Entity
public class Message implements Serializable  {
    
    private Integer messageId;
    
    private String subject;
    
    private String content;
    
    private String read;
    
    public Message(){}

    public Message(Integer messageId, String subject, String content) {
        this.messageId = messageId;
        this.subject = subject;
        this.content = content;
        this.read = "NO";
    }
    
    
    @Id
    @GeneratedValue
    @Column(name = "MESSAGE_ID")
    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer meassageId) {
        this.messageId = meassageId;
    }

    @Column(name = "SUBJECT")
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Column(name = "CONTENT")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "MESSAGE_READ")
    public String getRead() {
        return read;
    }

    public void setRead(String read) {
        this.read = read;
    }
    
    
    
    
}
