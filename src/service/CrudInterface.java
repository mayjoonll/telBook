package service;

import dto.TelDto;

import java.util.List;

public interface CrudInterface {
    int InsertData(TelDto dto);

    int UpdateData(TelDto dto);

    int deleteData(int id);

    List<TelDto> getListAll(); // 전체 찾기

    TelDto findById(int id); // 한 개 데이터 찾기

    List<TelDto> serchList(String keyword); // 이름검색
}
