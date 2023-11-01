import java.sql.*;
import java.util.*;
/* INSERT 연습 */
public class Test2 {

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://192.168.56.101:4567/madang",
                    "kkmin","idmc7114");
            Statement stmt=con.createStatement();
            String sql = "INSERT INTO Book(bookid, bookname, publisher) VALUES (11, '스포츠 의학', '한솔의학서적')";

            int cnt = stmt.executeUpdate(sql);
            System.out.println("저장된 행 : " + cnt);

            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}
