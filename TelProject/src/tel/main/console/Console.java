package tel.main.console;

import java.util.Scanner;
import tel.db.dto.CompanyDTO;
import tel.handler.sql.CompanyHandler;

public class Console {

	private static CompanyHandler companyDAO = new CompanyHandler();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1, b = 2, c = 3, d = 4, e = 5;//
		int choice;

		Scanner sc = new Scanner(System.in);
		System.out.println("선택하세요...");
		System.out.println(a + ".데이터 삽입");
		System.out.println(b + ".데이터 검색");
		System.out.println(c + ".데이터  삭제");
		System.out.println(d + ".데이터 수정");
		System.out.println(e + ".프로그램 종료");
		choice = sc.nextInt();

		if (choice == a) {
			System.out.println("데이터 삽입을 시작합니다.");

			System.out.println("이름:");
			String insertName = sc.next();
			sc.nextLine();

			System.out.println("전화번호:");
			String insertTel = sc.next();
			sc.nextLine();

			System.out.println("주소:");
			String insertCom = sc.next();
			sc.nextLine();

			CompanyDTO c_dto = new CompanyDTO(insertName, insertTel, insertCom);
			companyDAO.insertCompanyl(c_dto);

		}

		else if (choice == b) {
			System.out.println("데이터 검색을 시작합니다.");
			System.out.println("입력:");
			String searchName = sc.next();
			sc.nextLine();

			CompanyDTO co = companyDAO.selectCompany(searchName);
			if (co != null) {
				System.out.println("이름:" + co.getCom_name());
				System.out.println("전화번호:" + co.getCom_tel());
				System.out.println("회사명:" + co.getCompany());
				System.out.println("데이터를 검색 완료 하였습니다.");
				System.out.println("입력하세요...");
			}
			return;

		} else if (choice == c) {
			System.out.println("데이터 삭제를 시작합니다.");
			System.out.println("입력:");
			sc.nextLine();
			String deleteName = sc.nextLine();

			companyDAO.deleteCompany(deleteName);

			System.out.println("해당 데이터가 삭제되었습니다.");
		} else if (choice == d) {
			System.out.println("데이터 수정을 시작합니다.");
			System.out.println("수정할 사용자 입력:");
			String searchName = sc.next();
			sc.nextLine();
			CompanyDTO co = companyDAO.selectCompany(searchName);
			if (co != null) {
				System.out.println("이름:" + co.getCom_name());
				System.out.println("전화번호:" + co.getCom_tel());
				System.out.println("회사명:" + co.getCompany());
				System.out.println("수정할 사용자를 찾았습니다.");
				
				System.out.println(co.getCom_name()+"의 수정할 번호 입력:");
				String updateTel=sc.next();
				sc.nextLine();
				
				System.out.println(co.getCom_name()+"의 수정할 회사명 입력:");
				String updateCompany=sc.next();
				sc.nextLine();
				
				co.setCom_tel(updateTel);
				co.setCompany(updateCompany);
				
				companyDAO.updateCompany(co);
				
				System.out.println("사용자 정보를 수정했습니다.");
				System.out.println(co.getCom_name()+"님 아래는 변경된 정보입니다.");
				System.out.println("변경된"+ co.getCom_name()+"님의 전화번호:"+co.getCom_tel());
				System.out.println("변경된 "+co.getCom_name()+"님의 회사명:"+co.getCompany());
			}else {
				System.out.println("사용자를 찾지못했습니다.");
			}
		
		}else if (choice == e) {
			System.out.println("프로그램이 종료되었습니다.");
			System.exit(0);
		}
	}
}