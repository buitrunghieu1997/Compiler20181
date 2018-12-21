/*
 * Copyright(C) 2018 Bùi Trung Hiếu
 * ProgramLanguageCompiler, ProgramLanguageProject.pro - IntelliJ IDEA
 * Constants.java
 * Created at 14:55 ~ 26/11/2018 by Bùi Trung Hiếu
 */
package ProgramLanguageProject.pro.utils;

/**
 * Description about this Class/Interface/Enum...
 *
 * @author Bùi Trung Hiếu  Created: 14:55 ~ 26/11/2018
 */
public class Constants {
    //Tokenizer - ^ nghĩa là bắt đầu bằng, mỗi lần xong cắt đi 1 token, nếu next token k thoả mãn thì có nghĩa là viết sai định dạng
    public static final String IDENTIFIER_PATTERN = "^([a-zA-z][a-zA-z0-9]*)";
    public static final String INTEGER_LITERAL_PATTERN = "^((-)?[0-9]+)";
    public static final String STRING_LITERAL_PATTERN = "^(\".*\")";
    public static final String EQUAL_PATTERN = "^(=)";
    public static final String OPENING_PARENTHESIS_PATTERN = "^(\\()";
    public static final String CLOSING_PARENTHESIS_PATTERN = "^(\\))";
    public static final String DOT_PATTERN = "^(\\.)";
    public static final String COMMA_PATTERN = "^(\\,)";
    public static final String EMPTY_PATTERN = "";

    //Parser
    public static final String CLASS_PARSER_PATTERN = "class [a-zA-Z][a-zA-Z0-9]*";
    public static final String METHOD_PARSER_PATTERN = "method [a-zA-Z][a-zA-z0-9]* require \\(([a-zA-Z][a-zA-z0-9]* [a-zA-Z][a-zA-z0-9]*)*\\) return [a-zA-Z][a-zA-z0-9]*";
  public static final String VARIABLE_PARSER_PATTERN =
      "var [a-zA-z]+ [a-zA-Z]+ = ([a-zA-Z0-9]+|(\").*(\"))"; // check lại regex này
}
