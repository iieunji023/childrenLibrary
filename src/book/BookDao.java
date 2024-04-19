package book;

import config.BookDBConfig;
import utils.BookDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    // 책 제목 검색(수정하기 위함)
    public List<BookDto> selectBookCountByTitle(String title) {
        Connection conn         = null;
        PreparedStatement pstmt = null;
        ResultSet rs            = null;

        List<BookDto> bookDtos = new ArrayList<>();

        try {
            Class.forName(BookDBConfig.DB_DRIVER_NAME);
            conn = DriverManager.getConnection( BookDBConfig.DB_URL,
                    BookDBConfig.DB_USER,
                    BookDBConfig.DB_PW);

            String sql = "SELECT " +
                                    "CATEGORY_NO, " +
                                    "TITLE, " +
                                    "AUTHOR, " +
                                    "PUBLISHER, " +
                                    "count(*) as enable_book " +
                         "FROM BOOK " +
                         "WHERE BOOKING_YN = 'N' " +
                         "AND " +
                         "TITLE LIKE ? " +
                         "GROUP BY CATEGORY_NO, TITLE, AUTHOR, PUBLISHER ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%" + title + "%");

            rs = pstmt.executeQuery();

            while (rs.next()) {
                int category_no = rs.getInt("CATEGORY_NO");
                String get_title = rs.getString("TITLE");
                String author = rs.getString("AUTHOR");
                String publisher = rs.getString("PUBLISHER");
                int count = rs.getInt("enable_book");

                bookDtos.add(
                        new BookDto(
                                category_no,
                                get_title,
                                author,
                                publisher,
                                count
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
        return bookDtos;

    }

    // 책 전체 조회
    public List<BookDto> selectAllBookInfo() {
        Connection conn         = null;
        PreparedStatement pstmt = null;
        ResultSet rs            = null;

        List<BookDto> bookDtos = new ArrayList<>();

        try {
            Class.forName(BookDBConfig.DB_DRIVER_NAME);
            conn = DriverManager.getConnection(BookDBConfig.DB_URL,
                    BookDBConfig.DB_USER,
                    BookDBConfig.DB_PW);

            String sql = "SELECT B.NO, B.CATEGORY_NO, B.TITLE, B.AUTHOR, B.PUBLISHER, B.BOOKING_YN, B.CREATED_AT, C.CLASSIFY " +
                         "FROM BOOK B JOIN CATEGORY C ON B.CATEGORY_NO = C.NO " +
                         "ORDER BY NO ";

            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int get_no = rs.getInt("NO");
                int category_no = rs.getInt("CATEGORY_NO");
                String title = rs.getString("TITLE");
                String author = rs.getString("AUTHOR");
                String publisher = rs.getString("PUBLISHER");
                String booking_yn = rs.getString("BOOKING_YN");
                String created_at = rs.getString("CREATED_AT");
                String classify = rs.getString("CLASSIFY");

                bookDtos.add(
                        new BookDto(
                                get_no,
                                category_no,
                                title,
                                author,
                                publisher,
                                booking_yn,
                                created_at,
                                classify
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
        return bookDtos;

    }

    // rental - 대여권수 조회
    public List<BookDto> selectBookInfoByTitle(String title) {
        Connection conn         = null;
        PreparedStatement pstmt = null;
        ResultSet rs            = null;

        List<BookDto> bookDtos = new ArrayList<>();

        try {
            Class.forName(BookDBConfig.DB_DRIVER_NAME);
            conn = DriverManager.getConnection( BookDBConfig.DB_URL,
                    BookDBConfig.DB_USER,
                    BookDBConfig.DB_PW);

            String sql = "SELECT B.NO, CATEGORY_NO, TITLE, AUTHOR, PUBLISHER, BOOKING_YN, CREATED_AT,C.CLASSIFY " +
                         "FROM BOOK B " +
                         "JOIN CATEGORY C ON B.CATEGORY_NO = C.NO " +
                         "WHERE TITLE LIKE ? " +
                         "ORDER BY B.NO ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%"+title+"%");

            rs = pstmt.executeQuery();

            while (rs.next()) {
                int no = rs.getInt("NO");
                int category_no = rs.getInt("CATEGORY_NO");
                String get_title = rs.getString("TITLE");
                String author = rs.getString("AUTHOR");
                String publisher = rs.getString("PUBLISHER");
                String booking_yn = rs.getString("BOOKING_YN");
                String created_at = rs.getString("CREATED_AT");
                String classify = rs.getString("CLASSIFY");

                bookDtos.add(
                        new BookDto(
                                no,
                                category_no,
                                get_title,
                                author,
                                publisher,
                                booking_yn,
                                created_at,
                                classify
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
        return bookDtos;

    }

    // FINISHED_AT(실제 반납일) - FINISHED_DATE(반납 예정일) 구하기
    public List<RentalDto> selectOverdueDate(int u_no) {
        Connection conn         = null;
        PreparedStatement pstmt = null;
        ResultSet rs            = null;
        List<RentalDto> overDue = new ArrayList<>();

        try {
            Class.forName(BookDBConfig.DB_DRIVER_NAME);
            conn = DriverManager.getConnection( BookDBConfig.DB_URL,
                    BookDBConfig.DB_USER,
                    BookDBConfig.DB_PW);

            String sql = "SELECT NO, FINISHED_AT, (TO_date(FINISHED_AT, 'yyyy-mm-dd') - TO_date(FINISHED_DATE, 'yyyy-mm-dd')) AS OVERDUE " +
                         "FROM RENTAL " +
                         "WHERE USER_NO = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, u_no);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                overDue.add(
                                new RentalDto(
                                        rs.getInt("NO"),
                                        rs.getString("FINISHED_AT"),
                                        rs.getString("OVERDUE")
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
        return overDue;
    }

    // 연체 테이블 INSERT
    public int insertOverdue(int rNo, String finisedDate, String overDueDate) {
        Connection conn         = null;
        PreparedStatement pstmt = null;
        int result              = -1;
        List<RentalDto> overDue = new ArrayList<>();

        try {
            Class.forName(BookDBConfig.DB_DRIVER_NAME);
            conn = DriverManager.getConnection( BookDBConfig.DB_URL,
                                                BookDBConfig.DB_USER,
                                                BookDBConfig.DB_PW);

            String sql = "INSERT INTO OVERDUE (R_NO, OVERDUE_DATE) " +
                         "(SELECT r.NO, (r.FINISHED_AT + ?) AS VANDATE FROM RENTAL r WHERE r.NO = ?) ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, overDueDate);
            pstmt.setInt(2, rNo);

            result = pstmt.executeUpdate();

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

    // OVERDUE 테이블에 r_no 값 존재하는지 여부
    public boolean selectRNoForOverdue(int rNo) {
        Connection conn         = null;
        PreparedStatement pstmt = null;
        ResultSet rs            = null;
        int result              = -1;

        try {
            Class.forName(BookDBConfig.DB_DRIVER_NAME);
            conn = DriverManager.getConnection( BookDBConfig.DB_URL,
                                                BookDBConfig.DB_USER,
                                                BookDBConfig.DB_PW);

            String sql = "SELECT R_NO FROM OVERDUE WHERE R_NO = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, rNo);

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
        return (result > 0) ? true : false ;

    }

    // FINISHED_AT = NULL일 때 FINISHED_DATE(반납예정일)과 오늘날짜 비교
    public List<RentalDto> selectOverdueDateByNull(int u_no) {
        Connection conn         = null;
        PreparedStatement pstmt = null;
        ResultSet rs            = null;
        List<RentalDto> overDue = new ArrayList<>();

        try {
            Class.forName(BookDBConfig.DB_DRIVER_NAME);
            conn = DriverManager.getConnection( BookDBConfig.DB_URL,
                    BookDBConfig.DB_USER,
                    BookDBConfig.DB_PW);

            String sql = "SELECT NO, FINISHED_AT, (TO_date(SYSDATE, 'yyyy-mm-dd') - TO_date(FINISHED_DATE, 'yyyy-mm-dd')) AS OVERDUE " +
                         "FROM RENTAL " +
                         "WHERE USER_NO = ? AND FINISHED_AT IS NULL ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, u_no);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                overDue.add(
                        new RentalDto(
                                rs.getInt("NO"),
                                rs.getString("FINISHED_AT"),
                                rs.getString("OVERDUE")
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
        return overDue;

    }

    // 연체테이블 INSERT (FINISHED_AT이 NULL일때)
    public int insertOverdueByNull(int rNo, String overdueDate) {
        Connection conn         = null;
        PreparedStatement pstmt = null;
        int result              = -1;
        List<RentalDto> overDue = new ArrayList<>();

        try {
            Class.forName(BookDBConfig.DB_DRIVER_NAME);
            conn = DriverManager.getConnection( BookDBConfig.DB_URL,
                                                BookDBConfig.DB_USER,
                                                BookDBConfig.DB_PW);

            String sql = "INSERT INTO OVERDUE (R_NO, OVERDUE_DATE) " +
                         "(SELECT r.NO, (SYSDATE + ?) AS VANDATE FROM RENTAL r WHERE r.NO = ?) ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, overdueDate);
            pstmt.setInt(2, rNo);

            result = pstmt.executeUpdate();

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

    // 연체 테이블 삭제
    public int updateOverdueReturnYn(int no) {
        Connection conn         = null;
        PreparedStatement pstmt = null;
        int result              = -1;
        List<RentalDto> overDue = new ArrayList<>();

        try {
            Class.forName(BookDBConfig.DB_DRIVER_NAME);
            conn = DriverManager.getConnection( BookDBConfig.DB_URL,
                    BookDBConfig.DB_USER,
                    BookDBConfig.DB_PW);

            String sql = "UPDATE OVERDUE SET RETURN_YN = 'Y' " +
                         "WHERE R_NO = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, no);

            result = pstmt.executeUpdate();

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
}
