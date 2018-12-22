// Phần 1: User code - code to include, mỗi phần được ngăn cách bằng % %
package lexial;

import java.io.*;

// Phần 2: options and declarations: gồm Các options về tên class, mã hoá ký tự, public private,... và macro (hiểu là tên gọi đại diện của biểu thức chính quy)
%%

%{
    /**
     * Đổi chữ cái đầu tiên thành in hoa
     * @param s chữ đầu vào
     * @return chữ đầu ra vs ký tự đầu viết hoa
     */
    public static String capitalize(String s) {
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }
%}

// class được gen ra sẽ là pubilc có tên là Sentence và kiểu void hỗ trợ unicode
%public
%class Sentence
%type Void
%unicode

%init{
    yybegin(FIRST); // khởi tạo trạng thái ban đầu là FIRST
%init}

//macro
letter = [A-Za-z]
word = {letter}+
endPunct = [\.\!\?]
otherPunct = [\,\;\:]
space = [\ \t\r\n]
cypher = (\*\*\[.+\]\{[1-9][0-9]*\}#) //mã hoá
rev = (\$\$\[.+\]#) // đảo ngược
emp = (@@\[.+\]#) // viết tắt
rm = (\-\-\[.+\]#) // loại bỏ
author = (#author=\[[a-zA-Z][a-zA-Z0-9_\-]*\]#)
date = (&include\(date\)#)
time = (&include\(time\)#)
endf = (###)

// các trạng thái
%state FIRST, MID, END

// Phần 3: Lexial Rule: Các rule quy định từ vựng
%%
<FIRST> { // Xét trạng thái đầu:
    {word} { // Nếu match vs biểu thứu của word thì (bắt đầu của 1 câu phải là 1 từ
      	System.out.println("FIST_WORD: " + capitalize(yytext())); // yytext() trả về input match vs word
      	yybegin(MID); // chuyển sang trạng thái MID
      }

    {space} {
      	System.out.println("SPACE");
      }
}

<MID> {
    {word} {
      	System.out.println("REST_WORD: " + yytext()); // in ra các từ khớp kèm theo 1 dấu cách
      }

    {endPunct} {
      	System.out.println("END_SEN: " + yytext()); // gặp chấm hết câu
      	yybegin(FIRST); // quay lại trạng thái đầu (của câu mới)
      }

    {otherPunct} {
      	System.out.println("OTHER_PUNCT: " + yytext());
      }

    {cypher} {
      	System.out.println("CYPHER: " + yytext());
      }

    {rev} {
      	System.out.println("REV: " + yytext());
      }

    {emp} {
      	System.out.println("EMP: " + yytext());
      }

    {rm} {
      	System.out.println("RM: " + yytext());
      }

    {space} {
        System.out.println("SPACE");
      }
    }

    {endf} {
      	System.out.println("END OF MID");
      	yybegin(END);
      }

<END> {
    {space} {
      	System.out.println("SPACE");
      }

    {author} {
        System.out.println("AUTHOR");
      }

    {date} {
      	System.out.println("DATE: " + yytext());
      }

    {time} {
      	System.out.println("TIME: " + yytext());
      }

    . { // các trường hợp còn lại
      	System.out.println("Invalid character: \"" + yytext() + "\"");
      }
    }