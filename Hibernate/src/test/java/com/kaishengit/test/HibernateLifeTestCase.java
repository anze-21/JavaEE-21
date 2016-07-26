package com.kaishengit.test;

import com.kaishengit.pojo.User;
import com.kaishengit.util.HibernateUtil;
import junit.framework.Assert;
import org.hibernate.Session;
import org.junit.Test;

public class HibernateLifeTestCase {
    @Test
    public void testSave(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        User user =new User();
        user.setUsername("zhangsan");
        user.setPassword("cccccc");
        user.setAddress("焦作");
        session.persist(user);
        session.getTransaction().commit();

    }
    @Test
    public void testFindByGet(){
        Session session =HibernateUtil.getSession();
        session.beginTransaction();
        User user = (User) session.get(User.class,22);
        //System.out.println(user.getId());
        session.getTransaction().commit();
        Assert.assertNull(user);


    }
    @Test
    public void testFindByLoad(){
        Session session =HibernateUtil.getSession();
        session.beginTransaction();
        User user = (User) session.load(User.class,22);
        //System.out.println(user == null);
       // System.out.println(user.getUsername());
        Assert.assertNull(user);
        session.getTransaction().commit();

    }
    @Test
    public void testUpdate(){
        Session session =HibernateUtil.getSession();
        session.beginTransaction();
        User user = (User) session.get(User.class,19);
        session.getTransaction().commit();
        user.setUsername("toms");
        Session session2 =HibernateUtil.getSession();
        session2.beginTransaction();
        session2.update(user);
        session2.getTransaction().commit();
    }
    @Test
public void testSaveOrUpdate(){
        Session session =HibernateUtil.getSession();
        session.beginTransaction();
        User user =new User();
        user.setPassword("890076");
        user.setUsername("test");
        user.setAddress("USA");
        session.saveOrUpdate(user);
        session.getTransaction().commit();
        user.setPassword("222222");
        Session session1=HibernateUtil.getSession();
        session1.beginTransaction();
        session1.saveOrUpdate(user);
        session1.getTransaction().commit();

}
    @Test
    public void testMerge(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        User user = new User();
        session.getTransaction().commit();
        user.setPassword("000000");
        Session session1 =HibernateUtil.getSession();
        session1.beginTransaction();
        session1.merge(user);
        session1.getTransaction().commit();

    }
    @Test
    public void testClear(){
        Session session =HibernateUtil.getSession();
        session.beginTransaction();
        User user = (User) session.get(User.class,32);
        //session.clear();
        user.setPassword("123123");
        session.getTransaction().commit();



    }

}
