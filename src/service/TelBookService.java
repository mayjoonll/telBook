package service;

import db.DBConn;
import dto.TelDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelBookService implements CrudInterface{
    // Db 연결하기
    Connection conn = DBConn.getConnection();
    PreparedStatement psmt = null;
    String sql;

    @Override
    public int insertData(TelDto dto) {
        System.out.println("[TelBookService.InsertData]");

        try {
            sql = "INSERT INTO telbook(name, age, address, phone) ";
            sql = sql + "VALUES(?, ?, ?, ?)";

            psmt = conn.prepareStatement(sql);
            // ? 각 자리를 Mapping 해 준다.
            psmt.setString(1, dto.getName());
            psmt.setInt(2, dto.getAge());
            psmt.setString(3, dto.getAddress());
            psmt.setString(4, dto.getPhone());

            // 쿼리 실행하기
            int result = psmt.executeUpdate();
            psmt.close();
            return result;
        } catch (SQLException e) {
            System.out.println(e.toString());;
        }
        return 0;
    }

    @Override
    public int UpdateData(TelDto dto) {
        System.out.println("[TelBookService.UpdateData]");
        return 0;
    }

    @Override
    public int deleteData(int id) {
        System.out.println("[TelBookService.DeleteData]");
        int result = 0;
        try {
            sql = "DELETE FROM telbook WHERE id = ?";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, id);
            result = psmt.executeUpdate();
            psmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public List<TelDto> getListAll() {
        System.out.println("[TelBookService.getListAll]");
        // DB에서 select 한 결과를 담을 리스트 선언
        List<TelDto> dtoList = new ArrayList<>();
        ResultSet rs = null;

        try {
            sql = "SELECT * FROM telbook";
            psmt = conn.prepareStatement(sql);
            // SQL 구문 실행
            rs = psmt.executeQuery();

            // ResultSet 에 들어온 레코드들을 하나씩 뽑아서
            // DtoList에 담는다.
            while (rs.next()) {
                TelDto dto = new TelDto();
                dto.setId(rs.getInt("id"));
                dto.setName(rs.getString("name"));
                dto.setAge(rs.getInt("age"));
                dto.setAddress(rs.getString("address"));
                dto.setPhone(rs.getString("phone"));

                // 리스트에 담기
                dtoList.add(dto);
            }
            rs.close();
            psmt.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return dtoList;
    }

    @Override
    public TelDto findById(int id) {
        System.out.println("[TelBookService.findById]");
        return null;
    }

    @Override
    public List<TelDto> searchList(String keyword) {
        System.out.println("[TelBookService.searchList]");
        return List.of();
    }
}