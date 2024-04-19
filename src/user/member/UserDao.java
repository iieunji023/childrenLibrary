package user.member;

import config.BookDBConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    // 중복검사
    public Boolean isUserExist(UserDto userDto) {
        Connection conn         = null;
        PreparedStatement pstmt = null;
        ResultSet rs            = null;
        int result = -1;

        try{
            Class.forName(BookDBConfig.DB_DRIVER_NAME);

            conn = DriverManager.getConnection(BookDBConfig.DB_URL,
                    BookDBConfig.DB_USER,
                    BookDBConfig.DB_PW);

            String sql = "SELECT COUNT(*) AS CNT FROM USER_TABLE " +
                         "WHERE ID = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userDto.getId());

            rs = pstmt.executeQuery();

            while (rs.next()) {
                result = rs.getInt("CNT");

            }

        }catch (Exception e) {
            e.printStackTrace();

        }finally {
            try{
                if(pstmt == null) pstmt.close();
                if(conn == null) conn.close();

            }catch (Exception e) {
                e.printStackTrace();

            }
        }
        return (result > 0 ? true : false);

    }

    // 회원가입
    public int insertUserSignUpInfo(UserDto userDto) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int result = -1;

        try{
            Class.forName(BookDBConfig.DB_DRIVER_NAME);

            conn = DriverManager.getConnection(BookDBConfig.DB_URL,
                                               BookDBConfig.DB_USER,
                                               BookDBConfig.DB_PW);

            String sql = "INSERT INTO USER_TABLE(ID, PW, NAME, PHONE, ADDRESS, CREATED_AT) " +
                         "VALUES(?, ?, ?, ?, ?, SYSDATE)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userDto.getId());
            pstmt.setString(2, userDto.getPw());
            pstmt.setString(3, userDto.getName());
            pstmt.setString(4, userDto.getPhone());
            pstmt.setString(5, userDto.getAddress());

            result = pstmt.executeUpdate();

        }catch (Exception e) {
            e.printStackTrace();

        }finally {
            try{
                if(pstmt == null) pstmt.close();
                if(conn == null) conn.close();

            }catch (Exception e) {
                e.printStackTrace();

            }
        }
        return result;

    }

    // 로그인
    public List<UserDto> selectUser(UserDto userDto) {
        Connection conn         = null;
        PreparedStatement pstmt = null;
        ResultSet rs            = null;
        List<UserDto> userDtos = new ArrayList<>();

        try{
            Class.forName(BookDBConfig.DB_DRIVER_NAME);

            conn = DriverManager.getConnection(BookDBConfig.DB_URL,
                    BookDBConfig.DB_USER,
                    BookDBConfig.DB_PW);

            String sql = "SELECT * FROM USER_TABLE " +
                         "WHERE ID = ? AND PW = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userDto.getId());
            pstmt.setString(2, userDto.getPw());

            rs = pstmt.executeQuery();

            while (rs.next()) {
                int no = rs.getInt("NO");
                String id = rs.getString("ID");
                String pw = rs.getString("PW");
                String name = rs.getString("NAME");
                String phone = rs.getString("PHONE");
                String address = rs.getString("ADDRESS");
                String created_at = rs.getString("CREATED_AT");

                userDtos.add(
                        new UserDto(no,
                                    id,
                                    pw,
                                    name,
                                    phone,
                                    address,
                                    created_at)

                );

            }

        }catch (Exception e) {
            e.printStackTrace();

        }finally {
            try{
                if(pstmt == null) pstmt.close();
                if(conn == null) conn.close();

            }catch (Exception e) {
                e.printStackTrace();

            }
        }
        return userDtos;
    }

    // 회원정보수정
    public int updateUser(UserDto userDto) {
        Connection conn             = null;
        PreparedStatement pstmt     = null;
        List<UserDto> userDtos      = new ArrayList<>();
        int result                  = -1;

        try{
            Class.forName(BookDBConfig.DB_DRIVER_NAME);

            conn = DriverManager.getConnection( BookDBConfig.DB_URL,
                                                BookDBConfig.DB_USER,
                                                BookDBConfig.DB_PW);

            String sql = "UPDATE USER_TABLE SET PW = ?, NAME = ?, PHONE = ?, ADDRESS = ? " +
                         "WHERE NO = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userDto.getPw());
            pstmt.setString(2, userDto.getName());
            pstmt.setString(3, userDto.getPhone());
            pstmt.setString(4, userDto.getAddress());
            pstmt.setInt(5, userDto.getNo());

            result = pstmt.executeUpdate();

        }catch (Exception e) {
            e.printStackTrace();

        }finally {
            try{
                if(pstmt == null) pstmt.close();
                if(conn == null) conn.close();

            }catch (Exception e) {
                e.printStackTrace();

            }
        }
        return result;
    }

    // 회원탈퇴
    public int deleteUser(int no) {
        Connection conn             = null;
        PreparedStatement pstmt     = null;
        int result                  = -1;

        try{
            Class.forName(BookDBConfig.DB_DRIVER_NAME);

            conn = DriverManager.getConnection( BookDBConfig.DB_URL,
                                                BookDBConfig.DB_USER,
                                                BookDBConfig.DB_PW);

            String sql = "DELETE FROM USER_TABLE " +
                         "WHERE NO = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, no);

            result = pstmt.executeUpdate();

        }catch (Exception e) {
            e.printStackTrace();

        }finally {
            try{
                if(pstmt == null) pstmt.close();
                if(conn == null) conn.close();

            }catch (Exception e) {
                e.printStackTrace();

            }
        }
        return result;

    }
}
