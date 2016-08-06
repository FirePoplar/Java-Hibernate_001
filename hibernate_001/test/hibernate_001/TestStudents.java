package hibernate_001;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import config.Students;

public class TestStudents
{
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;

	@Before
	public void init()
	{
		// 获得session工厂
		sessionFactory = new Configuration().configure().buildSessionFactory();
		// 获得session
		session = sessionFactory.getCurrentSession();
		// 开启事务
		transaction = session.beginTransaction();

	}
	@After
	public void destory(){
		//提交事务
		transaction.commit();
	}
	
	@Test
	public void testStudents(){
		//生成学生对象
		Students s=new Students(1, "如来佛", "男", new Date(), "天上");
	    System.out.println(s.getSname()+"--"+s.getAddress());
	    session.save(s);
	}
}
