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
			conn.setAutoCommit(false);//conn.setAutoCOmmit(true); default값임
			pstm=conn.prepareStatement(sql);
			
			pstm.setString(1, company.getCom_name());			
			pstm.setString(2, company.getCom_tel());
			pstm.setString(3, company.getCompany());
			
			int insert=pstm.executeUpdate();//값이 들어가면 반환값1(성공), 없으면 반환값 0(실패)
			conn.commit();
			if(insert>0) {
				
				check=true;
			}
		}catch(Exception e){
			System.out.println("InsertCompany() 메서드 오류="+e);
		}
		return check;
	}
public void DeleteCompany(Connection conn,String com_name){
	sql="delete from company where com_name=?";
	
	try{
		pstm=conn.prepareStatement(sql);
		pstm.setString(1, com_name);
		pstm.executeUpdate();
		System.out.println("데이터 삭제가 완료되었습니다.");
	
	}catch(Exception e){
		System.out.println("DeleteCompany() 메서드 오류="+e);
	}
}

	public CompanyDTO getDataFromResultSet(ResultSet rs) throws SQLException {
		CompanyDTO company = new CompanyDTO(rs.getString("com_name"), rs.getString("com_tel"), rs.getString("company"));
		return company;
	}

}
