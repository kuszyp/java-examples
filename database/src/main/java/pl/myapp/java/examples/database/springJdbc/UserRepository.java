package pl.myapp.java.examples.database.springJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
  private final JdbcTemplate jdbcTemplate;

  public UserRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public void addUSer(String name, String email) {
    final String sql = "INSERT INTO users (name, email) VALUES(?, ?)";
    jdbcTemplate.update(sql, name, email);
  }

  public List<User> getAllUsers() {
    final String sql = "SELECT * FROM users";
    return jdbcTemplate.query(sql, new UserRowMapper());
  }

  public User getUserById(int id) {
    final String sql = "SELECT * FROM users WHERE id = ?";
    return jdbcTemplate.queryForObject(sql, new UserRowMapper(), id);
  }

  private static class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
      return new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"));
    }
  }
}
