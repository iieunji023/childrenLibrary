package user.member;

public class UserDto {
    private int no;
    private String id;
    private String pw;
    private String name;
    private String phone;
    private String address;
    private String created_at;

    public UserDto(int no, String id, String pw, String name, String phone, String address, String created_at) {
        this.no = no;
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.created_at = created_at;
    }

    public UserDto(int no, String id, String name, String phone, String address, String created_at) {
        this.no = no;
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.created_at = created_at;

    }

    public UserDto(String id, String pw, String name, String phone, String address) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public UserDto(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    public UserDto(String id, String pw, String name, String phone, String address, String created_at) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.created_at = created_at;
    }

    public UserDto(String pw, String name, String phone, String address) {
        this.pw = pw;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
