/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repos;

import entities.SystemUser;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Aravind
 */
@Remote
public interface userRepos {
    
    public void addUser(SystemUser user) throws Exception;
    
    public void deleteUser(SystemUser user) throws Exception;
    
    public void editUser(SystemUser user) throws Exception;
    
    public SystemUser findUser(String name) throws Exception;
    
    public List<SystemUser> getAllUsers() throws Exception;
    
    public SystemUser searchTransactionById(int id) throws Exception;
}
