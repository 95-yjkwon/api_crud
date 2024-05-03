package com.keduit.kyj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Projectlist {
	private SignUpManager signUpManager;

	Connection conn;

	Project p = new Project();

	Scanner sc = new Scanner(System.in);

	public Projectlist(String driver, String url, String userid, String pwd) throws Exception {
		signUpManager = new SignUpManager();
		Class.forName(driver);
		System.out.println("드라이버 연결 성공");
		System.out.println("드라이버 연결 준비....");
		conn = DriverManager.getConnection(url, userid, pwd);
		System.out.println("드라이버 연결 성공");
	}

	public void insertApi(Project project) throws Exception {
		String sql = "insert into pro(ID, tourspotNm, tourspotDtlAddr, refadNo, mngTime,tourUtlzAmt,pkgFclt,cnvenFcltGuid,tourspotSumm) "
				+ "values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt;
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, project.getID());
		pstmt.setString(2, project.getTourspotNm());
		pstmt.setString(3, project.getTourspotDtlAddr());
		pstmt.setString(4, project.getRefadNo());
		pstmt.setString(5, project.getTourUtlzAmt());
		pstmt.setString(6, project.getMngTime());
		pstmt.setString(7, project.getPkgFclt());
		pstmt.setString(8, project.getCnvenFcltGuid());
		pstmt.setString(9, project.getTourspotSumm());

		int result = pstmt.executeUpdate();
		if (result == 1) {
			System.out.println(project.getTourspotNm() + "추가 성공");
		} else {
			System.out.println(project.getTourspotNm() + "추가 실패");
		}
		pstmt.close();
	}

	public void deleteData() {

		try {

			System.out.println("삭제할 레코드 번호를 입력하세요");
			int id = sc.nextInt();

			String sql = "delete from pro where ID=?";
			PreparedStatement pstmt;
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, id);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println(id + "번 삭제 성공");
			} else {
				System.out.println(id + "번 삭제 실패");
			}
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("접근 권한이 없습니다.");
		}

	}

	public void updateData() {

		try {
			System.out.println("수정 할 레코드 번호를 입력하세요");
			int id = sc.nextInt();

			System.out.println("관광지 명을 입력하세요");
			p.setTourspotNm(sc.next());

			System.out.println("주소를 입력하세요");
			p.setTourspotDtlAddr(sc.next());

			System.out.println("전화번호를 입력하세요");
			p.setRefadNo(sc.next());

			System.out.println("운영 시간을 입력하세요");
			p.setMngTime(sc.next());

			System.out.println("이용 요금을 입력하세요");
			p.setTourUtlzAmt(sc.next());

			System.out.println("주차 시설을 입력하세요");
			p.setPkgFclt(sc.next());

			System.out.println("관광 정보를 입력하세요");
			p.setCnvenFcltGuid(sc.next());

			System.out.println("테마를 입력하세요");
			p.setTourspotSumm(sc.next());

			String sql = "UPDATE pro " + "SET tourspotNm=?, " + "tourspotDtlAddr=?, " + "refadNo=?, " + "mngTime=?, "
					+ "tourUtlzAmt=?, " + "pkgFclt=?, " + "cnvenFcltGuid=?, " + "tourspotSumm=? " + "WHERE ID=?";
			PreparedStatement pstmt;

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, p.getTourspotNm());
			pstmt.setString(2, p.getTourspotDtlAddr());
			pstmt.setString(3, p.getRefadNo());
			pstmt.setString(4, p.getTourUtlzAmt());
			pstmt.setString(5, p.getMngTime());
			pstmt.setString(6, p.getPkgFclt());
			pstmt.setString(7, p.getCnvenFcltGuid());
			pstmt.setString(8, p.getTourspotSumm());
			pstmt.setInt(9, id);

			int result = pstmt.executeUpdate();

			if (result == 1) {
				System.out.println(p.getTourspotNm() + "추가 성공");
			} else {
				System.out.println(p.getTourspotNm() + "추가 실패");
			}
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("접근 권한이 없습니다.");
		}

	}

	public void displayData() {

		try {
			String sql = "select *from pro";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				System.out.print(rs.getString(1));
				System.out.print(". " + "\u001B[36m관광지: \u001B[0m" + rs.getString(2));
				System.out.print("\t" + "\u001B[36m주소: \u001B[0m" + rs.getString(3));
				System.out.print("\t" + "\u001B[36m전화번호: \u001B[0m" + rs.getString(4));
				System.out.print("\t" + "\u001B[36m운영시간: \u001B[0m" + rs.getString(5));
				System.out.print("\t" + "\u001B[36m이용요금: \u001B[0m" + rs.getString(6));
				System.out.print("\t" + "\u001B[36m주차: \u001B[0m" + rs.getString(7));
				System.out.print("\t" + "\u001B[36m관광정보: \u001B[0m" + rs.getString(8));
				System.out.print("\t" + "\u001B[36m테마: \u001B[0m" + rs.getString(9));

				System.out.println();

			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void insertData() {

		try {
			System.out.println("관광지 명을 입력하세요");
			p.setTourspotNm(sc.next());

			System.out.println("주소를 입력하세요");
			p.setTourspotDtlAddr(sc.next());

			System.out.println("전화번호를 입력하세요");
			p.setRefadNo(sc.next());

			System.out.println("운영 시간을 입력하세요");
			p.setMngTime(sc.next());

			System.out.println("이용 요금을 입력하세요");
			p.setTourUtlzAmt(sc.next());

			System.out.println("주차 시설을 입력하세요");
			p.setPkgFclt(sc.next());

			System.out.println("관광 정보를 입력하세요");
			p.setCnvenFcltGuid(sc.next());

			System.out.println("테마를 입력하세요");
			p.setTourspotSumm(sc.next());

			String sql = "insert into pro(ID, tourspotNm, tourspotDtlAddr, refadNo, mngTime,tourUtlzAmt,pkgFclt,cnvenFcltGuid,tourspotSumm) "
					+ "values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt;
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p.getID());

			pstmt.setString(2, p.getTourspotNm());
			pstmt.setString(3, p.getTourspotDtlAddr());
			pstmt.setString(4, p.getRefadNo());
			pstmt.setString(5, p.getTourUtlzAmt());
			pstmt.setString(6, p.getMngTime());
			pstmt.setString(7, p.getPkgFclt());
			pstmt.setString(8, p.getCnvenFcltGuid());
			pstmt.setString(9, p.getTourspotSumm());

			int result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println(p.getTourspotNm() + "추가 성공");
			} else {
				System.out.println(p.getTourspotNm() + "추가 실패");
			}
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("접근 권한이 없습니다.");
		}

	}

	public void displayOneData() {

		try {
			System.out.println("관광지 명을 입력하세요");
			String partialname = sc.next();

			String sql = "SELECT tourspotNm, tourspotDtlAddr, refadNo, mngTime, tourUtlzAmt, pkgFclt, cnvenFcltGuid, tourspotSumm FROM pro WHERE tourspotNm like ?";
			String name = "%" + partialname + "%";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("1. 관광지명: " + rs.getString(1));
				System.out.println("3. 주소: " + rs.getString(2));
				System.out.println("4. 전화번호: " + rs.getString(3));
				System.out.println("5. 운영시간: " + rs.getString(4));
				System.out.println("6. 이용요금: " + rs.getString(5));
				System.out.println("7. 주차시설: " + rs.getString(6));
				System.out.println("8. 관광정보: " + rs.getString(7));
				System.out.println("9. 테마: " + rs.getString(8));

			} else {
				System.out.println(name + "에 해당하는 데이터가 없습니다.");
			}

			rs.close();
			pstmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void administratorMode(Projectlist proj) throws Exception {
		int ch;

		do {
			System.out.println("번호를 선택하세요");
			System.out.println("\u001B[38;5;208m╔════════════════════╗");
			System.out.println("1.데이터 입력");
			System.out.println("2.데이터 전체 보기");
			System.out.println("3.관광지 정보 보기");
			System.out.println("4.데이터 업데이트 하기");
			System.out.println("5.데이터 삭제하기");
			System.out.println("6.나가기");
			System.out.println("╚════════════════════╝\u001B[0m");
			ch = sc.nextInt();

			switch (ch) {
			case 1:
				proj.insertData();

				break;
			case 2:
				proj.displayData();

				break;
			case 3:
				proj.displayOneData();

				break;
			case 4:
				proj.updateData();

				break;
			case 5:
				proj.deleteData();

				break;
			case 6:

				System.out.println("이용해 주셔서 감사합니다.");

			default:
				break;

			}
		} while (ch != 6);
	}

	public void userMode(Projectlist proj) {
		int ch;
		do {
			System.out.println("번호를 선택하세요");
			System.out.println("\u001B[38;5;208m╔════════════════════╗");
			System.out.println("1.데이터 전체 보기");
			System.out.println("2.관광지 정보 보기");
			System.out.println("3.나가기");
			System.out.println("╚════════════════════╝\u001B[0m");
			ch = sc.nextInt();

			switch (ch) {
			case 1:
				proj.displayData();

				break;
			case 2:
				proj.displayOneData();

				break;

			case 3:

				System.out.println("이용해 주셔서 감사합니다.");
				break;
			default:
				break;
			}
		} while (ch != 3);
	}

	private static boolean login(String userId, String password) {

		return "lotto".equals(userId) && "1234".equals(password);
	}

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		Projectlist proj = new Projectlist("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/project", "root",
				"1234");
		System.out.println("사용자 종류를 선택하세요:");
		System.out.println("1. 관리자");
		System.out.println("2. 일반 사용자");
		int userType = sc.nextInt();

		if (userType == 1) {
			// 관리자 로그인
			System.out.println("로그인을 진행하세요.");
			System.out.print("아이디: ");
			String userId = sc.next();
			System.out.print("비밀번호: ");
			String password = sc.next();

			if (login(userId, password)) {
				System.out.println("로그인 성공! 관리자 모드로 진입합니다.");
				proj.administratorMode(proj);
			} else {
				System.out.println("로그인 실패. 프로그램을 종료합니다.");
			}

		} else if (userType == 2) {
			// 일반 사용자 모드
			System.out.println("회원가입을 진행합니다.");
			proj.signUpManager.signUp();
			proj.signUpManager.displayMembers();

			System.out.println("로그인을 진행하세요");
			System.out.println("아이디: ");
			String userid = sc.next();
			System.out.println("비밀번호: ");
			String password = sc.next();

			if (proj.signUpManager.login(userid, password)) {
				System.out.println("로그인 성공! 일반 사용자 모드로 진입합니다.");
				proj.userMode(proj);
			} else {
				System.out.println("로그인 실패, 프로그램을 종료합니다.");
			}

		} else {
			System.out.println("올바르지 않은 선택입니다. 프로그램을 종료합니다.");

		}
		sc.close();

	}

}
