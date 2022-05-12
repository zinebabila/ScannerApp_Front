package scanner.projet.model.bo;

public class JwtResponse {

    private Account user;
    private String jwtToken;

    public JwtResponse(Account user, String jwtToken) {
        this.user = user;
        this.jwtToken = jwtToken;
    }

    public Account getUser() {
        return user;
    }

    public void setUser(Account user) {
        this.user = user;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
