package tel.handler.sql;

import java.sql.*;
import tel.db.dto.CompanyDTO;
import tel.get.dbconnect.DbConnection;

public class CompanyHandler {

	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	private String sql = "";
	private CompanyDTO company = null;

	public CompanyDTO selectCompany(String com_name){
		sql = "select*from company where com_name=?";
		try {
			pstm = DbConnection.getInstance().prepareStatement(sql);
			pstm.setString(1, com_name);
			rs = pstm.executeQuery();
			while (rs.next()) {
				company = getDataFromResultSet(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		}

		return company;
	}

	public boolean insertCompanyl(CompanyDTO company) {
		sql = "insert into company values(?,?,?)";
		boolean check = false;
		try {
			DbConnection.getInstance().setAutoCommit(false);
			pstm =  DbConnection.getInstance().prepareStatement(sql);

			pstm.setString(1, company.getCom_name());
			pstm.setString(2, company.getCom_tel());
			pstm.setString(3, company.getCompany());

			int insert = pstm.executeUpdate();
			DbConnection.getInstance().commit();
			if (insert > 0) {
				System.out.println("insertCompany() 성공");
				check = true;
			}
		} catch (Exception e) {
			System.out.println("insertCompany() 실패=" + e);
		}
		return check;
	}

	public void deleteCompany(String com_name) {
		sql = "delete from company where com_name=?";
		try {
			pstm =  DbConnection.getInstance().prepareStatement(sql);
			pstm.setString(1, com_name);
			pstm.executeUpdate();
			System.out.println("deleteCompany() 성공");

		} catch (Exception e) {
			System.out.println("DeleteCompany() 실패=" + e);
		}
	}
	
	public void updateCompany(CompanyDTO companyDTO) {
		sql = "update company set com_tel=?, company=? where com_name=?";
		try {
			pstm =  DbConnection.getInstance().prepareStatement(sql);
			pstm.setString(1, companyDTO.getCom_tel());
			pstm.setString(2, companyDTO.getCompany());
			pstm.setString(3, companyDTO.getCom_name());
			pstm.executeUpdate();
			System.out.println("updateCompany() 성공");

		} catch (Exception e) {
			System.out.println("updateCompany() 실패=" + e);
		}
	}

	public CompanyDTO getDataFromResultSet(ResultSet rs) throws SQLException {
		CompanyDTO company = new CompanyDTO(rs.getString("com_name"), rs.getString("com_tel"), rs.getString("company"));
		return company;
	}

}
