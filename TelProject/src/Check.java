import tel.get.dbconnect.*;
import tel.handler.sql.CompanyHandler;
public class Check {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DbConnection DBC=new DbConnection();
		CompanyHandler company=new CompanyHandler();
		DBC.getInstance();

	}

}
