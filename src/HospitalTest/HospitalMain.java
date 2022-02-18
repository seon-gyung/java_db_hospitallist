package HospitalTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

public class HospitalMain {
    public static void main(String[] args) {
        try {
            List<Hospital> result = HospitalDownload.hospitalList();

            // 1. connection 연결 (세션 생성) port, IP주소, ID, password, protocol
			Connection conndb = DriverManager.getConnection // 소켓 만든 것과 같음
            ("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
            System.out.println("DB연결완료");

            // 2. 버퍼 달기
            String sql = "INSERT INTO Hospital(addr, mgtStaDd, pcrPsblYn, ratPsblYn, recuClCd, rprtWorpClicFndtTgtYn, sgguCdNm, sidoCdNm, telno, Xpos, XPosWgs84, YPos, YPosWgs84, yadmNm, ykihoEnc) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; // JAVA와 연동할 때는 끝에 세미콜론 필요 없음.
			PreparedStatement pstmt = conndb.prepareStatement(sql); // 프로토콜이 정해진 버퍼. Buffered Writer
            
            for (int i = 0; i < result.size(); i++) {
                pstmt.setString(1, result.get(i).getAddr());
                pstmt.setString(2, result.get(i).getMgtStaDd());
                pstmt.setString(3, result.get(i).getPcrPsblYn());
                pstmt.setString(4, result.get(i).getRatPsblYn());
                pstmt.setInt(5, result.get(i).getRecuClCd());
                pstmt.setString(6, result.get(i).getRprtWorpClicFndtTgtYn());
                pstmt.setString(7, result.get(i).getSgguCdNm());
                pstmt.setString(8, result.get(i).getSidoCdNm());
                pstmt.setString(9, result.get(i).getTelno());
                pstmt.setInt(10, result.get(i).getXpos());
                pstmt.setString(11, result.get(i).getXPosWgs84());
                pstmt.setInt(12, result.get(i).getYPos());
                pstmt.setString(13, result.get(i).getYPosWgs84());
                pstmt.setString(14, result.get(i).getYadmNm());
                pstmt.setString(15, result.get(i).getYkihoEnc());

                pstmt.executeUpdate();
            }

            } catch (Exception e) {
                System.out.println("오류 : " + e.getMessage()); 
                // e.printStackTrace();
        }
    }
}
