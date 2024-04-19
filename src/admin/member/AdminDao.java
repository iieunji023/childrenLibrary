package admin.member;

import config.BookDBConfig;
import user.member.UserDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDao {
    /*
     * 회원가입 METHOD
     */
    public int insertAdminSignUpInfo(AdminDto adminDto) {
        Connection conn         = null;
        PreparedStatement pstmt = null;
        int result              = -1;       // 1, 0을 준다는 것은 db에 접속을 했다는 의미. -1은 db 접속 오류!

        try {
            Class.forName(BookDBConfig.DB_DRIVER_NAME);
            conn = DriverManager.getConnection(BookDBConfig.DB_URL,
                    BookDBConfig.DB_USER,
                    BookDBConfig.DB_PW);

            String sql = "INSERT INTO ADMIN(ID, PW, NAME, PHONE, CREATED_AT) " +
                         "VALUES (?, ?, ?, ?, SYSDATE)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, adminDto.getId());
            pstmt.setString(2, adminDto.getPw());
            pstmt.setString(3, adminDto.getName());
            pstmt.setString(4, adminDto.getPhone());

            result = pstmt.executeUpdate();

        } catch (Exception e){
            e.printStackTrace();;

        }finally {
            try{
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();

            }catch (Exception e) {
                e.printStackTrace();

            }

        }
        return result;

    }

    /*
     * ID, PW 중복확인 METHOD
     */
    public boolean isAdminExist(AdminDto adminDto) {
        Connection conn         = null;
        PreparedStatement pstmt = null;
        ResultSet rs            = null;
        int result              = -1;

        try{
            Class.forName(BookDBConfig.DB_DRIVER_NAME);
            conn = DriverManager.getConnection(BookDBConfig.DB_URL,
                                               BookDBConfig.DB_USER,
                                               BookDBConfig.DB_PW);

            String sql = "SELECT COUNT(*) AS CNT FROM ADMIN " +
                         "WHERE ID = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, adminDto.getId());

            rs = pstmt.executeQuery();

            while (rs.next()){
                result = rs.getInt("CNT");       // 컬럼의 값을 불러오는 것이 rs, CNT는 숫자로 나타나기 때문에 getInt로 불러오는 것

            }
        }catch (Exception e) {
            e.printStackTrace();

        }finally {
            try{
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();

            } catch (Exception e){
                e.printStackTrace();

            }

        }
        return (result > 0) ? true : false;

    }

    /*
     * 로그인 METHOD
     */
    public ArrayList<AdminDto> selectAdmin(AdminDto adminDto) {
        Connection conn         = null;
        PreparedStatement pstmt = null;
        ResultSet rs            = null;
        ArrayList<AdminDto> adminDtos = new ArrayList<>();

        try{
            Class.forName(BookDBConfig.DB_DRIVER_NAME);
            conn = DriverManager.getConnection(BookDBConfig.DB_URL,
                                               BookDBConfig.DB_USER,
                                               BookDBConfig.DB_PW);

            String sql = "SELECT * FROM ADMIN " +
                         "WHERE ID = ? AND PW = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, adminDto.getId());
            pstmt.setString(2, adminDto.getPw());

            rs = pstmt.executeQuery();

            // rs => 행을 읽는 역할, get을 통해 행에 저장된 값을 가져오겠다.
            while (rs.next()) {
                int no = rs.getInt("NO");
                String id = rs.getString("ID");
                String pw = rs.getString("PW");
                String name = rs.getString("NAME");
                String phone = rs.getString("PHONE");
                String created_at = rs.getString("CREATED_AT");

                adminDtos.add(
                        // 로그인했을 때 id와 일치하는 회원의 정보를 가져오기 위함
                        new AdminDto(
                                        no,
                                        id,
                                        pw,
                                        name,
                                        phone,
                                        created_at
                        )
                );
            }

        }catch (Exception e) {
            e.printStackTrace();

        }finally {
            try{
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();

            }catch (Exception e) {
                e.printStackTrace();

            }

        }
        return adminDtos;

    }

    /*
     * 회원정보수정 METHOD
     */
    public int updateAdmin(AdminDto adminDto) {
        Connection conn         = null;
        PreparedStatement pstmt = null;
        int result              = -1;

        try{
            Class.forName(BookDBConfig.DB_DRIVER_NAME);
            conn = DriverManager.getConnection(BookDBConfig.DB_URL,
                                               BookDBConfig.DB_USER,
                                               BookDBConfig.DB_PW);

            String sql = "UPDATE ADMIN SET PW = ?, NAME = ?, PHONE = ? " +
                         "WHERE NO = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, adminDto.getPw());
            pstmt.setString(2, adminDto.getName());
            pstmt.setString(3, adminDto.getPhone());
            pstmt.setInt(4, adminDto.getNo());

            result = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try{
                if(pstmt!=null) pstmt.close();
                if(conn!=null) conn.close();

            }catch (Exception e) {
                e.printStackTrace();

            }

        }
        return result;

    }

    // 회원탈퇴
    public int DeleteAdmin(int no) {
        Connection conn         = null;
        PreparedStatement pstmt = null;
        int result              = -1;

        try{
            Class.forName(BookDBConfig.DB_DRIVER_NAME);
            conn = DriverManager.getConnection(BookDBConfig.DB_URL,
                                               BookDBConfig.DB_USER,
                                               BookDBConfig.DB_PW);

            String sql = "DELETE FROM ADMIN " +
                         "WHERE NO = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, no);

            result = pstmt.executeUpdate();

        }catch (Exception e) {
            e.printStackTrace();

        }finally {
            try{
                if(pstmt!=null) pstmt.close();
                if(conn!=null) conn.close();

            }catch (Exception e) {
                e.printStackTrace();

            }

        }
        return result;

    }

    // 전체 유저 정보
    public List<UserDto> selectAllUserByAdmin() {
        Connection conn         = null;
        PreparedStatement pstmt = null;
        ResultSet rs            = null;

        List<UserDto> userDtos = new ArrayList<>();

        try{
            Class.forName(BookDBConfig.DB_DRIVER_NAME);
            conn = DriverManager.getConnection(BookDBConfig.DB_URL,
                    BookDBConfig.DB_USER,
                    BookDBConfig.DB_PW);

            String sql = "SELECT * FROM USER_TABLE";

            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                int no = rs.getInt("NO");
                String id = rs.getString("ID");
                String name = rs.getString("NAME");
                String phone = rs.getString("PHONE");
                String address = rs.getString("ADDRESS");
                String created_at = rs.getString("CREATED_AT");

                userDtos.add(
                        new UserDto(
                                no,
                                id,
                                name,
                                phone,
                                address,
                                created_at
                        )
                );
            }

        }catch (Exception e) {
            e.printStackTrace();

        }finally {
            try{
                if(pstmt!=null) pstmt.close();
                if(conn!=null) conn.close();

            }catch (Exception e) {
                e.printStackTrace();

            }

        }
        return userDtos;

    }
}
