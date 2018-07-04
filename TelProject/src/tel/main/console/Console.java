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
		int a = 1, b = 2, c = 3, d = 4;// 1.������ �Է� 2.�˻� 3.���� 4.����
		int choice;

		Scanner sc = new Scanner(System.in);
		System.out.println("�����ϼ���...");
		System.out.println(a + ".������ �Է�");
		System.out.println(b + ".������ �˻�");
		System.out.println(c + ".������ ����");
		System.out.println(d + ".������ ����");
		System.out.println("����:");
		choice = sc.nextInt();

		if (choice == a) {// �Է�
			System.out.println("������ �Է��� �����մϴ�.");
			System.out.println("1.�Ϲ� 2.���� 3.ȸ��");
			System.out.println("����:");
			int insertChoice=sc.nextInt();
			
			if(insertChoice==1){
				System.out.println("�̸�:");
				sc.nextLine();
				String insertName = sc.nextLine();
				
				System.out.println("��ȭ��ȣ:");
				sc.nextLine();
				String insertTel = sc.nextLine();
				
				System.out.println("�ּ�:");
				sc.nextLine();
				String insertAddr = sc.nextLine();
				
				GeneralDTO g_dto = new GeneralDTO(insertName, insertTel, insertAddr);
				generalDAO.InsertGeneral(g_dto);
			
			}
			else if(insertChoice==2){
				System.out.println("�̸�:");
				sc.nextLine();
				String insertName = sc.nextLine();
				
				System.out.println("��ȭ��ȣ:");
				sc.nextLine();
				String insertTel = sc.nextLine();
				
				System.out.println("����:");
				sc.nextLine();
				String insertMajor = sc.nextLine();
				
				System.out.println("�г�:");
				sc.nextInt();
				int insertAddr = sc.nextInt();
				
				UnivDTO u_dto=new UnivDTO(insertName,insertTel,insertMajor,insertAddr);
				univDAO.InsertUniv(u_dto);
			}
			else if(insertChoice==3){
				System.out.println("�̸�:");
				sc.nextLine();
				String insertName = sc.nextLine();
				
				System.out.println("��ȭ��ȣ:");
				sc.nextLine();
				String insertTel = sc.nextLine();
				
				System.out.println("ȸ��:");
				sc.nextLine();
				String insertCom = sc.nextLine();
				
				CompanyDTO c_dto = new CompanyDTO(insertName, insertTel, insertCom);
				companyDAO.InsertCompanyl(c_dto);
			
			}


		

		}

		else if (choice == b) {// �˻�

			System.out.println("������ �˻��� �����մϴ�.");
			System.out.println("�̸�:");
			sc.nextLine();
			String searchName = sc.nextLine();

			GeneralDTO ge = generalDAO.SelectGeneral(DBconnect.getInstance(), searchName);
			CompanyDTO co = companyDAO.SelectCompany(DBconnect.getInstance(), searchName);
			UnivDTO un = univDAO.SelectUniv(DBconnect.getInstance(), searchName);

			if (ge != null) {
				System.out.println("check");
				System.out.println("�̸�:" + ge.getG_name());
				System.out.println("��ȭ��ȣ:" + ge.getG_tel());
				System.out.println("�ּ�:" + ge.getAddress());
				System.out.println("������ �˻��� �Ϸ�Ǿ����ϴ�.");
				System.out.println("�����ϼ���...");
			} else if (co != null) {
				System.out.println("check2");
				System.out.println("�̸�:" + co.getCom_name());
				System.out.println("��ȭ��ȣ:" + co.getCom_tel());
				System.out.println("ȸ��:" + co.getCompany());
				System.out.println("������ �˻��� �Ϸ�Ǿ����ϴ�.");
				System.out.println("�����ϼ���...");

			} else if (un != null) {
				System.out.println("check3");
				System.out.println("name:" + un.getUniv_name());
				System.out.println("phone:" + un.getUniv_tel());
				System.out.println("major:" + un.getMajor());
				System.out.println("year:" + un.getYear());
				System.out.println("������ �˻��� �Ϸ�Ǿ����ϴ�.");
				System.out.println("�����ϼ���...");
			}
			return;

		} else if (choice == c) {// ����
			System.out.println("������ ������ �����մϴ�.");
			System.out.println("�̸�:");
			sc.nextLine();
			String deleteName = sc.nextLine();

			generalDAO.DeleteGeneral(DBconnect.getInstance(), deleteName);
			univDAO.DeleteUniv(DBconnect.getInstance(), deleteName);
			companyDAO.DeleteCompany(DBconnect.getInstance(), deleteName);
		

			System.out.println("�����ϼ���");
		} else if (choice == d) {// ����
			System.out.println("���α׷��� �����մϴ�");
			System.exit(0);
		}
	}

}