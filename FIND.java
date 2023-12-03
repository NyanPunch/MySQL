import java.sql.*;
import java.util.Scanner;

//특정 키 값으로 검색하여 해당 키 값의 튜플만 출력
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

    //학생 한 명의 정보만 출력
    private void findStudent() {
        try {
            String sql = "SELECT * FROM Student WHERE StudentID = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);

            System.out.println("찾을 학생의 학번을 입력하세요(최대 8자). 예)2019054");
            String StudentID = sc.next();
            pstmt.setString(1, StudentID);

            rs = pstmt.executeQuery();
            System.out.println("학번\t이름\t학년\t전공\t학과번호");
            while (rs.next()) {
                String SName = rs.getString("SName");
                int Degree = rs.getInt("Degree");
                String Major = rs.getString("Major");
                String DeptNo = rs.getString("DeptNo");
                System.out.println(StudentID + "\t" + SName + "\t" + Degree + "\t" + Major + "\t" + DeptNo);
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
            System.out.println("교번\t교수명\t연구실\t연구실전화번호\t학과번호");
            while (rs.next()) {
                String PName = rs.getString("PName");
                String Lab = rs.getString("Lab");
                String LabTel = rs.getString("LabTel");
                String DeptNo = rs.getString("DID");
                System.out.println(ProfID + "\t" + PName + "\t" + Lab + "\t" + LabTel + "\t" + DeptNo);
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
            System.out.println("학과번호\t학과명\t학과전화번호");
            while (rs.next()) {
                String DName = rs.getString("DeptName");
                String Tel = rs.getString("DeptTel");
                System.out.println(DeptID + "\t" + DName + "\t" + Tel);
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
            System.out.println("과목번호\t과목명\t학점\t학과번호");
            while (rs.next()) {
                String CName = rs.getString("Title");
                int Credit = rs.getInt("Credits");
                String DeptNo = rs.getString("DCode");
                System.out.println(CCode + "\t" + CName + "\t" + Credit + "\t" + DeptNo);
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
            System.out.println("개설번호\t연도\t학기\t교과목번호\t교수번호");
            while (rs.next()) {
                String Year = rs.getString("Year");
                String Semester = rs.getString("Semester");
                String CourseCode = rs.getString("CourseCode");
                String ProfID = rs.getString("Pno");
                System.out.println(OCNum + "\t" + Year + "\t" + Semester + "\t" + CourseCode + "\t" + ProfID);
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

            System.out.println("찾을 수강신청한 학번을 입력하세요(최대 8자). 예)2019054");
            String Sno = sc.next();
            pstmt.setString(1, Sno);

            rs = pstmt.executeQuery();
            System.out.println("학번\t개설번호\t성적");
            while (rs.next()) {
                String OCno = rs.getString("OCno");
                String Grade = rs.getString("Grade");
                System.out.println(Sno + "\t" + OCno + "\t" + Grade);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
