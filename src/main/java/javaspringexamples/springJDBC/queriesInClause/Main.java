package javaspringexamples.springJDBC.queriesInClause;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) throws SQLException {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Conf.class);

		UserDao userDao = applicationContext.getBean(UserDao.class);

		List<User> users = userDao.find(new Long[] { 65L, 999L });
		for (User user : users)
			System.out.println(user.toString());
	}
}
