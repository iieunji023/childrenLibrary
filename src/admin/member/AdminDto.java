package admin.member;

public class AdminDto {
    private int no;
    private String id;
    private String pw;
    private String name;
    private String phone;
    private String created_at;

    public AdminDto(int no, String id, String pw, String name, String phone, String created_at) {
        this.no = no;
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.phone = phone;
        this.created_at = created_at;
    }

    /*
     * private으로 되어있기 떄문에 다른 곳에서 객체를 생성해도 불러올 수 없음.
     * 이때 GETTER&SETTER라는 메서드를 통해 리턴값으로 해당 변수를 받아오기 때문에 접근할 수 있다.
     */
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
