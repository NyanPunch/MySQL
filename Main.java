import java.util.Scanner;

/**
 * Created by 김경민 on 2023-11-27 ~ .
 * Notice DB연결 전 iptables 활성화 필요
 */

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("----------------------------------------");
        System.out.println("    수강신청 관리 시스템 2019038054 김경민  ");

        while (true) {
            System.out.println("----------------------------------------");
            System.out.println("1 : INSERT     2: SELECT    3 : DELETE");
            System.out.println("4 : FIND       ");
            System.out.println("0 : QUIT");
            System.out.println("----------------------------------------");
            System.out.print("명령어를 입력하세요 : ");
            String cmd = sc.nextLine();

            if (cmd.equals("1")) {
                new INSERT();
            } else if (cmd.equals("2")) {
                new SELECT();
            } else if (cmd.equals("3")) {
                new DELETE();
            } else if (cmd.equals("4")) {
                new FIND();
            } else if (cmd.equals("5")) {
                //new UPDATE();
            } else if (cmd.equals("6")) {
                //new PRINT();
            } else if (cmd.equals("0")) {
                System.out.println("See you again! :) ");
                break;
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }
}