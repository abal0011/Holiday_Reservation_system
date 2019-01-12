/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repos;

import entities.Holiday;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author Aravind
 */
@Remote
public interface TransRepos {
   
     public Holiday searchTransactionById(int id) throws Exception;
     
     public List<Holiday> getAllTransaction() throws Exception;
     
     public Holiday searchTransactionByName(String name) throws Exception;
     
     public void addTransaction(Holiday sysTrans) throws Exception;
     
     public void removeTransaction(Holiday sysTrans) throws Exception;
     
     public void editTransaction(Holiday sysTrans) throws Exception;
}
