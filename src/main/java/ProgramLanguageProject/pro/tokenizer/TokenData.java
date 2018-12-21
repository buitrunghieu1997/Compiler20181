/*
 * Copyright(C) 2018 Bùi Trung Hiếu
 * ProgramLanguageCompiler, ProgramLanguageProject.pro - IntelliJ IDEA
 * TokenData.java
 * Created at 13:46 ~ 26/11/2018 by Bùi Trung Hiếu
 */
package ProgramLanguageProject.pro.tokenizer;

import java.util.regex.Pattern;

/**
 * BuildInType and Regex of token
 *
 * @author Bùi Trung Hiếu  Created: 13:46 ~ 26/11/2018
 */
public class TokenData {
    private Pattern pattern;
    private TokenType type;

    public TokenData(Pattern pattern, TokenType type) {
        this.pattern = pattern;
        this.type = type;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public TokenType getType() {
        return type;
    }
}
