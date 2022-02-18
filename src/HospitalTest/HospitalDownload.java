package HospitalTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;

public class HospitalDownload{
    public static List<Hospital> hospitalList(){
        try {
            // 1. URL
            URL url = new URL(
                "http://apis.data.go.kr/B551182/rprtHospService/getRprtHospService?serviceKey=wJmmW29e3AEUjwLioQR22CpmqS645ep4S8TSlqtSbEsxvnkZFoNe7YG1weEWQHYZ229eNLidnI2Yt5EZ3Stv7g%3D%3D&pageNo=1&numOfRows=5190&_type=json"
                        );
            
            // 2. ByteStream 연결
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            // 3. BufferedReader로 데이터 읽어오기
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"));
            
            // 4. flush 버퍼 비우기
            String responseJson = br.readLine();
            
            // 5. JAVA 오브젝트로 변환
            Gson gson = new Gson();
            ResponseDto responseDto = gson.fromJson(responseJson, ResponseDto.class);

            // 병원 개수 데이터만 실시간으로 받아오기!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            // 1. URL
            int totalCount = responseDto.getResponse().getBody().getTotalCount();
            url = new URL(
                "http://apis.data.go.kr/B551182/rprtHospService/getRprtHospService?serviceKey=wJmmW29e3AEUjwLioQR22CpmqS645ep4S8TSlqtSbEsxvnkZFoNe7YG1weEWQHYZ229eNLidnI2Yt5EZ3Stv7g%3D%3D&pageNo=1&numOfRows="
                + totalCount+"&_type=json");
            
            // 2. ByteStream 연결
            conn = (HttpURLConnection) url.openConnection();
            
            // 3. BufferedReader로 데이터 읽어오기
            br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"));
            
            // 4. flush 버퍼 비우기
            responseJson = br.readLine();
            
            // 5. JAVA 오브젝트로 변환
            gson = new Gson();
            responseDto = gson.fromJson(responseJson, ResponseDto.class);

            List<Hospital> result = responseDto.getResponse().getBody().getItems().getItem();
            return result;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
