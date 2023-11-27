import java.sql.*;
import java.util.Scanner;
public class INSERT {
    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    INSERT() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://192.168.56.101:4567/kkmindb",
                    "kkmin", "idmc7114");
            System.out.println("MySQL Server Connect!");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("1 : INSERT STUDENT      2 : INSERT PROFESSOR    3 : INSERT COURSE");
            System.out.println("4 : INSERT OPENCOURSE   5 : INSERT DEPARTMENT   6 : INSERT TAKES");
            System.out.println("7 : INSERT OFFERS       8 : INSERT OPENS        9 : INSERT TEACHES");
            System.out.println("10: INSERT BELONGS");
            System.out.println("0 : BACK TO MENU");
            System.out.println("-----------------------------------------------------------------");

            Scanner sc = new Scanner(System.in);
            int cmd = sc.nextInt();
            if (cmd == 1) insertStudent();
            else if (cmd == 2) insertProfessor();
            else if (cmd == 3) insertCourse();
            else if (cmd == 4) insertOpenCourse();
            else if (cmd == 5) insertDepartment();
//            else if (cmd == 6) insertTakes();
//            else if (cmd == 7) insertOffers();
//            else if (cmd == 8) insertOpens();
//            else if (cmd == 9) insertTeaches();
//            else if (cmd == 10) insertBelongs();
            else if (cmd == 0) System.out.println("QUIT");
            else System.out.println("잘못된 입력입니다.");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void insertStudent() {
        try {
            String sql = "INSERT INTO STUDENT (StudentID, SName, Degree, Major) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);

            System.out.println("학번을 입력하세요(최대 8자). 예)20230001");
            int StudentID = sc.nextInt();
            pstmt.setInt(1, StudentID);

            System.out.println("이름을 입력하세요.");
            String SName = sc.next();
            pstmt.setString(2, SName);

            System.out.println("학년을 입력하세요(1~6).");
            int Degree = sc.nextInt();
            pstmt.setInt(3, Degree);

            System.out.println("전공을 입력하세요.");
            String Major = sc.next();
            pstmt.setString(4, Major);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row inserted");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void insertProfessor() {
        try {
            String sql = "INSERT INTO PROFESSOR (ProfID, PName, Office, PTel) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);

            System.out.println("교번을 입력하세요(최대 8자). 예)11110001");
            int ProfessorID = sc.nextInt();
            pstmt.setInt(1, ProfessorID);

            System.out.println("이름을 입력하세요.");
            String PName = sc.next();
            pstmt.setString(2, PName);

            System.out.println("사무실을 입력하세요.");
            String Office = sc.next();
            pstmt.setString(3, Office);

            System.out.println("전화번호를 입력하세요.");
            String PTel = sc.next();
            pstmt.setString(4, PTel);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row inserted");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void insertCourse() {
        try {
            String sql = "INSERT INTO COURSE (CID, Title, Credits) VALUES (?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);

            System.out.println("교과목번호를 입력하세요(최대 8자)");
            int CourseID = sc.nextInt();
            pstmt.setInt(1, CourseID);

            System.out.println("교과목명을 입력하세요.");
            String CName = sc.next();
            pstmt.setString(2, CName);

            System.out.println("학점을 입력하세요.");
            int Credits = sc.nextInt();
            pstmt.setInt(3, Credits);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row inserted");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void insertOpenCourse() {
        try {
            String sql = "INSERT INTO OPENCOURSE (OCID, OCNo, Sem, OCYear) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);

            System.out.println("개설교과목번호를 입력하세요.(최대 8자)");
            int OCID = sc.nextInt();
            pstmt.setInt(1, OCID);

            System.out.println("개설 반 번호를 입력하세요.(1, 2, 3)");
            int OCNo = sc.nextInt();
            pstmt.setInt(2, OCNo);

            System.out.println("개설학기를 입력하세요.(Spring, Summer, Fall, Winter 중 작성)");
            String Sem = sc.next();
            pstmt.setString(2, Sem);

            System.out.println("개설년도를 입력하세요.");
            int OCYear = sc.nextInt();
            pstmt.setInt(3, OCYear);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row inserted");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void insertDepartment() {
        try {
            String sql = "INSERT INTO DEPARTMENT (DeptID, DName, DTel) VALUES (?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);

            System.out.println("학과번호를 입력하세요.(최대 8자)");
            int DeptID = sc.nextInt();
            pstmt.setInt(1, DeptID);

            System.out.println("학과명을 입력하세요.");
            String DName = sc.next();
            pstmt.setString(2, DName);

            System.out.println("학과 전화번호를 입력하세요.");
            String DTel = sc.next();
            pstmt.setString(3, DTel);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row inserted");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // private void insertTakes()
    // private void insertOffers()
    // private void insertOpens()
    // private void insertTeaches()
    // private void insertBelongs()
}
