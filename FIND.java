import java.sql.*;
import java.util.Scanner;

public class FIND {
    private Connection con;
    private ResultSet rs;

    FIND() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://192.168.56.101:4567/kkmindb",
                    "kkmin", "idmc7114");
            System.out.println("Choose Table to FIND!");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("1 : FIND Student 2 : FIND Professor    3 : FIND Department");
            System.out.println("4 : FIND Course  5 : FIND OpenCourse   6 : FIND Takes");
            System.out.println("0 : BACK TO MENU");
            System.out.println("-----------------------------------------------------------------");
            System.out.print("명령어를 입력하세요 : ");

            Scanner sc = new Scanner(System.in);
            int cmd = sc.nextInt();
            if (cmd == 1) findStudent();
            else if (cmd == 2) findProfessor();
            else if (cmd == 3) findDepartment();
            else if (cmd == 4) findCourse();
            else if (cmd == 5) findOpenCourse();
            else if (cmd == 6) findTakes();
            else if (cmd == 0) System.out.println("BACK TO MENU");
            else System.out.println("잘못된 입력입니다.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void findStudent() {
        try {
            String sql = "SELECT * FROM Student WHERE StudentID = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);

            System.out.println("찾을 학생의 학번을 입력하세요(최대 8자). 예)2019054");
            String StudentID = sc.next();
            pstmt.setString(1, StudentID);

            rs = pstmt.executeQuery();
            System.out.println("학번 \t 이름 \t 학년 \t 전공 \t 학과번호");
            while (rs.next()) {
                String SName = rs.getString("SName");
                int Degree = rs.getInt("Degree");
                String Major = rs.getString("Major");
                String DeptNo = rs.getString("DeptNo");
                System.out.println(StudentID + " " + SName + " " + Degree + " " + Major + " " + DeptNo);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void findProfessor() {
        try {
            String sql = "SELECT * FROM Professor WHERE ProfID = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);

            System.out.println("찾을 교수의 교번을 입력하세요(최대 8자). 예)2019054");
            String ProfID = sc.next();
            pstmt.setString(1, ProfID);

            rs = pstmt.executeQuery();
            System.out.println("교번 \t 교수명 \t 연구실 \t 연구실전화번호 \t 학과번호");
            while (rs.next()) {
                String PName = rs.getString("PName");
                String Lab = rs.getString("Lab");
                String LabTel = rs.getString("LabTel");
                String DeptNo = rs.getString("DID");
                System.out.println(ProfID + " " + PName + " " + Lab + " " + LabTel + " " + DeptNo);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void findDepartment() {
        try {
            String sql = "SELECT * FROM Department WHERE DeptID = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);

            System.out.println("찾을 학과의 학과번호를 입력하세요(최대 8자). 예)2019054");
            String DeptID = sc.next();
            pstmt.setString(1, DeptID);

            rs = pstmt.executeQuery();
            System.out.println("학과번호 \t 학과명 \t 학과전화번호");
            while (rs.next()) {
                String DName = rs.getString("DeptName");
                String Tel = rs.getString("DeptTel");
                System.out.println(DeptID + " " + DName + " " + Tel);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void findCourse() {
        try {
            String sql = "SELECT * FROM Course WHERE CCode = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);

            System.out.println("찾을 과목의 과목번호를 입력하세요(최대 8자). 예)038031");
            String CCode = sc.next();
            pstmt.setString(1, CCode);

            rs = pstmt.executeQuery();
            System.out.println("과목번호 \t 과목명 \t 학점 \t 학과번호");
            while (rs.next()) {
                String CName = rs.getString("Title");
                int Credit = rs.getInt("Credits");
                String DeptNo = rs.getString("DCode");
                System.out.println(CCode + " " + CName + " " + Credit + " " + DeptNo);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void findOpenCourse() {
        try {
            String sql = "SELECT * FROM OpenCourse WHERE OCNumber = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);

            System.out.println("찾을 개설교과목의 개설번호를 입력하세요(최대 8자). 예)20230001");
            String OCNum = sc.next();
            pstmt.setString(1, OCNum);

            rs = pstmt.executeQuery();
            System.out.println("개설번호 \t 연도 \t 학기 \t 교과목번호 \t 교수번호");
            while (rs.next()) {
                String Year = rs.getString("Year");
                String Semester = rs.getString("Semester");
                String CourseCode = rs.getString("CourseCode");
                String ProfID = rs.getString("Pno");
                System.out.println(OCNum + " " + Year + " " + Semester + " " + CourseCode + " " + ProfID);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void findTakes() {
        try {
            String sql = "SELECT * FROM Takes WHERE Sno = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);

            System.out.println("찾을 수강신청의 학번을 입력하세요(최대 8자). 예)2019054");
            String Sno = sc.next();
            pstmt.setString(1, Sno);

            rs = pstmt.executeQuery();
            System.out.println("학번 \t 개설번호 \t 성적");
            while (rs.next()) {
                String OCno = rs.getString("OCno");
                String Grade = rs.getString("Grade");
                System.out.println(Sno + " " + OCno + " " + Grade);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
