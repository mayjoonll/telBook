package view;

import dto.TelDto;
import service.TelBookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserView {
    private Scanner sc = new Scanner(System.in);
    private TelBookService telBookService = new TelBookService();
    public void insertView() {
        System.out.println("=== 전화번호 등록 ===");
    }

    public void updateView() {
        System.out.println("=== 전화번호 수정 ===");
    }

    public void deleteView() {
        System.out.println("=== 전화번호 삭제 ===");
    }

    public void findAllview() {
        List<TelDto> dtoList = new ArrayList<>();
        System.out.println("=== 전화번호 목록 ===");
        // 서비스에 DB에서 리스트요청하기
        dtoList = telBookService.getListAll();
        // 출력
        dtoList.stream()
                .forEach(x-> System.out.println(x));
    }

    public void seaerchView() {
        System.out.println("=== 전화번호 검색 ===");
    }


}
