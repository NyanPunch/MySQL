import java.sql.*;
import java.util.Scanner;
public class INSERT {
    private Connection con;
    INSERT() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://192.168.56.101:4567/kkmindb",
                    "kkmin", "idmc7114");
            System.out.println("Choose Table to INSERT!");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("1 : INSERT Student  2 : INSERT Professor    3 : INSERT Department");
            System.out.println("4 : INSERT Course   5 : INSERT OpenCourse   6 : INSERT Takes");
            System.out.println("0 : BACK TO MENU");
            System.out.println("-----------------------------------------------------------------");
            System.out.print("명령어를 입력하세요 : ");

            Scanner sc = new Scanner(System.in);
            int cmd = sc.nextInt();
            if (cmd == 1) insertStudent();
            else if (cmd == 2) insertProfessor();
            else if (cmd == 3) insertDepartment();
            else if (cmd == 4) insertCourse();
            else if (cmd == 5) insertOpenCourse();
            else if (cmd == 6) insertTakes();
            else if (cmd == 0) System.out.println("BACK TO MENU");
            else System.out.println("잘못된 입력입니다.");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void insertStudent() {
        try {
            String sql = "INSERT INTO Student VALUES(?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);

            System.out.println("학번을 입력하세요(최대 8자). 예)2019054");
            String StudentID = sc.next();
            pstmt.setString(1, StudentID);

            System.out.println("이름을 입력하세요(최대 8자). 예)김경민");
            String SName = sc.next();
            pstmt.setString(2, SName);

            System.out.println("학년을 입력하세요(최대 6학년). 예)1");
            int Degree = sc.nextInt();
            pstmt.setInt(3, Degree);

            System.out.println("전공을 입력하세요(최대 100자). 예)소프트웨어학과");
            String Major = sc.next();
            pstmt.setString(4, Major);

            System.out.println("학과번호를 입력하세요(최대 8자). 예)038001");
            String DeptNo = sc.next();
            pstmt.setString(5, DeptNo);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row inserted");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void insertProfessor() {
        try {
            String sql = "INSERT INTO Professor VALUES(?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);

            System.out.println("교수번호를 입력하세요(최대 8자). 예)2019054");
            String ProfID = sc.next();
            pstmt.setString(1, ProfID);

            System.out.println("이름을 입력하세요(최대 30자). 예)김경민");
            String PName = sc.next();
            pstmt.setString(2, PName);

            System.out.println("연구실을 입력하세요(최대 30자). 예)데이터분석연구실");
            String Lab = sc.next();
            pstmt.setString(3, Lab);

            System.out.println("연구실 전화번호를 입력하세요(최대 15자). 예)043-1234");
            String Tel = sc.next();
            pstmt.setString(4, Tel);

            System.out.println("학과번호를 입력하세요(최대 8자). 예)038001");
            String DeptID = sc.next();
            pstmt.setString(5, DeptID);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row inserted");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void insertDepartment() {
        try {
            String sql = "INSERT INTO Department VALUES(?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);

            System.out.println("학과번호를 입력하세요(최대 8자). 예)038001");
            String DeptID = sc.next();
            pstmt.setString(1, DeptID);

            System.out.println("학과이름을 입력하세요(최대 100자). 예)소프트웨어학과");
            String DName = sc.next();
            pstmt.setString(2, DName);

            System.out.println("학과 전화번호를 입력하세요(최대 20자). 예)043-1234");
            String Tel = sc.next();
            pstmt.setString(3, Tel);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row inserted");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void insertCourse() {
        try {
            String sql = "INSERT INTO Course VALUES(?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);

            System.out.println("과목번호를 입력하세요(최대 8자). 예)038031");
            String CCode = sc.next();
            pstmt.setString(1, CCode);

            System.out.println("과목이름을 입력하세요(최대 100자). 예)데이터베이스시스템");
            String Title = sc.next();
            pstmt.setString(2, Title);

            System.out.println("학점을 입력하세요(최대 4학점). 예)3");
            int Credit = sc.nextInt();
            pstmt.setInt(3, Credit);

            System.out.println("학과번호를 입력하세요(최대 8자). 예)038001");
            String DeptID = sc.next();
            pstmt.setString(4, DeptID);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row inserted");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void insertOpenCourse() {
        try {
            String sql = "INSERT INTO OpenCourse VALUES(?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);

            System.out.println("개설번호를 입력하세요(최대 8자). 예)20230001");
            String OCNum = sc.next();
            pstmt.setString(1, OCNum);

            System.out.println("연도를 입력하세요. 예)2023");
            int Year = sc.nextInt();
            pstmt.setInt(2, Year);

            System.out.println("학기를 입력하세요(봄, 여름, 가을, 겨울). 예)여름");
            String Semester = sc.next();
            pstmt.setString(3, Semester);

            System.out.println("과목번호를 입력하세요(최대 8자). 예)038031");
            String CCode = sc.next();
            pstmt.setString(4, CCode);

            System.out.println("교수번호를 입력하세요(최대 8자). 예)2019054");
            String ProfID = sc.next();
            pstmt.setString(5, ProfID);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row inserted");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void insertTakes() {
        try {
            String sql = "INSERT INTO Takes VALUES(?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);

            System.out.println("학번을 입력하세요(최대 8자). 예)2019054");
            String Sno = sc.next();
            pstmt.setString(1, Sno);

            System.out.println("개설과목번호를 입력하세요(최대 8자). 예)20230001");
            String OCno = sc.next();
            pstmt.setString(2, OCno);

            System.out.println("학점을 입력하세요. 예)A+");
            String Grade = sc.next();
            pstmt.setString(3, Grade);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row inserted");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
