package javaspringexamples.springJDBC.queriesInClause;

import java.util.Arrays;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

/**
 * 
 * @author mounir.sahrani@gmail.com
 *
 */
public class UserDaoImpl implements UserDao {

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private UserRowMapper userRowMapper = new UserRowMapper();

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
	}

	public List<User> find(Long... userIds) {
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource("userIds", Arrays.asList(userIds));
		return namedParameterJdbcTemplate.query("select * from user where id in (:userIds)", sqlParameterSource,
				userRowMapper);
	}
}
