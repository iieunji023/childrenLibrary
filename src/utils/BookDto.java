package utils;

public class BookDto {
    private int no ;
    private int category_no;
    private String title;
    private String author;
    private String publisher;
    private String booking_yn;
    private String created_at;
    private int count;
    private String classify;

    public BookDto(int NO, int CATEGORY_NO, String TITLE, String AUTHOR, String PUBLISHER, String BOOKING_YN, String CREATED_AT) {
        this.no = NO;
        this.category_no = CATEGORY_NO;
        this.title = TITLE;
        this.author = AUTHOR;
        this.publisher = PUBLISHER;
        this.booking_yn = BOOKING_YN;
        this.created_at = CREATED_AT;
    }

    public BookDto(int NO, int CATEGORY_NO, String TITLE, String AUTHOR, String PUBLISHER, String BOOKING_YN, String CREATED_AT, String classify) {
        this.no = NO;
        this.category_no = CATEGORY_NO;
        this.title = TITLE;
        this.author = AUTHOR;
        this.publisher = PUBLISHER;
        this.booking_yn = BOOKING_YN;
        this.created_at = CREATED_AT;
        this.classify = classify;
    }

    public BookDto(int CATEGORY_NO, String TITLE, String AUTHOR, String PUBLISHER) {
        this.category_no = CATEGORY_NO;
        this.title = TITLE;
        this.author = AUTHOR;
        this.publisher = PUBLISHER;
    }

    public BookDto(int no, int category_no, String title, String author, String publisher) {
        this.no = no;
        this.category_no = category_no;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    public BookDto(int category_no, String title, String author, String publisher, int count) {
        this.category_no = category_no;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.count = count;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getCategory_no() {
        return category_no;
    }

    public void setCategory_no(int category_no) {
        this.category_no = category_no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getBooking_yn() {
        return booking_yn;
    }

    public void setBooking_yn(String booking_yn) {
        this.booking_yn = booking_yn;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }
}
