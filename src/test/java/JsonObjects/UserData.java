package JsonObjects;

public class UserData {
    public UserData(String id, String email, String first_name, String last_name, String avatar) {
        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }

    private String id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;


    public String GetId() {
        return id;
    }

    public String GetEmail() {
        return email;
    }

    public String GetFirst_name() {
        return first_name;
    }

    public String GetLast_name() {
        return last_name;
    }

    public String GetAvatar() {
        return avatar;
    }
}
