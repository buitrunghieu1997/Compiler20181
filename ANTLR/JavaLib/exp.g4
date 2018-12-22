//Bộ biên dịch cho một ngôn ngữ đơn giản
grammar exp;
// Root là kí hiệu chưa kết thúc
// Chương trình là một loạt các khai báo theo sau là một loạt các câu lệnh
// Mã Java xuất ra mã NASM cần thiết xung quanh các khai báo này
start       : 
              declaration*
              statement*
              ;
// Quy tắc phân tích biến declarations
declaration   : 
              INT NAME SEMICOLON 
              ;
// Quy tắc phân tích biến statements
statement      : 
               ifstmt 
             | printstmt 
             | assignstmt 
               ;
// Quy tắc phân tích trạng thái if
ifstmt      : 
            IF LPAREN identifier EQUAL integer RPAREN
            statement*
            ENDIF
            ;
// Quy tắc phân tích việc in trạng thái
printstmt      : 
               PRINT term SEMICOLON 
             ;
// Quy tắc phân tích trạng thái assignment 
assignstmt      : 
                NAME ASSIGN expression SEMICOLON 
                ;
// Quy tắc phân tích expressions
expression      : 
                term
              | term PLUS term   ;
// Quy tắc phân tích terms
term          : 
              identifier
            | integer     ;
// Quy tắc phân tích identifiers
identifier   : NAME  ;
// Quy tắc phân tích numbers 
integer      : INTEGER  ;
// Reserved Keywords
////////////////////////////////
IF: 'if';
ENDIF: 'endif';
PRINT: 'print';
INT: 'int';
// Toán tử
PLUS: '+';
EQUAL: '==';
ASSIGN: '=';
NOTEQUAL: '!=';
// Dấu chấm phẩy và dấu ngoặc đơn
SEMICOLON: ';';
LPAREN: '(';
RPAREN: ')';
// Số nguyên
INTEGER: [0-9][0-9]*;
// Tên biến
NAME: [a-z]+;   
// Bỏ qua tất cả các khoảng trắng
WS: [ \t\r\n]+ -> skip ; 
