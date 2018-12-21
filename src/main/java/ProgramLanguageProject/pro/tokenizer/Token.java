/*
 * Copyright(C) 2018 Bùi Trung Hiếu
 * ProgramLanguageCompiler, ProgramLanguageProject.pro - IntelliJ IDEA
 * Token.java
 * Created at 13:46 ~ 26/11/2018 by Bùi Trung Hiếu
 */
package ProgramLanguageProject.pro.tokenizer;

/**
 * A token in code
 *
 * @author Bùi Trung Hiếu  Created: 13:46 ~ 26/11/2018
 */
public class Token {
    private String token;
    private TokenType type;

    public Token(String token, TokenType type) {
        this.token = token;
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public TokenType getType() {
        return type;
    }
}
