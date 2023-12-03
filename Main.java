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
            System.out.println("1 : INSERT     2 : SELECT    3 : DELETE");
            System.out.println("4 : FIND");
            System.out.println("0 : QUIT");
            System.out.println("----------------------------------------");
            System.out.print("명령어를 입력하세요 : ");
            String cmd = sc.nextLine();

            if (cmd.equals("1")) {
                // 해당 테이블의 새로운 값 삽입
                new INSERT();
            } else if (cmd.equals("2")) {
                //해당 테이블의 모든 값 출력
                new SELECT();
            } else if (cmd.equals("3")) {
                // 해당 테이블의 특정 키 값의 튜플 제거
                new DELETE();
            } else if (cmd.equals("4")) {
                // 특정 키 값으로 검색하여 해당 키 값의 튜플만 출력
                new FIND();
            } else if (cmd.equals("0")) { // 프로그램 종료
                System.out.println("See you again! :) ");
                break;
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }
}