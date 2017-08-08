/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.journaldev.prime.faces.beans;

import com.journaldev.hibernate.data.Message;
import java.lang.reflect.Field;
import java.util.Comparator;
import org.primefaces.model.SortOrder;

/**
 *
 * @author xdidemk
 */
public class LazySorter implements Comparator<Message> {
    
    private String sortField;
     
    private SortOrder sortOrder;

    public LazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

    @Override
    public int compare(Message message1, Message message2) {
        try {
            Field field1 = message1.getClass().getDeclaredField(this.sortField);
            Field field2 = message2.getClass().getDeclaredField(this.sortField);
            field1.setAccessible(true);
            field2.setAccessible(true);
            
            Object value1 = field1.get(message1);
            Object value2 = field2.get(message2);
           
            int value = ((Comparable)value1).compareTo(value2);
             
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
       
    }

    
    
}
