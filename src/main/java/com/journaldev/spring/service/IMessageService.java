/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.journaldev.spring.service;

import com.journaldev.hibernate.data.Message;
import java.util.List;

/**
 *
 * @author xdidemk
 */
public interface IMessageService {
    public void register(Message message);
    public List<Message> getPaginatedMessages();
    public void delete(Integer id);
    
}
