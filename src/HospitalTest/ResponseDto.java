package HospitalTest;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseDto {
    private Response response;

    @AllArgsConstructor
    @Data
    class Response {
        private Header header;

        private Body body;

        @AllArgsConstructor
        @Data
        class Header {
            private String resultCode; // 결과 코드
            private String resultMsg; // 결과 메세지
        }

        @AllArgsConstructor
        @Data
        class Body {
            private Items items;
            private int numOfRows; // 한 페이지 결과 수
            private int pageNo; // 페이지 번호
            private int totalCount; // 전체 결과 수

            @AllArgsConstructor
            @Data
            class Items {
                private List<Hospital> item;
            }
        }
    }
}
