package HospitalTest;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Hospital {
    private String addr; // 의료기관 주소
    private String mgtStaDd; // 운영시작일자
    private String pcrPsblYn; // PCR 가능 여부
    private String ratPsblYn; // RAT (신속항원검사) 가능 여부
    private int recuClCd; // 요양종별코드 (11: 종합병원 21: 병원 31: 의원)
    private String rprtWorpClicFndtTgtYn; // 호흡기 전담 클리닉 여부
    private String sgguCdNm; // 시군구명
    private String sidoCdNm; // 시도명
    private String telno; // 전화번호
    private int Xpos; // X좌표
    private String XPosWgs84; // 세계지구 x 좌표
    private int YPos; // Y좌표
    private String YPosWgs84; // 세계지구 Y좌표
    private String yadmNm; // 요양기관명
    private String ykihoEnc; // 암호화된 요양기호
}
