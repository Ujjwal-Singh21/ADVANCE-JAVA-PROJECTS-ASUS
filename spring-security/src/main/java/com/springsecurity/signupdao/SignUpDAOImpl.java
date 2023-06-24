package com.springsecurity.signupdao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.springsecurity.dto.SignupDTO;

@Repository
public class SignUpDAOImpl implements ISignUpDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void saveUser(SignupDTO signupDTO) {
		String userSql = "INSERT INTO USERS VALUES (?, ?, ?)";
		String authoritiesSql = "INSERT INTO AUTHORITIES VALUES (?, ?)";

		Object[] userSqlArgs = { signupDTO.getUsername(), signupDTO.getPassword(), 1 };
		Object[] authoritiesSqlArgs = { signupDTO.getUsername(), "USER" };

		// jdbcTemplate.update(userSql, userSqlArgs);
		// jdbcTemplate.update(authoritiesSql, authoritiesSqlArgs);

		// using another overloaded update method that takes PreparedStatementSetter as arg
		//---------------------------------------------------------------------------------
		/*jdbcTemplate.update(userSql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, signupDTO.getUsername());
				ps.setString(2, signupDTO.getPassword());
				ps.setInt(3, 1);
			}
		});*/
		
		// same using lambda
		jdbcTemplate.update(userSql, ps ->  {
				ps.setString(1, signupDTO.getUsername());
				ps.setString(2, signupDTO.getPassword());
				ps.setInt(3, 1);
			});

		/*jdbcTemplate.update(authoritiesSql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, signupDTO.getUsername());
				ps.setString(2, "USER");
			}
		});*/
		
		jdbcTemplate.update(authoritiesSql,  ps -> {
				ps.setString(1, signupDTO.getUsername());
				ps.setString(2, "USER");
		});

		System.out.println(signupDTO.getUsername() + " registraton done");
	}

}
