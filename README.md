# MySQL

데이터베이스 시스템 과제 리포지토리

* TermProject
  * 수강신청관리
  * Main.java - 해당 파일을 실행하여 수강신청관리 시스템에 접근할 수 있다.
  * INSERT.java - 해당 파일을 통해 테이블의 데이터 삽입을 수행한다.
  * SELECT.java - 해당 파일을 통해 테이블의 데이터를 확인할 수 있다. (SELECT * FROM 'tablename')으로 실행된다.
  * DELETE.java - 해당 파일을 통해 테이블의 데이터가 삭제된다.
  * FIND.java - 해당 파일을 통해 테이블의 데이터가 존재하는지 확인한다.
  * ~~PRINT.java~~ - 미구현, 미사용.
  * 일부 테이블에 대해서만 삽입, 선택, 삭제가 이루어진다.


---
* Test.java : Lab#7 과제
  * 문제 발생 [the last packet sent successfully to the server was 0 milliseconds ago]
    * 아이피 확인 - 이상 없음
    * 포트번호 확인 - 이상 없음
    * 과제 제대로 수행했는지 여부 확인 완료
    * 과제 재수행 후 문제 해결 - VM 재실행 시 `iptables`이 `inactive(dead)` 상태.
      ![image](https://github.com/NyanPunch/MySQL/assets/51149853/b09e3d82-868e-4da1-bfcc-c970c3b40ceb)
    * 사용할때마다 `systemctl start iptables` 사용하기 `systemctl status iptables`로 active 확인하기
   * 추후 각 Test들을 한 프로그램에서 가능하도록 구현하기
