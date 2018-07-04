package tel.handler.sql;

import java.sql.*;
import tel.connection.memory.DBConnectionMgr;
import tel.db.dto.GeneralDTO;
import tel.db.dto.UnivDTO;

public class UnivHandler {
	private static Connection conn = null;
	private static PreparedStatement pstm = null;
	private static ResultSet rs = null;
	private static String sql = "";
	private UnivDTO univ = null;
	private DBConnectionMgr pool = null;// �޸����� ��ü

	public UnivDTO SelectUniv(Connection conn, String univ_name) {
		sql = "select*from univ where univ_name=?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, univ_name);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				univ = getDataFromResultSet(rs);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return univ;
	}
	public boolean InsertUniv(UnivDTO Univ){
		sql="insert into univ values(?,?,?,?)";
		boolean check=false;
		try{
			conn.setAutoCommit(false);//conn.setAutoCOmmit(true); default����
			pstm=conn.prepareStatement(sql);
			
			pstm.setString(1, univ.getUniv_name());			
			pstm.setString(2, univ.getUniv_tel());
			pstm.setString(3, univ.getMajor());
			pstm.setInt(4, univ.getYear());
			
			int insert=pstm.executeUpdate();//���� ���� ��ȯ��1(����), ������ ��ȯ�� 0(����)
			conn.commit();
			if(insert>0) {
				
				check=true;
			}
		}catch(Exception e){
			System.out.println("InsertUniv() �޼��� ����="+e);
		}
		return check;
	}

public void DeleteUniv(Connection conn,String univ_name){
	sql="delete from univ where univ_name=?";
	
	try{
		pstm=conn.prepareStatement(sql);
		pstm.setString(1, univ_name);
		pstm.executeUpdate();
		System.out.println("������ ������ �Ϸ�Ǿ����ϴ�.");
	
	}catch(Exception e){
		System.out.println("DeleteUniv() �޼��� ����="+e);
	}
}

	public UnivDTO getDataFromResultSet(ResultSet rs) throws SQLException {
		UnivDTO univ = new UnivDTO(rs.getString("univ_name"), rs.getString("univ_tel"), 
				rs.getString("major"),rs.getInt("year"));
		return univ;

	}
}
