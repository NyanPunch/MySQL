import java.sql.*;
import java.util.Scanner;
public class DELETE {
    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    DELETE() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://192.168.56.101:4567/kkmindb",
                    "kkmin", "idmc7114");
            System.out.println("MySQL Server Connect!");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("1 : DELETE STUDENT      2 : DELETE PROFESSOR    3 : DELETE COURSE");
            System.out.println("4 : DELETE OPENCOURSE   5 : DELETE DEPARTMENT   6 : DELETE TAKES");
            System.out.println("7 : DELETE OFFERS       8 : DELETE OPENS        9 : DELETE TEACHES");
            System.out.println("10: DELETE BELONGS");
            System.out.println("0 : BACK TO MENU");
            System.out.println("-----------------------------------------------------------------");

            Scanner sc = new Scanner(System.in);
            int cmd = sc.nextInt();
            if (cmd == 1) deleteStudent();
            else if (cmd == 2) deleteProfessor();
            else if (cmd == 3) deleteCourse();
            else if (cmd == 4) deleteOpenCourse();
            else if (cmd == 5) deleteDepartment();
//            else if (cmd == 6) deleteTakes();
//            else if (cmd == 7) deleteOffers();
//            else if (cmd == 8) deleteOpens();
//            else if (cmd == 9) deleteTeaches();
//            else if (cmd == 10) deleteBelongs();
            else if (cmd == 0) System.out.println("QUIT");
            else System.out.println("잘못된 입력입니다.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void deleteStudent() {
        try {
            String sql = "DELETE FROM STUDENT WHERE StudentID = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);

            System.out.println("삭제할 학생의 학번을 입력하세요(최대 8자). 예)20230001");
            int StudentID = sc.nextInt();
            pstmt.setInt(1, StudentID);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row deleted");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void deleteProfessor() {
        try {
            String sql = "DELETE FROM PROFESSOR WHERE ProfID = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);

            System.out.println("삭제할 교수의 학번을 입력하세요(최대 8자). 예)20230001");
            int ProfessorID = sc.nextInt();
            pstmt.setInt(1, ProfessorID);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row deleted");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void deleteCourse() {
        try {
            String sql = "DELETE FROM COURSE WHERE CID = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);

            System.out.println("삭제할 교과목의 교과목번호를 입력하세요(최대 8자). 예)20230001");
            int CourseID = sc.nextInt();
            pstmt.setInt(1, CourseID);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row deleted");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void deleteOpenCourse() {
        try {
            String sql = "DELETE FROM OPENCOURSE WHERE OCID = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);

            System.out.println("삭제할 개설과정의 개설과정번호를 입력하세요(최대 8자). 예)20230001");
            int OpenCourseID = sc.nextInt();
            pstmt.setInt(1, OpenCourseID);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row deleted");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void deleteDepartment() {
        try {
            String sql = "DELETE FROM DEPARTMENT WHERE DeptID = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);

            System.out.println("삭제할 학과의 학과번호를 입력하세요(최대 8자). 예)20230001");
            int DepartmentID = sc.nextInt();
            pstmt.setInt(1, DepartmentID);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row deleted");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // private void deleteTakes()
    // private void deleteOffers()
    // private void deleteOpens()
    // private void deleteTeaches()
    // private void deleteBelongs()
}
