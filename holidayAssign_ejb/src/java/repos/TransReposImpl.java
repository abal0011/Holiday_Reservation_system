/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repos;

import entities.Holiday;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Aravind
 */
@Stateless
public class TransReposImpl implements TransRepos{
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Holiday searchTransactionById(int id) throws Exception {
           Holiday sysTrans = entityManager.find(Holiday.class, id);
        return sysTrans;
    }

    @Override
    public List<Holiday> getAllTransaction() throws Exception {
            return entityManager.createNamedQuery(Holiday.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public Holiday searchTransactionByName(String name) throws Exception {
        
        return entityManager.find(Holiday.class, name);
    }    

    @Override
    public void addTransaction(Holiday sysTrans) throws Exception {
        entityManager.persist(sysTrans);
    }

    @Override
    public void removeTransaction(Holiday sysTrans) throws Exception {
        if (sysTrans != null) {
             Holiday sysTrans2 = entityManager.merge(sysTrans);
            entityManager.remove(sysTrans2);
            System.out.println("deleted");
        }
    }

    @Override
    public void editTransaction(Holiday sysTrans) throws Exception {
      entityManager.merge(sysTrans);
    }
    public List<Holiday> searchhactivity(String name) throws Exception {
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Holiday> c = qb.createQuery(Holiday.class);
        Root<Holiday> p = c.from(Holiday.class);
        Predicate condition = qb.like(p.<String>get("activityName"), name.toUpperCase());
        c.where(condition);
        TypedQuery<Holiday> q = entityManager.createQuery(c);
        List<Holiday> result = q.getResultList();
        System.out.println(result);
        return result;
    }
}
