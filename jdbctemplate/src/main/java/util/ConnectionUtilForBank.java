package main.java.util;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;


public class ConnectionUtilForBank {
	
	public static DataSource getDataSource()
	{
		org.apache.commons.dbcp.BasicDataSource ds=new org.apache.commons.dbcp.BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("tiger");
		ds.setUrl("jdbc:mysql://localhost:3306/book_dp");
		return ds;
	}
	
	public static JdbcTemplate getJdbcTemplate()
	{
		JdbcTemplate jdbctemplate=new JdbcTemplate();
		jdbctemplate.setDataSource(getDataSource());
		return jdbctemplate;
	}
	
	

}
