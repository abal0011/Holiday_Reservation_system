/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repos;

import entities.SystemUser;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Aravind
 */
@Stateless
public class UserReposImpl implements userRepos{
  
    @PersistenceContext
    private EntityManager entityManager;
    
     @Override
     public SystemUser searchTransactionById(int id) throws Exception {
           SystemUser sysUSer = entityManager.find(SystemUser.class, id);
        return sysUSer;
    }

    @Override
    public void addUser(SystemUser user) throws Exception {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(SystemUser user) throws Exception {
        if(user != null)
        {
            SystemUser sysUSer2 = entityManager.merge(user);
            entityManager.remove(sysUSer2);
        }}

    @Override
    public void editUser(SystemUser user) throws Exception {
        entityManager.merge(user);
    }

    @Override
    public SystemUser findUser(String name) throws Exception {
        return entityManager.find(SystemUser.class, name);
    }

    @Override
    public List<SystemUser> getAllUsers() throws Exception {
        return entityManager.createNamedQuery(SystemUser.GET_ALL_QUERY_NAME).getResultList();
    }
}
