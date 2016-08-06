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
		// ���session����
		sessionFactory = new Configuration().configure().buildSessionFactory();
		// ���session
		session = sessionFactory.getCurrentSession();
		// ��������
		transaction = session.beginTransaction();

	}
	@After
	public void destory(){
		//�ύ����
		transaction.commit();
	}
	
	@Test
	public void testStudents(){
		//����ѧ������
		Students s=new Students(1, "������", "��", new Date(), "����");
	    System.out.println(s.getSname()+"--"+s.getAddress());
	    session.save(s);
	}
}
