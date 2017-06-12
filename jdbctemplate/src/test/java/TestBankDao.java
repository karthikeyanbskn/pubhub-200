package test.java;


	import java.util.Iterator;
	import java.util.List;

	import dao.BankDao;
import main.java.model.BankAc;

	public class TestBankDao {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			BankAc bankac = new BankAc();
			//updating a customer
			bankac.setAcNo("232453");
			//bankac.setName("Rahul");
			bankac.setType("current");
			//adding a new customer
			BankAc bankacnewcustomer = new BankAc();
			bankacnewcustomer.setAcNo("459091");
			bankacnewcustomer.setName("Rahul");
			bankacnewcustomer.setType("savings");
			
			BankDao bankdao=new BankDao();
			bankdao.addAccount(bankacnewcustomer);
			bankdao.updateAccount(bankac);
			bankdao.removeAccount("232453");
			
			
			List<BankAc> arrbankac=bankdao.findAll();
			
			Iterator<BankAc> ii=arrbankac.iterator();
			
			while(ii.hasNext())
			{
				BankAc b=(BankAc)ii.next();
				System.out.println("AC No"+b.getAcNo());
				System.out.println("Name "+b.getName());
				System.out.println("Ac type "+b.getType());
			}
			
			

		}

	}

}
