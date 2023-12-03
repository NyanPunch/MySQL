import java.sql.*;
import java.util.Scanner;
public class DELETE {
    private Connection con;
    DELETE() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://192.168.56.101:4567/kkmindb",
                    "kkmin", "idmc7114");
            System.out.println("Choose Table to DELETE!");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("1 : DELETE Student  2 : DELETE Professor    3 : DELETE Department");
            System.out.println("4 : DELETE Course   5 : DELETE OpenCourse   ");
            System.out.println("0 : BACK TO MENU");
            System.out.println("-----------------------------------------------------------------");
            System.out.print("명령어를 입력하세요 : ");

            Scanner sc = new Scanner(System.in);
            int cmd = sc.nextInt();
            if (cmd == 1) deleteStudent();
            else if (cmd == 2) deleteProfessor();
            else if (cmd == 3) deleteDepartment();
            else if (cmd == 4) deleteCourse();
            else if (cmd == 5) deleteOpenCourse();
//            else if (cmd == 6) deleteTakes();
            else if (cmd == 0) System.out.println("BACK TO MENU");
            else System.out.println("잘못된 입력입니다.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void deleteStudent() { // 학생 정보 삭제
        try {
            String sql = "DELETE FROM Student WHERE StudentID = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);

            System.out.println("삭제할 학생의 학번을 입력하세요(최대 8자). 예)2019054");
            String StudentID = sc.next();
            pstmt.setString(1, StudentID);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row deleted");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void deleteProfessor() { // 교수 정보 삭제
        try {
            String sql = "DELETE FROM Professor WHERE ProfID = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);

            System.out.println("삭제할 교수의 교번을 입력하세요(최대 8자). 예)2019054");
            String ProfID = sc.next();
            pstmt.setString(1, ProfID);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row deleted");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void deleteDepartment() { // 학과 정보 삭제
        try {
            String sql = "DELETE FROM Department WHERE DeptID = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);

            System.out.println("삭제할 학과의 학과번호를 입력하세요(최대 8자). 예)2019054");
            String DeptID = sc.next();
            pstmt.setString(1, DeptID);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row deleted");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void deleteCourse() { // 교과목 정보 삭제
        try {
            String sql = "DELETE FROM Course WHERE CCode = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);

            System.out.println("삭제할 교과목의 교과목번호를 입력하세요(최대 8자). 예)2019054");
            String CourseID = sc.next();
            pstmt.setString(1, CourseID);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row deleted");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void deleteOpenCourse() { //개설교과목 정보 삭제
        try {
            String sql = "DELETE FROM OpenCourse WHERE OCNumber = ? AND Year = ? AND Semester = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);

            System.out.println("삭제할 개설교과목의 교과목번호를 입력하세요(최대 8자). 예)2019054");
            String OCNumber = sc.next();
            pstmt.setString(1, OCNumber);
            System.out.println("삭제할 개설교과목의 년도를 입력하세요(최대 4자). 예)2020");
            String Year = sc.next();
            pstmt.setString(2, Year);
            System.out.println("삭제할 개설교과목의 학기를 입력하세요(최대 1자). 예)1");
            String Semester = sc.next();
            pstmt.setString(3, Semester);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row deleted");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*
    * 삭제하기 위해 찾을 키가 많이 존재함. 따라서 키를 입력받아서 삭제하는 방식으로 구현하려 했으나
    * 키가 많아질수록 코드가 길어지고 복잡하고 비효율적이라고 판단하여 미구현
    * 그리고 수강한 내역을 삭제하는 행위도 부적합하다고 판단하여 미구현한 이유 중 하나
    */
    // private void deleteTakes() // 수강 정보 삭제
}
