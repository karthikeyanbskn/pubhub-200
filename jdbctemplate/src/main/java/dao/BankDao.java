package main.java.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;



import model.BankAc;
import util.ConnectionUtilForBank;



public class BankDao {
	
	JdbcTemplate jdbctemplate=ConnectionUtilForBank.getJdbcTemplate();

	public void addAccount(BankAc bankac)
	{
		String query="insert into bankdetails(acno,pname,actype)values(?,?,?)";
		System.out.println(bankac.getAcNo()+" "+bankac.getName()+" "+bankac.getType());
		Object[] params={bankac.getAcNo(),bankac.getName(),bankac.getType()};
		int rows=jdbctemplate.update(query, params);
		
		System.out.println("number of row inserted  "+rows);
	}
	public void removeAccount(String acno)
	{
		
		String query="Delete from bankdetails where acno=?";
		//Object[] params={bankac.getAcNo()};
		int rows=jdbctemplate.update(query, acno);
		System.out.println("Numbers of rows deleted "+rows);
		
	}
	
	public void updateAccount(BankAc bankac)
	{
		//updating the actype for a particular account using acno
		String query="update bankdetails set actype=? where acno=?";
		Object[] params={bankac.getType(),bankac.getAcNo()};
		int rows=jdbctemplate.update(query, params);
		System.out.println("No of rows updated "+rows);
		
	}
	
	public BankAc findByCode(String acno) {

		String query = "SELECT acno,pname,actype FROM Bankdetails WHERE acno=?";
		BankAc bankac = jdbctemplate.queryForObject(query, new Object[] { acno }, (rs, row) -> {
			BankAc b = convert(rs);
			return b;
		});
		return bankac;

}
	
	private BankAc convert(ResultSet rs) throws SQLException {

		BankAc bankac = new BankAc();
		bankac.setAcNo(rs.getString("acno"));
		bankac.setName(rs.getString("pname"));
		bankac.setType(rs.getString("actype"));
		return bankac;

}
	
	public List<BankAc> findAll() {

		String query = "SELECT acno,pname,actype FROM bankdetails";
		List<BankAc> bankac = jdbctemplate.query(query, (rs, rows) -> {
			BankAc b = convert(rs);
			return b;
		});
		return bankac;
}
}
