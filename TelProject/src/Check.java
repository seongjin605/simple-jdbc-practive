import tel.get.dbconnect.*;
import tel.handler.sql.CompanyHandler;
import tel.handler.sql.GeneralHandler;
import tel.handler.sql.UnivHandler;

public class Check {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBconnect DBC=new DBconnect();
		GeneralHandler general=new GeneralHandler();
		UnivHandler univ=new UnivHandler();
		CompanyHandler company=new CompanyHandler();
		//DBC.getInstance();
		general.SelectGeneral(DBC.getInstance(),"¹Ú¼ºÁø");
		//
		//company.SelectCompany(DBC.getInstance(), "À±Áö¼÷");
	}

}
