package tel.db.dto;

public class UnivDTO {
private String univ_name;
private String univ_tel;
private String major;
private int year;

public UnivDTO(String univ_name,String univ_tel,String major,int year){
	this.univ_name=univ_name;
	this.univ_tel=univ_tel;
	this.major=major;
	this.year=year;
}
public String getUniv_name() {
	return univ_name;
}
public void setUniv_name(String univ_name) {
	this.univ_name = univ_name;
}
public String getUniv_tel() {
	return univ_tel;
}
public void setUniv_tel(String univ_tel) {
	this.univ_tel = univ_tel;
}
public String getMajor() {
	return major;
}
public void setMajor(String major) {
	this.major = major;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}


}
