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
            System.out.println("1 : INSERT Student      2 : INSERT Professor    3 : INSERT Department");
            System.out.println("4 : INSERT Course   5 : INSERT OpenCourse    6 : INSERT Takes");
            System.out.println("7 : INSERT        8 : INSERT         9 : INSERT ");
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
            else if (cmd == 0) System.out.println("BACK TO MENU");
            else System.out.println("잘못된 입력입니다.");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void insertStudent() {
        try {
            String sql = "INSERT INTO STUDENT VALUES(?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);

            System.out.println("학번을 입력하세요(최대 8자). 예)20230001");
            int StudentID = sc.nextInt();
            pstmt.setInt(1, StudentID);

            System.out.println("이름을 입력하세요(최대 8자). 예)홍길동");
            String StudentName = sc.next();
            pstmt.setString(2, StudentName);

            System.out.println("학과를 입력하세요(최대 8자). 예)컴퓨터공학과");
            String StudentDept = sc.next();
            pstmt.setString(3, StudentDept);

            System.out.println("학년을 입력하세요(최대 1자). 예)1");
            int StudentGrade = sc.nextInt();
            pstmt.setInt(4, StudentGrade);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row inserted");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
