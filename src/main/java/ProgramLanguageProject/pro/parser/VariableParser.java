/*
 * Copyright(C) 2018 Bùi Trung Hiếu
 * ProgramLanguageCompiler, ProgramLanguageProject.pro.parser - IntelliJ IDEA
 * VariableParser.java
 * Created at 18:35 ~ 27/11/2018 by Bùi Trung Hiếu
 */
package ProgramLanguageProject.pro.parser;

import ProgramLanguageProject.pro.BuildInType;
import ProgramLanguageProject.pro.Type;
import ProgramLanguageProject.pro.Variable;
import ProgramLanguageProject.pro.block.Block;
import ProgramLanguageProject.pro.block.VariableBlock;
import ProgramLanguageProject.pro.tokenizer.Token;
import ProgramLanguageProject.pro.tokenizer.TokenType;
import ProgramLanguageProject.pro.tokenizer.Tokenizer;
import ProgramLanguageProject.pro.utils.Constants;

/**
 * Description about this Class/Interface/Enum...
 *
 * @author Bùi Trung Hiếu  Created: 18:35 ~ 27/11/2018
 */
public class VariableParser extends Parser<Block> {
    // check lại regex ở đây
    @Override public boolean shouldParse(String line) {
        return line.matches(Constants.VARIABLE_PARSER_PATTERN);
    }
    //var (1) String (2) string (3) = (4) " (5) Hello I Love u (6) " (7)
    @Override public Block parse(Block superBlock, Tokenizer tokenizer) {
        // SKip từ khoá var
        tokenizer.nextToken();
//        Type type = Type.valueOf(tokenizer.nextToken().getToken().toUpperCase()); -> sửa để có thể đọc được kiểu dữ liệu khác kiểu dữ liệu nguyên thuỷ
        String type = tokenizer.nextToken().getToken();
//        if(type == BuildInType.VOID) {
//            throw new IllegalStateException("Không thể khai báo biến kiểu void."); -> Sửa
//        }

        String name = tokenizer.nextToken().getToken();
        tokenizer.nextToken();
        Token v = tokenizer.nextToken();
        // Chưa rõ value là string, nguyên hay gì nên để là object
        Object value = null;
        if(v.getType() == TokenType.INTEGER_LITERAL) {
            value = Integer.valueOf(v.getToken());
        } else if (v.getType() == TokenType.STRING_LITERAL) {
            value = v.getToken();
        } else {
            // Đây là một định danh kiểu var String a = b (chứ k có var String a = 5) (Biến nằm trong khối cha or k tồn tại), cần tiếp tục lấy giá trị của nó
            value = superBlock.getVariable(v.getToken()).getValue(); // lấy giá trị của biến có tên lấy từ token "v" ở khối cha
        }
        // Thêm biến vừa nhận diện được vào khối lệnh (chưa nhận dạng kiểu dữ liệu, sẽ được quyết định trong phương thức run của VarBlock và interface Type)
        return new VariableBlock(superBlock, type, name, value);
    }
}
