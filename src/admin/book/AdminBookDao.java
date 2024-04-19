package admin.book;

import config.BookDBConfig;
import utils.BookDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdminBookDao {
    /*
     * 책 등록 METHOD
     */
    public int insertBookInfo(BookDto bookDto) {
        Connection conn         = null;
        PreparedStatement pstmt = null;
        int result              = -1;       // 1, 0을 준다는 것은 db에 접속을 했다는 의미. -1은 db 접속 오류!

        try {
            Class.forName(BookDBConfig.DB_DRIVER_NAME);
            conn = DriverManager.getConnection(BookDBConfig.DB_URL,
                                               BookDBConfig.DB_USER,
                                               BookDBConfig.DB_PW);

            String sql = "INSERT INTO BOOK(CATEGORY_NO, TITLE, AUTHOR, PUBLISHER, CREATED_AT) " +
                         "VALUES (?, ?, ?, ?, SYSDATE)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bookDto.getCategory_no());
            pstmt.setString(2, bookDto.getTitle());
            pstmt.setString(3, bookDto.getAuthor());
            pstmt.setString(4, bookDto.getPublisher());

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

    // null 값일떄, 기존값을 넣기 위해 db에서 select해옴
    public List<BookDto> selectBookInfoByNo(int no) {
        Connection conn         = null;
        PreparedStatement pstmt = null;
        ResultSet rs            = null;

        List<BookDto> bookDtos = new ArrayList<>();

        try {
            Class.forName(BookDBConfig.DB_DRIVER_NAME);
            conn = DriverManager.getConnection(BookDBConfig.DB_URL,
                    BookDBConfig.DB_USER,
                    BookDBConfig.DB_PW);

            String sql = "SELECT * FROM BOOK " +
                         "WHERE NO = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, no);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                int get_no = rs.getInt("NO");
                int category_no = rs.getInt("CATEGORY_NO");
                String title = rs.getString("TITLE");
                String author = rs.getString("AUTHOR");
                String publisher = rs.getString("PUBLISHER");
                String booking_yn = rs.getString("BOOKING_YN");
                String created_at = rs.getString("CREATED_AT");

                bookDtos.add(
                        new BookDto(
                                get_no,
                                category_no,
                                title,
                                author,
                                publisher,
                                booking_yn,
                                created_at
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

    // 책 정보 수정
    public int updateBookInfo(BookDto bookDto) {
        Connection conn         = null;
        PreparedStatement pstmt = null;
        int result              = -1;

        List<BookDto> bookDtos = new ArrayList<>();

        try {
            Class.forName(BookDBConfig.DB_DRIVER_NAME);
            conn = DriverManager.getConnection(BookDBConfig.DB_URL,
                    BookDBConfig.DB_USER,
                    BookDBConfig.DB_PW);

            String sql = "UPDATE BOOK SET CATEGORY_NO = ?, TITLE = ?, AUTHOR = ?, PUBLISHER = ? " +
                         "WHERE NO = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bookDto.getCategory_no());
            pstmt.setString(2, bookDto.getTitle());
            pstmt.setString(3, bookDto.getAuthor());
            pstmt.setString(4, bookDto.getPublisher());
            pstmt.setInt(5, bookDto.getNo());

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

    // 책 삭제
    public int deleteBookInfo(int no) {
        Connection conn         = null;
        PreparedStatement pstmt = null;
        int result              = -1;

        try {
            Class.forName(BookDBConfig.DB_DRIVER_NAME);
            conn = DriverManager.getConnection(BookDBConfig.DB_URL,
                    BookDBConfig.DB_USER,
                    BookDBConfig.DB_PW);

            String sql = "DELETE FROM BOOK " +
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
}
