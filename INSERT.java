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
            System.out.println("0 : QUIT");
            System.out.println("-----------------------------------------------------------------");

            Scanner sc = new Scanner(System.in);
            int cmd = sc.nextInt();
            if (cmd == 1) insertStudent();

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
}
