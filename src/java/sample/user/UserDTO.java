package sample.user;

public class UserDTO {

    private String userID;
    private int password;
    private String fullName;
    private int role;

    public UserDTO() {
    }

    public UserDTO(String userID, String fullName, int role) {
        this.userID = userID;
        this.password = 0;
        this.fullName = fullName;
        this.role = role;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

}
