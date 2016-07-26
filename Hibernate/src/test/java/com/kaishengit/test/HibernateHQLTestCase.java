package com.kaishengit.test;

import com.kaishengit.pojo.User;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

public class HibernateHQLTestCase {
    @Test
    public void testFindAll(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        String hql = "from User";
        Query query = session.createQuery(hql);
        List<User> userList = query.list();
        for(User user:userList){
            System.out.println(user.getId()+"->"+user.getUsername());
        }
        session.getTransaction().commit();

    }
    @Test
    public void testFindByWhere(){
        Session session =HibernateUtil.getSession();
        session.beginTransaction();
        String hql="from User as u where u.password =:password and u.username =:name";
        Query query =session.createQuery(hql);
        //query.setString(0,"123123");
        //query.setInteger(0,32);
        //query.setParameter(0,"123123");
        //query.setParameter("password","111111");
        query.setString("password","123123");
        query.setString("name","tom");
        List<User> userList=query.list();
        for(User user:userList){
            System.out.println(user.getId()+"->"+user.getUsername());
        }
        session.getTransaction().commit();

    }
    @Test
    public void testFindUnique(){
        Session session =HibernateUtil.getSession();
        session.beginTransaction();
        String hql="from User where password =:pwd ";
        Query query =session.createQuery(hql);
        query.setParameter("pwd","111111");
        //query.setParameter("name","tom");
       User user = (User) query.uniqueResult();
        System.out.println(user);
        session.getTransaction().commit();


    }
    @Test
    public void testFindByCloumn(){
        Session session =HibernateUtil.getSession();
        session.beginTransaction();
        String hql ="select id,username,password from User";
        Query query =session.createQuery(hql);
        List<Object[]> result =query.list();
        for(Object[] objects:result){
            System.out.println(objects[0]+"->"+objects[1]+"->"+objects[2]);
        }

        session.getTransaction().commit();
    }
    @Test
    public void testCount(){
        Session session =HibernateUtil.getSession();
        session.beginTransaction();
        String hql ="select count(*),max(id) from User";
        Query query =session.createQuery(hql);
       Object [] result = (Object[]) query.uniqueResult();
        System.out.println("count:"+result[0]);
        System.out.println("max(id)"+result[1]);

        session.getTransaction().commit();

    }
    @Test
    public void testPage(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        String hql ="from User order by id desc";
        Query query =session.createQuery(hql);
        query.setFirstResult(3);
        query.setMaxResults(3);
        List<User> userList =query.list();
        for(User users:userList){
            System.out.println(users);
        }
        session.getTransaction().commit();
    }

}
