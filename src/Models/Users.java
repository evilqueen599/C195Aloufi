package Models;

public class Users {

    /**
     *@ declarations for user class
     */

    private int userId;

    private String userName;

    private String password;

    /**
     *@ getters and setters for user class
     */

    public int getUserId(){
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users (String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

}