package dbService.dao;

import dbService.dataSets.UsersDataSet;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class UsersDAO {

    private Session session;

    public UsersDAO(Session session){
        this.session = session;
    }

    public UsersDataSet get(long userId) {

        try {
            return (UsersDataSet) session.get(UsersDataSet.class, userId);
        } catch (Exception e) {
            return null;
        }
    }

    public long getUserId(String name){
        try {
            Criteria criteria = session.createCriteria(UsersDataSet.class);
            UsersDataSet userDS = (UsersDataSet) criteria.add(Restrictions.eq("name", name)).uniqueResult();
            if(userDS!=null)    return userDS.getId();
            return -1;
        } catch (HibernateException e) {
            return -1;
        }
    }

    public long insertUser(String name){
        return (Long) session.save(new UsersDataSet(name));
    }

}
