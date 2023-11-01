# MySQL

데이터베이스 시스템 과제 리포지토리

* Test.java : Lab#7 과제
  * 문제 발생 [the last packet sent successfully to the server was 0 milliseconds ago]
    * 아이피 확인 - 이상 없음
    * 포트번호 확인 - 이상 없음
    * 과제 제대로 수행했는지 여부 확인 완료
    * 과제 재수행 후 문제 해결 - 재실행 시 `iptables`이 `inactive(dead)` 상태.
    * 사용할때마다 `systemctl start iptables` 사용하기 `systemctl status iptables`로 확인
  * 추후 각 Test들을 한 프로그램에서 가능하도록 구현하기
  []
