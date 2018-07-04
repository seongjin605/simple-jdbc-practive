package tel.main.console;

import java.sql.Connection;
import java.util.Scanner;

import tel.db.dto.CompanyDTO;
import tel.db.dto.GeneralDTO;
import tel.db.dto.UnivDTO;
import tel.get.dbconnect.DBconnect;
import tel.handler.sql.CompanyHandler;
import tel.handler.sql.GeneralHandler;
import tel.handler.sql.UnivHandler;

public class Console {

	private static GeneralHandler generalDAO = new GeneralHandler();
	private static UnivHandler univDAO = new UnivHandler();
	private static CompanyHandler companyDAO = new CompanyHandler();
	private static DBconnect DBC = new DBconnect();
	private static UnivDTO u_name = null;
	private static CompanyDTO c_name = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1, b = 2, c = 3, d = 4;// 1.데이터 입력 2.검색 3.삭제 4.종료
		int choice;

		Scanner sc = new Scanner(System.in);
		System.out.println("선택하세요...");
		System.out.println(a + ".데이터 입력");
		System.out.println(b + ".데이터 검색");
		System.out.println(c + ".데이터 삭제");
		System.out.println(d + ".데이터 종료");
		System.out.println("선택:");
		choice = sc.nextInt();

		if (choice == a) {// 입력
			System.out.println("데이터 입력을 시작합니다.");
			System.out.println("1.일반 2.대학 3.회사");
			System.out.println("선택:");
			int insertChoice=sc.nextInt();
			
			if(insertChoice==1){
				System.out.println("이름:");
				sc.nextLine();
				String insertName = sc.nextLine();
				
				System.out.println("전화번호:");
				sc.nextLine();
				String insertTel = sc.nextLine();
				
				System.out.println("주소:");
				sc.nextLine();
				String insertAddr = sc.nextLine();
				
				GeneralDTO g_dto = new GeneralDTO(insertName, insertTel, insertAddr);
				generalDAO.InsertGeneral(g_dto);
			
			}
			else if(insertChoice==2){
				System.out.println("이름:");
				sc.nextLine();
				String insertName = sc.nextLine();
				
				System.out.println("전화번호:");
				sc.nextLine();
				String insertTel = sc.nextLine();
				
				System.out.println("전공:");
				sc.nextLine();
				String insertMajor = sc.nextLine();
				
				System.out.println("학년:");
				sc.nextInt();
				int insertAddr = sc.nextInt();
				
				UnivDTO u_dto=new UnivDTO(insertName,insertTel,insertMajor,insertAddr);
				univDAO.InsertUniv(u_dto);
			}
			else if(insertChoice==3){
				System.out.println("이름:");
				sc.nextLine();
				String insertName = sc.nextLine();
				
				System.out.println("전화번호:");
				sc.nextLine();
				String insertTel = sc.nextLine();
				
				System.out.println("회사:");
				sc.nextLine();
				String insertCom = sc.nextLine();
				
				CompanyDTO c_dto = new CompanyDTO(insertName, insertTel, insertCom);
				companyDAO.InsertCompanyl(c_dto);
			
			}


		

		}

		else if (choice == b) {// 검색

			System.out.println("데이터 검색을 시작합니다.");
			System.out.println("이름:");
			sc.nextLine();
			String searchName = sc.nextLine();

			GeneralDTO ge = generalDAO.SelectGeneral(DBconnect.getInstance(), searchName);
			CompanyDTO co = companyDAO.SelectCompany(DBconnect.getInstance(), searchName);
			UnivDTO un = univDAO.SelectUniv(DBconnect.getInstance(), searchName);

			if (ge != null) {
				System.out.println("check");
				System.out.println("이름:" + ge.getG_name());
				System.out.println("전화번호:" + ge.getG_tel());
				System.out.println("주소:" + ge.getAddress());
				System.out.println("데이터 검색이 완료되었습니다.");
				System.out.println("선택하세요...");
			} else if (co != null) {
				System.out.println("check2");
				System.out.println("이름:" + co.getCom_name());
				System.out.println("전화번호:" + co.getCom_tel());
				System.out.println("회사:" + co.getCompany());
				System.out.println("데이터 검색이 완료되었습니다.");
				System.out.println("선택하세요...");

			} else if (un != null) {
				System.out.println("check3");
				System.out.println("name:" + un.getUniv_name());
				System.out.println("phone:" + un.getUniv_tel());
				System.out.println("major:" + un.getMajor());
				System.out.println("year:" + un.getYear());
				System.out.println("데이터 검색이 완료되었습니다.");
				System.out.println("선택하세요...");
			}
			return;

		} else if (choice == c) {// 삭제
			System.out.println("데이터 삭제를 시작합니다.");
			System.out.println("이름:");
			sc.nextLine();
			String deleteName = sc.nextLine();

			generalDAO.DeleteGeneral(DBconnect.getInstance(), deleteName);
			univDAO.DeleteUniv(DBconnect.getInstance(), deleteName);
			companyDAO.DeleteCompany(DBconnect.getInstance(), deleteName);
		

			System.out.println("선택하세요");
		} else if (choice == d) {// 종료
			System.out.println("프로그램을 종료합니다");
			System.exit(0);
		}
	}

}