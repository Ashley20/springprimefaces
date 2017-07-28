/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.journaldev.dao;

import com.journaldev.hibernate.data.Message;
import java.util.List;

/**
 *
 * @author xdidemk
 */
public interface IMessageDAO {
    public List<Message> getPaginatedMessages();
    public void register(Message message);
    public void delete(Integer id);
    
}
