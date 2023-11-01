import java.sql.*;

/* DELETE 연습 */
public class Test3 {
    public static void main(String args[])
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://192.168.56.101:4567/madang",
                    "kkmin","idmc7114");
            Statement stmt=con.createStatement();
            String sql = "DELETE FROM Book WHERE bookid = '11'";
            int rowCount = stmt.executeUpdate(sql);
            System.out.println("삭제된 행 : " + rowCount);
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}
