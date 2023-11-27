import java.sql.*;
import java.util.Scanner;

public class SELECT {
    private Connection con;
    private Statement stmt;
    private ResultSet rs;

    SELECT() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(
                    "jdbc:mysql://192.168.56.101:4567/kkmindb",
                    "kkmin","idmc7114");
            System.out.println("MySQL Server Connect!");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("1 : SELECT STUDENT      2 : SELECT PROFESSOR    3 : SELECT COURSE");
            System.out.println("4 : SELECT OPENCOURSE   5 : SELECT DEPARTMENT   6 : SELECT TAKES");
            System.out.println("7 : SELECT OFFERS       8 : SELECT OPENS        9 : SELECT TEACHES");
            System.out.println("10: SELECT BELONGS");
            System.out.println("0 : QUIT");
            System.out.println("-----------------------------------------------------------------");

            Scanner sc = new Scanner(System.in);
            int cmd = sc.nextInt();
            if (cmd == 1) selectStudent();
//            else if (cmd == 2) selectProfessor();
//            else if (cmd == 3) selectCourse();
//            else if (cmd == 4) selectOpenCourse();
//            else if (cmd == 5) selectDepartment();
//            else if (cmd == 6) selectTakes();
//            else if (cmd == 7) selectOffers();
//            else if (cmd == 8) selectOpens();
//            else if (cmd == 9) selectTeaches();
//            else if (cmd == 10) selectBelongs();
            else if (cmd == 0) System.out.println("QUIT");
            else System.out.println("잘못된 입력입니다.");
        }catch(Exception e){ System.out.println(e);}
    }
    public void selectStudent() {
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM STUDENT");
            while (rs.next())
                System.out.println(rs.getInt(1) + " " + rs.getString(2) +
                        " " + rs.getString(3) + " " + rs.getString(4));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
