package user.book;

import book.RentalDto;
import config.BookDBConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserBookDao {

    // 가장 작은 no값 출력
    public int selectNoForRental(String title) {
        Connection conn         = null;
        PreparedStatement pstmt = null;
        ResultSet rs            = null;
        int no = 0;

        try {
            Class.forName(BookDBConfig.DB_DRIVER_NAME);
            conn = DriverManager.getConnection( BookDBConfig.DB_URL,
                                                BookDBConfig.DB_USER,
                                                BookDBConfig.DB_PW);

            String sql = "SELECT MIN(NO) AS NO FROM BOOK " +
                         "WHERE TITLE LIKE ? AND BOOKING_YN = 'N' ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + title + "%");

            rs = pstmt.executeQuery();

            while (rs.next()) {
                no = rs.getInt("NO");

            }

        } catch (Exception e){
            e.printStackTrace();

        }finally {
            try{
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();

            }catch (Exception e) {
                e.printStackTrace();

            }

        }
        return no;
    }

    // 대여여부 변경
    public int updateBookingYn(int no) {
        Connection conn         = null;
        PreparedStatement pstmt = null;
        int result              = -1;

        try {
            Class.forName(BookDBConfig.DB_DRIVER_NAME);
            conn = DriverManager.getConnection( BookDBConfig.DB_URL,
                    BookDBConfig.DB_USER,
                    BookDBConfig.DB_PW);

            String sql = "UPDATE BOOK SET BOOKING_YN = 'Y' " +
                         "WHERE NO = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, no);

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

    // 대여
    public int insertRentalInfo(int bookNo, int loginedUserNo) {
        Connection conn         = null;
        PreparedStatement pstmt = null;
        int result = -1;

        try {
            Class.forName(BookDBConfig.DB_DRIVER_NAME);
            conn = DriverManager.getConnection( BookDBConfig.DB_URL,
                    BookDBConfig.DB_USER,
                    BookDBConfig.DB_PW);

            String sql = "INSERT INTO RENTAL(USER_NO, BOOK_NO, CREATED_AT, FINISHED_DATE) " +
                         "VALUES (?, ?, SYSDATE, SYSDATE + 7)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, loginedUserNo);
            pstmt.setInt(2, bookNo);

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

    // 한사람당 최대 2권 대여 가능
    public int selectRentalCount(int loginedUserNo) {
        Connection conn         = null;
        PreparedStatement pstmt = null;
        ResultSet rs            = null;
        int result              = -1;
        try {
            Class.forName(BookDBConfig.DB_DRIVER_NAME);
            conn = DriverManager.getConnection( BookDBConfig.DB_URL,
                    BookDBConfig.DB_USER,
                    BookDBConfig.DB_PW);

            String sql = "SELECT COUNT(*) AS CNT FROM RENTAL " +
                         "WHERE USER_NO = ? AND FINISHED_AT IS NULL ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, loginedUserNo);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                result = rs.getInt("CNT");

            }

        } catch (Exception e){
            e.printStackTrace();

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

    // 대여 리스트 조회
    public List<RentalDto> selectRentalList(int userNo) {
        Connection conn         = null;
        PreparedStatement pstmt = null;
        ResultSet rs            = null;
        List<RentalDto> rentalDtos = new ArrayList<>();

        try {
            Class.forName(BookDBConfig.DB_DRIVER_NAME);
            conn = DriverManager.getConnection( BookDBConfig.DB_URL,
                    BookDBConfig.DB_USER,
                    BookDBConfig.DB_PW);

            String sql = "select R.NO, UT.NAME, B.TITLE, TO_CHAR(R.CREATED_AT, 'yyyy-mm-dd') AS CREATED_AT, TO_CHAR(R.FINISHED_DATE, 'yyyy-mm-dd') AS FINISHED_DATE, EXTENSION_YN " +
                         "from rental R " +
                         "JOIN USER_TABLE UT ON R.USER_NO = UT.NO " +
                         "JOIN BOOK B ON R.BOOK_NO = B.NO " +
                         "WHERE USER_NO = ? AND FINISHED_AT IS NULL " +
                         "ORDER BY R.NO ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userNo);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                rentalDtos.add(
                        new RentalDto(
                                rs.getInt("NO"),
                                rs.getString("NAME"),
                                rs.getString("TITLE"),
                                rs.getString("CREATED_AT"),
                                rs.getString("FINISHED_DATE"),
                                rs.getString("EXTENSION_YN")

                        )
                );

            }

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
        return rentalDtos;

    }

    // EXTENSION 가능 여부 확인
    public boolean selectExtensionYn(int no) {
        Connection conn         = null;
        PreparedStatement pstmt = null;
        ResultSet rs            = null;
        String extensionYn = null;

        try {
            Class.forName(BookDBConfig.DB_DRIVER_NAME);
            conn = DriverManager.getConnection( BookDBConfig.DB_URL,
                    BookDBConfig.DB_USER,
                    BookDBConfig.DB_PW);

            String sql = "SELECT EXTENSION_YN FROM RENTAL WHERE NO = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, no);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                extensionYn = rs.getString("EXTENSION_YN");

            }

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
        return (extensionYn.equalsIgnoreCase("Y")) ? true : false;
    }

    // 대여 기간 연장
    public int updateExtensionDue(int no) {
        Connection conn         = null;
        PreparedStatement pstmt = null;
        int result              = -1;

        try {
            Class.forName(BookDBConfig.DB_DRIVER_NAME);
            conn = DriverManager.getConnection( BookDBConfig.DB_URL,
                    BookDBConfig.DB_USER,
                    BookDBConfig.DB_PW);

            String sql = "UPDATE RENTAL SET FINISHED_DATE = CREATED_AT + 14, EXTENSION_YN = 'N' " +
                         "WHERE NO = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, no);

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

    // 반납
    public int updateFinishedAt(int no) {
        Connection conn         = null;
        PreparedStatement pstmt = null;
        int result              = -1;

        try {
            Class.forName(BookDBConfig.DB_DRIVER_NAME);
            conn = DriverManager.getConnection( BookDBConfig.DB_URL,
                    BookDBConfig.DB_USER,
                    BookDBConfig.DB_PW);

            String sql = "UPDATE RENTAL SET FINISHED_AT = SYSDATE " +
                         "WHERE NO = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, no);

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

    // 반납할 책 번호 가져오기
    public int selectNoForReturn(int no) {
        Connection conn         = null;
        PreparedStatement pstmt = null;
        ResultSet rs            = null;
        int book_no             = 0;

        try {
            Class.forName(BookDBConfig.DB_DRIVER_NAME);
            conn = DriverManager.getConnection( BookDBConfig.DB_URL,
                    BookDBConfig.DB_USER,
                    BookDBConfig.DB_PW);

            String sql = "SELECT BOOK_NO FROM RENTAL " +
                         "WHERE NO = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, no);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                book_no = rs.getInt("BOOK_NO");

            }

        } catch (Exception e){
            e.printStackTrace();

        }finally {
            try{
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();

            }catch (Exception e) {
                e.printStackTrace();

            }

        }
        return book_no;

    }

    // 반납 시 BOOKING_YN 값 = 'N'으로 변경
    public int updateBookingYnByReturn(int no) {
        Connection conn         = null;
        PreparedStatement pstmt = null;
        int result              = -1;

        try {
            Class.forName(BookDBConfig.DB_DRIVER_NAME);
            conn = DriverManager.getConnection( BookDBConfig.DB_URL,
                    BookDBConfig.DB_USER,
                    BookDBConfig.DB_PW);

            String sql = "UPDATE BOOK SET BOOKING_YN = 'N' " +
                         "WHERE NO = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, no);

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

    // 연체테이블 USER_NO 조회
    public List<RentalDto> selectOverdue(int loginedUserNo) {
        Connection conn         = null;
        PreparedStatement pstmt = null;
        ResultSet rs            = null;
        List<RentalDto> rentalDtos = new ArrayList<>();

        try {
            Class.forName(BookDBConfig.DB_DRIVER_NAME);
            conn = DriverManager.getConnection( BookDBConfig.DB_URL,
                                                BookDBConfig.DB_USER,
                                                BookDBConfig.DB_PW);

            String sql = "SELECT O.NO, TO_CHAR(OVERDUE_DATE, 'yyyy-mm-dd') AS OVERDUE_DATE " +
                         "FROM OVERDUE O " +
                         "WHERE R_NO IN (SELECT R.NO FROM RENTAL R WHERE USER_NO = ?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, loginedUserNo);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                rentalDtos.add(
                        new RentalDto(
                                rs.getInt("NO"),
                                rs.getString("OVERDUE_DATE")

                        )
                );

            }

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
            return rentalDtos;

    }

    // 연체테이블에 값이 있을 때 대여
    public int insertRentalInfoExistOverdue(int bookNo, int loginedUserNo, String overdueDate) {
        Connection conn         = null;
        PreparedStatement pstmt = null;
        int result              = -1;

        try {
            Class.forName(BookDBConfig.DB_DRIVER_NAME);
            conn = DriverManager.getConnection( BookDBConfig.DB_URL,
                    BookDBConfig.DB_USER,
                    BookDBConfig.DB_PW);

            String sql = "INSERT INTO RENTAL(USER_NO, BOOK_NO, CREATED_AT, FINISHED_DATE) " +
                         "SELECT ?, ?, SYSDATE, SYSDATE + 7 " +
                         "FROM OVERDUE " +
                         "WHERE OVERDUE_DATE < SYSDATE ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, loginedUserNo);
            pstmt.setInt(2, bookNo);

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

    // 이달의 독서왕 조회
    public List<RentalDto> selectUserBookRanking() {
        Connection conn         = null;
        PreparedStatement pstmt = null;
        ResultSet rs            = null;
        int result              = -1;
        List<RentalDto> rentalDtos = new ArrayList<>();

        try {
            Class.forName(BookDBConfig.DB_DRIVER_NAME);
            conn = DriverManager.getConnection( BookDBConfig.DB_URL,
                                                BookDBConfig.DB_USER,
                                                BookDBConfig.DB_PW);

            String sql = "SELECT MAX(USER_NO) AS MAX, COUNT(USER_NO) AS CNT " +
                         "FROM RENTAL " +
                         "WHERE CREATED_AT BETWEEN TO_CHAR(TRUNC(SYSDATE, 'MM'), 'YYYY-MM-DD') AND TO_CHAR(LAST_DAY(SYSDATE), 'YYYY-MM-DD') " +
                         "GROUP BY USER_NO " +
                         "HAVING COUNT(USER_NO) IN (SELECT COUNT(USER_NO) AS CNT FROM RENTAL GROUP BY USER_NO)" ;

            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                rentalDtos.add(
                        new RentalDto(
                                rs.getInt("MAX"),
                                rs.getInt("CNT")
                        )
                );

            }

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
        return rentalDtos;

    }

    // 이달의 독서왕 사용자 정보
    public String selectUserInfo(int userNo) {
        Connection conn         = null;
        PreparedStatement pstmt = null;
        ResultSet rs            = null;
        String name             = null;

        try {
            Class.forName(BookDBConfig.DB_DRIVER_NAME);
            conn = DriverManager.getConnection( BookDBConfig.DB_URL,
                                                BookDBConfig.DB_USER,
                                                BookDBConfig.DB_PW);

            String sql = "SELECT NAME FROM USER_TABLE WHERE NO = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userNo);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                   name = rs.getString("NAME");

            }

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
        return name;
    }
}
