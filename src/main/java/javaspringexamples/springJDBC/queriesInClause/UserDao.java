package javaspringexamples.springJDBC.queriesInClause;

import java.util.List;

/**
 * 
 * @author mounir.sahrani@gmail.com
 *
 */
public interface UserDao {
	public List<User> find(Long... userIds);
}