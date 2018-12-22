/*
 * Copyright(C) 2018 Bùi Trung Hiếu
 * ProgramLanguageCompiler, ProgramLanguageProject - IntelliJ IDEA
 * tokenizer.java
 * Created at 13:45 ~ 26/11/2018 by Bùi Trung Hiếu
 */
package main.java.ProgramLanguageProject.pro.tokenizer;

import main.java.ProgramLanguageProject.pro.utils.Constants;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Class chứa các xử lý token
 *
 * @author Bùi Trung Hiếu  Created: 13:46 ~ 26/11/2018
 */
public class Tokenizer {
  private ArrayList<TokenData> tokenData;
  private String str;
  private Token lastToken;
  private boolean pushBack;

  /**
   * Instantiates a new tokenizer.
   *
   * @param str the str
   */
  public Tokenizer(String str) {
    this.tokenData = new ArrayList<>();
    this.str = str;

    tokenData.add(
        new TokenData(Pattern.compile(Constants.IDENTIFIER_PATTERN), TokenType.IDENTIFIER));
    tokenData.add(
        new TokenData(
            Pattern.compile(Constants.INTEGER_LITERAL_PATTERN), TokenType.INTEGER_LITERAL));
    tokenData.add(
        new TokenData(Pattern.compile(Constants.STRING_LITERAL_PATTERN), TokenType.STRING_LITERAL));

    for (String t :
        new String[] {
          Constants.EQUAL_PATTERN,
          Constants.OPENING_PARENTHESIS_PATTERN,
          Constants.CLOSING_PARENTHESIS_PATTERN,
          Constants.DOT_PATTERN,
          Constants.COMMA_PATTERN
        }) {
      tokenData.add(new TokenData(Pattern.compile(t), TokenType.TOKEN));
    }
  }

  /**
   * Next token token.
   *
   * @return the token
   */
  public Token nextToken() {
    str = str.trim();

    if (pushBack) {
      pushBack = false;
      return lastToken;
    }

    if (str.isEmpty()) {
      return (lastToken = new Token(Constants.EMPTY_PATTERN, TokenType.EMPTY));
    }

    for (TokenData data : tokenData) {
      Matcher matcher = data.getPattern().matcher(str);
      if (matcher.find()) {
        String token = matcher.group().trim();
        // Sau khi lấy được token thì xoá nó khỏi String
        str = matcher.replaceFirst("");

        // Nếu là String thì bỏ "" ở hai đầu đi
        if (data.getType() == TokenType.STRING_LITERAL) {
          return (lastToken =
              new Token(token.substring(1, token.length() - 1), TokenType.STRING_LITERAL));
        } else {
          return (lastToken = new Token(token, data.getType()));
        }
      }
    }
    throw new IllegalStateException("Could not parse " + str);
  }

  /**
   * Has next token boolean.
   *
   * @return the boolean
   */
  public boolean hasNextToken() {
    return !str.isEmpty();
  }

  /** Push back. */
  public void pushBack() {
    if (lastToken != null) {
      this.pushBack = true;
    }
  }
}
