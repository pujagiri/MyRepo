import javax.imageio.spi.ServiceRegistry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;




public class Main 
{
  public static void main(String args[])
  {
	 Configuration conf=new Configuration().configure("hibernate.cfg.xml"); 
	 ServiceRegistry registry=new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
	 SessionFactory factory=conf.buildSessionFactory(registry);
	 Session session=factory.openSession();
	 Employee e=new Employee();
	 e.setEmployeeId(1212);
	 e.setEmployeeName("ABAB");
	 e.setEmployeeSalary(3000);
	 e.setDeptNumber(20);
	 Transaction tx=session.beginTransaction();
	 session.save(e);
	 tx.commit();
	 session.close();
	 factory.close();
  }
}
