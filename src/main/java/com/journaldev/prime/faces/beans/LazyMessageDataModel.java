
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.journaldev.prime.faces.beans;

import com.journaldev.hibernate.data.Message;
import com.journaldev.spring.service.MessageService;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;


/**
 *
 * @author xdidemk
 */
public class LazyMessageDataModel extends LazyDataModel<Message> {
    
    public List<Message> datasource;
    private int count;
    private MessageService messageService;

    public LazyMessageDataModel(MessageService messageService) {
       this.messageService = messageService;
       this.datasource = Collections.emptyList();
    }

    public List<Message> getDatasource() {
        return datasource;
    }

    public void setDatasource(List<Message> datasource) {
        this.datasource = datasource;
    }
    
    
    
   @Override
    public Message getRowData(String rowKey) {
        for(Message message : datasource) {
            if(message.getMessageId().toString().equals(rowKey))
                return message;
        }
 
        return null;
    }
 
    
    @Override
    public Object getRowKey(Message message) {
        return message.getMessageId().toString();
    }
    
    @Override
    public void setRowIndex(int rowIndex) {
        if (getPageSize() == 0) {
            super.setRowIndex(-1);
        } else {
            super.setRowIndex(rowIndex);
        }    
    }
         
       
    
    @Override
    public List<Message> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
         
        List<Message> data = new ArrayList<Message>();
      
   
        datasource =  messageService.getPaginatedMessages(first, pageSize);
        count = messageService.getCount();
        System.out.println(count);
        this.setRowCount(count);

        
        //filter
        for(Message message : datasource) {
            boolean match = true;
           
            if (filters != null) {
                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                    try {
                        String filterProperty = it.next();
                        Object filterValue = filters.get(filterProperty);
                       
 
                        Field field =  message.getClass().getDeclaredField(filterProperty);
                        field.setAccessible(true);
                        String fieldValue = String.valueOf(field.get(message));

                        
                        if(filterValue == null || fieldValue.startsWith(filterValue.toString())) {
                            match = true;
                    }
                    else {
                            match = false;
                            break;
                        }
                    } catch(Exception e) {
                        match = false;
                    }
                }
            } 
 
            if(match) {
                data.add(message);
            }
        } 
 
        // sort
        if(sortField != null) {
            Collections.sort(data, new LazySorter(sortField, sortOrder));
        } 
 
 
        // paginate
        if (data.size()  >  pageSize){
        
          return data.subList(first, first + pageSize);
        }else{
         
          return data;
        }
   } 
      
            
        

}
