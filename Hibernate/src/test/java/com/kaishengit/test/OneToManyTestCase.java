package com.kaishengit.test;

import com.kaishengit.pojo.Dept;
import com.kaishengit.pojo.Employee;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.junit.Test;

import java.nio.channels.SeekableByteChannel;
import java.util.List;
import java.util.Set;

public class OneToManyTestCase {
    /*
        最佳实践
        1. 保存时候，先存一再存多
        2. 让一的一端放弃关系维护
        3. fetch=join 可以避免N+1问题
     */
    @Test
    public void testSave(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Dept dept =new Dept();
        dept.setDeptname("C++开发部");

        Employee employee1 =new Employee();
        employee1.setEmpname("Lily");
        employee1.setDept(dept);

        Employee employee2 =new Employee();
        employee2.setEmpname("wanna");
        employee2.setDept(dept);

        session.save(dept);
        session.save(employee1);
        session.save(employee2);

        session.getTransaction().commit();

    }
    @Test
    public void testFindDept(){

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Dept dept = (Dept) session.get(Dept.class,15);
        System.out.println(dept.getDeptname());

        Set<Employee> employeeSet =dept.getEmployeesSet();
        for(Employee employee : employeeSet){
            System.out.println(employee.getEmpname());
        }
        session.getTransaction().commit();

    }
    @Test
    public void  testFindEmployee(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Employee employee = (Employee) session.get(Employee.class,29);
        System.out.println(employee.getEmpname());

        Dept dept =employee.getDept();
        System.out.println(dept.getDeptname());
        session.getTransaction().commit();

    }
    @Test
    public void  testFindEmployeeAll(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria =session.createCriteria(Employee.class);
        List<Employee> employeeList =criteria.list();
        for(Employee employee:employeeList){
            System.out.println(employee.getId() + ":" + employee.getEmpname() + ":" +employee.getDept().getDeptname());

        }
        session.getTransaction().commit();

    }
    @Test
    public void testDelete(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Dept dept = (Dept) session.get(Dept.class,15);
        session.delete(dept);
        session.getTransaction().commit();

    }
}
