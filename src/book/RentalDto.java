package book;

public class RentalDto {
    int no;
    int user_no;
    int book_no;
    String created_at;
    String finished_date;
    String finished_at;
    String extension_yn;

    String name;
    String title;

    String overDueDate;

    int count;

    public RentalDto(int user_no, int count) {
        this.count = count;
        this.user_no = user_no;
    }

    public RentalDto(int no, int user_no, int book_no, String created_at, String finished_date, String finished_at, String name, String title) {
        this.no = no;
        this.user_no = user_no;
        this.book_no = book_no;
        this.created_at = created_at;
        this.finished_date = finished_date;
        this.finished_at = finished_at;
        this.name = name;
        this.title = title;
    }

    public RentalDto(int no,  String name, String title, String created_at, String finished_date, String extension_yn) {
        this.no = no;
        this.created_at = created_at;
        this.finished_date = finished_date;
        this.name = name;
        this.title = title;
        this.extension_yn = extension_yn;

    }

    public RentalDto(int no, String finished_date, String overDueDate) {
        this.no = no;
        this.finished_date = finished_date;
        this.overDueDate = overDueDate;
    }

    public RentalDto(int no, String overDueDate) {
        this.no = no;
        this.overDueDate = overDueDate;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getUser_no() {
        return user_no;
    }

    public void setUser_no(int user_no) {
        this.user_no = user_no;
    }

    public int getBook_no() {
        return book_no;
    }

    public void setBook_no(int book_no) {
        this.book_no = book_no;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getFinished_date() {
        return finished_date;
    }

    public void setFinished_date(String finished_date) {
        this.finished_date = finished_date;
    }

    public String getFinished_at() {
        return finished_at;
    }

    public void setFinished_at(String finished_at) {
        this.finished_at = finished_at;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExtension_yn() {
        return extension_yn;
    }

    public void setExtension_yn(String extension_yn) {
        this.extension_yn = extension_yn;
    }

    public String getOverDueDate() {
        return overDueDate;
    }

    public void setOverDueDate(String overDueDate) {
        this.overDueDate = overDueDate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
