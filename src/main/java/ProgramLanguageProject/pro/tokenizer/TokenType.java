/*
 * Copyright(C) 2018 Bùi Trung Hiếu
 * ProgramLanguageCompiler, ProgramLanguageProject.pro - IntelliJ IDEA
 * TokenType.java
 * Created at 13:46 ~ 26/11/2018 by Bùi Trung Hiếu
 */
package ProgramLanguageProject.pro.tokenizer;

/**
 * BuildInType of token
 *
 * @author Bùi Trung Hiếu  Created: 13:46 ~ 26/11/2018
 */
public enum TokenType {
    // Have nothing
    EMPTY,
    // a token eg `() =` -> Một từ khoá
    TOKEN,
    // Một định danh (tên biến hàm), bắt đầu bằng 1 chữ cái, sau đó có thể là chữ or số
    IDENTIFIER,
    // một số
    INTEGER_LITERAL,
    // một string trong dấu ""
    STRING_LITERAL;
}
