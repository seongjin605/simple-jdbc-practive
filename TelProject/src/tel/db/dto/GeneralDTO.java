package tel.db.dto;

public class GeneralDTO {
private String g_name;
private String g_tel;
private String address;

public GeneralDTO(String g_name, String g_tel, String address) {
	// TODO Auto-generated constructor stub
	this.g_name=g_name;
	this.g_tel=g_tel;
	this.address=address;
}
public String getG_name() {
	return g_name;
}
public void setG_name(String g_name) {
	this.g_name = g_name;
}
public String getG_tel() {
	return g_tel;
}
public void setG_tel(String g_tel) {
	this.g_tel = g_tel;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}


}
