import tel.db.dao.CompanyDAOImpl;
import tel.get.dbconnect.*;
public class Check {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DbConnection DBC=new DbConnection();
		CompanyDAOImpl company=new CompanyDAOImpl();
		DBC.getInstance();

	}

}
