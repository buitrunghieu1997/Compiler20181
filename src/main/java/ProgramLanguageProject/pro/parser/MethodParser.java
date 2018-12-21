/*
 * Copyright(C) 2018 Bùi Trung Hiếu
 * ProgramLanguageCompiler, ProgramLanguageProject.pro.parser - IntelliJ IDEA
 * MethodParser.java
 * Created at 16:03 ~ 27/11/2018 by Bùi Trung Hiếu
 */
package ProgramLanguageProject.pro.parser;

import ProgramLanguageProject.pro.BuildInType;
import ProgramLanguageProject.pro.Parameter;
import ProgramLanguageProject.pro.block.Block;
import ProgramLanguageProject.pro.block.Method;
import ProgramLanguageProject.pro.tokenizer.Token;
import ProgramLanguageProject.pro.tokenizer.Tokenizer;
import ProgramLanguageProject.pro.utils.Constants;

import java.util.ArrayList;

/**
 * Parse xem một khối có phải method hay không
 *
 * @author Bùi Trung Hiếu  Created: 16:03 ~ 27/11/2018
 */
public class MethodParser extends Parser<Method> {
    @Override public boolean shouldParse(String line) {
        return line.matches(Constants.METHOD_PARSER_PATTERN);
    }

    @Override public Method parse(Block superBlock, Tokenizer tokenizer) {
        // skip method token
        tokenizer.nextToken();
        String name = tokenizer.nextToken().getToken();
        // skip require token
        tokenizer.nextToken();
        // skip the "(" token
        tokenizer.nextToken();
        // Lấy ký tự cần quan tâm đầu tiên
        Token first = tokenizer.nextToken();
        ArrayList<Parameter> params = new ArrayList<>();

        // Nếu không phải là ký tự kết thúc của khai báo tham số của method thì xét tiếp
        if(!first.getToken().equals(")")) {
            // index 1 is type of param, index 2 is value, default null
            String[] paramData = new String[] {first.getToken(), null};

            while (tokenizer.hasNextToken()) {
                Token token = tokenizer.nextToken();

                // Khi kết thúc phần khai báo param thì break
                if(token.getToken().equals(")")) {
                    break;
                }

                // Nếu chưa đọc đến phần kiểu của param trong 1 line thì đọc
                if(paramData[0] == null) {
                    paramData[0] = token.getToken();
                } else { // Ngược lại thì đọc kiểu của param đó ở token tiếp thep
                    paramData[1] = token.getToken();
                    // thêm kiểu và tên tham số vào list
                    params.add(new Parameter(BuildInType.valueOf(paramData[0].toUpperCase()), paramData[1]));
                    // reset paramData sau khi đã được lưu vào params
                    paramData = new String[2];
                }
            }
        }
        // bỏ qua từ khoá return
        tokenizer.nextToken();

        String returnType = tokenizer.nextToken().getToken(); // sẽ được parse tìm ra type trong class method
        
        // Trả về 1 method với tên class (SuperBlock), tên, kiểu trả về, danh sách tham số của nó
        return new Method(superBlock, name, returnType, params.toArray(new Parameter[params.size()]));
    }
}
