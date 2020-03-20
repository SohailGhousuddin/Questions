package test;

import java.util.Objects;

public class Token {
    private String token;
    private int tokenLength;

    public Token(String token, int tokenLength) {
        this.token = token;
        this.tokenLength = tokenLength;
    }


    public Token() { }



    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getTokenLength() {
        return tokenLength;
    }

    public void setTokenLength(int tokenLength) {
        this.tokenLength = tokenLength;
    }
}
