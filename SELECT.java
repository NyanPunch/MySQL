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
            System.out.println("Choose Table to SELECT!");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("1 : SELECT Student 2 : SELECT Professor    3 : SELECT Department");
            System.out.println("4 : SELECT Course  5 : SELECT OpenCourse   6 : SELECT Takes");
            System.out.println("0 : BACK TO MENU");
            System.out.println("-----------------------------------------------------------------");
            System.out.print("명령어를 입력하세요 : ");

            Scanner sc = new Scanner(System.in);
            int cmd = sc.nextInt();
            if (cmd == 1) selectStudent();
            else if (cmd == 2) selectProfessor();
            else if (cmd == 3) selectDepartment();
            else if (cmd == 4) selectCourse();
            else if (cmd == 5) selectOpenCourse();
            else if (cmd == 6) selectTakes();
            else if (cmd == 0) System.out.println("BACK TO MENU");
            else System.out.println("잘못된 입력입니다.");
        }catch(Exception e){ System.out.println(e);}
    }

    private void selectStudent() {
        try{
            String sql = "SELECT * FROM Student";
            PreparedStatement pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            System.out.println("학번 \t 이름 \t 전공 \t 학년 \t 학과번호");
            while(rs.next()){
                String StudentID = rs.getString("StudentID");
                String SName = rs.getString("SName");
                String Major = rs.getString("Major");
                int Degree = rs.getInt("Degree");
                String DeptNo = rs.getString("DeptNo");
                System.out.println(StudentID + " " + SName + " " + Major + " " + Degree + " " + DeptNo);
            }
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }

    private void selectProfessor() {
        try{
            String sql = "SELECT * FROM Professor";
            PreparedStatement pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            System.out.println("교번 \t 교수명 \t 연구실 \t 연구실전화번호 \t 학과번호");
            while(rs.next()){
                String ProfessorID = rs.getString("ProfID");
                String PName = rs.getString("PName");
                String Lab = rs.getString("Lab");
                String LabTel = rs.getString("LabTel");
                String DeptNo = rs.getString("DID");
                System.out.println(ProfessorID + " " + PName + " " + Lab + " " + LabTel + " " + DeptNo);
            }
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }

    private void selectDepartment() {
        try{
            String sql = "SELECT * FROM Department";
            PreparedStatement pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            System.out.println("학과번호 \t 학과명 \t 전화번호");
            while(rs.next()){
                String DeptID = rs.getString("DeptID");
                String DName = rs.getString("DeptName");
                String DTel = rs.getString("DeptTel");
                System.out.println(DeptID + " " + DName + " " + DTel);
            }
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }

    private void selectCourse() {
        try{
            String sql = "SELECT * FROM Course";
            PreparedStatement pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            System.out.println("교과목번호 \t교과목명 \t학점 \t학과번호");
            while(rs.next()){
                String CCode = rs.getString("CCode");
                String Title = rs.getString("Title");
                int Credits = rs.getInt("Credits");
                String DCode = rs.getString("DCode");
                System.out.println(CCode + " \t" + Title + " \t" + Credits + " \t" + DCode);
            }
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }

    private void selectOpenCourse() {
        try{
            String sql = "SELECT * FROM OpenCourse";
            PreparedStatement pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            System.out.println("개설과목번호\t개설연도\t개설학기\t교과목번호\t담당교수번호");
            while(rs.next()){
                String OCNumber = rs.getString("OCNumber");
                int Year = rs.getInt("Year");
                String Semester = rs.getString("Semester");
                String CourseCode = rs.getString("CourseCode");
                String Pno = rs.getString("Pno");
                System.out.println(OCNumber + "\t" + Year + "\t" + Semester + " \t" + CourseCode + " \t" + Pno);
            }
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }

    private void selectTakes() {
        try{
            String sql = "SELECT * FROM Takes";
            PreparedStatement pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            System.out.println("학번\t개설과목번호\t성적");
            while(rs.next()){
                String Sno = rs.getString("Sno");
                String OCno = rs.getString("OCno");
                String Grade = rs.getString("Grade");
                System.out.println(Sno + "\t" + OCno + "\t" + Grade);
            }
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}
