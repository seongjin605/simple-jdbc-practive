package tel.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import tel.db.dto.CompanyDTO;

public interface CompanyDAO {

	public CompanyDTO selectCompany(String com_name);
	public boolean insertCompany(CompanyDTO company);
	public void deleteCompany(String com_name);
	public void updateCompany(CompanyDTO companyDTO);
	public CompanyDTO getDataFromResultSet(ResultSet rs) throws SQLException;
}
