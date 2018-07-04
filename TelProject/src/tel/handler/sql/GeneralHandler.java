package tel.handler.sql;
import java.sql.*;
import tel.connection.memory.DBConnectionMgr;
import tel.db.dto.GeneralDTO;


public class GeneralHandler {
	
private static Connection conn=null;
private static PreparedStatement pstm=null;
private static ResultSet rs=null;
private static String sql="";
private GeneralDTO general=null; //general Ŭ������ DTO
private DBConnectionMgr pool=null;//�޸����� ��ü


	public GeneralDTO SelectGeneral(Connection conn,String g_name){
		sql="select*from general where g_name=?";
		
		try{
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, g_name);
			rs=pstm.executeQuery();

			while(rs.next()){
				general=getDataFromResultSet(rs);
			}
			
			
		}catch(Exception e){
			System.out.println("SelectGeneral() �޼��� ����="+e);
		}
		return general;
	}
	

	public boolean InsertGeneral(GeneralDTO general){
		sql="insert into general values(?,?,?)";
		boolean check=false;
		try{
			conn.setAutoCommit(false);//conn.setAutoCOmmit(true); default����
			pstm=conn.prepareStatement(sql);
			
			pstm.setString(1, general.getG_name());			
			pstm.setString(2, general.getG_tel());
			pstm.setString(3, general.getAddress());
			
			int insert=pstm.executeUpdate();//���� ���� ��ȯ��1(����), ������ ��ȯ�� 0(����)
			conn.commit();
			if(insert>0) {
				
				check=true;
			}
		}catch(Exception e){
			System.out.println("InsertGeneral() �޼��� ����="+e);
		}
		return check;
	}
	
	public void DeleteGeneral(Connection conn,String g_name){
		sql="delete from general where g_name=?";
		
		try{
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, g_name);
			pstm.executeUpdate();
			System.out.println("������ ������ �Ϸ�Ǿ����ϴ�.");
		
		}catch(Exception e){
			System.out.println("DeleteGeneral() �޼��� ����="+e);
		}
	}

	public GeneralDTO getDataFromResultSet(ResultSet rs) throws SQLException  {
		// TODO Auto-generated method stub
		GeneralDTO general = new GeneralDTO(rs.getString("g_name"),rs.getString("g_tel"),rs.getString("address"));
		
		return general;
	}

}
