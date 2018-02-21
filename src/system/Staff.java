package system;

public class Staff {
    private String staffUsername;
    private String staffPw;

    Staff(String username, String pw){
        staffUsername = username;
        staffPw = pw;
    }

    public String getUsername(){
        return staffUsername;
    }

    public String getPw() {
        return staffPw;
    }
}
