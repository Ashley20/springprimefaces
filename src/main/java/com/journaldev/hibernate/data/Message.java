package com.journaldev.hibernate.data;

public class Message {
    
    private long messageId;
    private String subject;
    private String content;
    
    public Message(){}

    public Message(long messageId, String subject, String content) {
        this.messageId = messageId;
        this.subject = subject;
        this.content = content;
    }
    
    

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long meassageId) {
        this.messageId = meassageId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    
	

}
