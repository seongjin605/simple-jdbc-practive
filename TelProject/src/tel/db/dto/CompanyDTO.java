package tel.db.dto;

public class CompanyDTO {
	private String com_name;
	private String com_tel;
	private String company;

	public CompanyDTO(String com_name, String com_tel, String company) {
		this.com_name = com_name;
		this.com_tel = com_tel;
		this.company = company;
	}

	public String getCom_name() {
		return com_name;
	}

	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}

	public String getCom_tel() {
		return com_tel;
	}

	public void setCom_tel(String com_tel) {
		this.com_tel = com_tel;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

}
