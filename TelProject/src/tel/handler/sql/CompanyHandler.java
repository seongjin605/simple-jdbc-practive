package tel.handler.sql;

import java.sql.*;

import tel.connection.memory.DBConnectionMgr;
import tel.db.dto.CompanyDTO;
import tel.db.dto.GeneralDTO;

public class CompanyHandler {
	private static Connection conn = null;
	private static PreparedStatement pstm = null;
	private static ResultSet rs = null;
	private static String sql = "";
	private CompanyDTO company = null;
	private DBConnectionMgr pool = null;

	public CompanyDTO SelectCompany(Connection conn,String com_name){
	 sql="select*from company where com_name=?";
	 
	 try{
		 pstm=conn.prepareStatement(sql);
		 pstm.setString(1, com_name);
		rs= pstm.executeQuery();
		 while(rs.next()){
			 company=getDataFromResultSet(rs);
		 }
		
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 
	 return company;
 }
	public boolean InsertCompanyl(CompanyDTO company){
		sql="insert into company values(?,?,?)";
		boolean check=false;
		try{
			conn.setAutoCommit(false);//conn.setAutoCOmmit(true); default����
			pstm=conn.prepareStatement(sql);
			
			pstm.setString(1, company.getCom_name());			
			pstm.setString(2, company.getCom_tel());
			pstm.setString(3, company.getCompany());
			
			int insert=pstm.executeUpdate();//���� ���� ��ȯ��1(����), ������ ��ȯ�� 0(����)
			conn.commit();
			if(insert>0) {
				
				check=true;
			}
		}catch(Exception e){
			System.out.println("InsertCompany() �޼��� ����="+e);
		}
		return check;
	}
public void DeleteCompany(Connection conn,String com_name){
	sql="delete from company where com_name=?";
	
	try{
		pstm=conn.prepareStatement(sql);
		pstm.setString(1, com_name);
		pstm.executeUpdate();
		System.out.println("������ ������ �Ϸ�Ǿ����ϴ�.");
	
	}catch(Exception e){
		System.out.println("DeleteCompany() �޼��� ����="+e);
	}
}

	public CompanyDTO getDataFromResultSet(ResultSet rs) throws SQLException {
		CompanyDTO company = new CompanyDTO(rs.getString("com_name"), rs.getString("com_tel"), rs.getString("company"));
		return company;
	}

}
