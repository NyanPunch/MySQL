import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("----------------------------------------");
        System.out.println("    수강신청 관리 시스템 2019038054 김경민  ");
        System.out.println("----------------------------------------");
        System.out.println("1 : INSERT     2: SELECT    3 : DELETE");
        System.out.println("4 : UPDATE     5:           6 : ");
        System.out.println("0 : QUIT");
        System.out.println("----------------------------------------");

        Scanner sc = new Scanner(System.in);
        String cmd = sc.nextLine();

        if (cmd.equals("1")){
            new INSERT();
        } else if (cmd.equals("2")) {
            new SELECT();
        } else if (cmd.equals("3")) {
            //DELETE();
        } else if (cmd.equals("4")) {
            //UPDATE();
//        } else if (cmd.equals("5")) {
//
//        } else if (cmd.equals("6")) {
//
        } else if (cmd.equals("0")) {
            System.out.println("QUIT");
        } else {
            System.out.println("잘못된 입력입니다.");
        }
    }
}