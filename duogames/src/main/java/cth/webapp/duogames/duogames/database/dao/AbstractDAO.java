package cth.webapp.duogames.duogames.database.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

public abstract class AbstractDAO<T> {

    @PersistenceContext
    protected EntityManager em;
    private Class cl;

    public AbstractDAO(Class c) {
        this.cl = c;
    }

    protected EntityManager getEntityManager() {
        return em;
    }

    public List<T> findRange(int range) {
        CriteriaQuery q = em.getCriteriaBuilder().createQuery();
        q.select(q.from(cl));
        Query qq = em.createQuery(q);
        qq.setFirstResult(0);
        qq.setMaxResults(range);
        return qq.getResultList();
    }

    public List<T> findHighRange(int range) {
        CriteriaQuery q = em.getCriteriaBuilder().createQuery();
        q.select(q.from(cl)).orderBy();
        Query qq = em.createQuery(q);
        qq.setFirstResult(0);
        qq.setMaxResults(range);
        return qq.getResultList();
    }

    /**
     * Finds and returns database entry by its primary key.
     *
     * @param id
     * @return
     */
    public Object findById(int id) {
        return em.find(cl, id);
    }

    /**
     * Adds the new entity to the database.
     *
     * @param entity
     */
    public void add(T entity) {
        em.persist(entity);
    }

}
