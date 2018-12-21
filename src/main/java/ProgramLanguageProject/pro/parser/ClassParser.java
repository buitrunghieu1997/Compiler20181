/*
 * Copyright(C) 2018 Bùi Trung Hiếu
 * ProgramLanguageCompiler, ProgramLanguageProject.pro.block - IntelliJ IDEA
 * ClassParser.java
 * Created at 14:55 ~ 27/11/2018 by Bùi Trung Hiếu
 */
package ProgramLanguageProject.pro.parser;

import ProgramLanguageProject.pro.block.Block;
import ProgramLanguageProject.pro.block.Class;
import ProgramLanguageProject.pro.parser.Parser;
import ProgramLanguageProject.pro.tokenizer.Tokenizer;
import ProgramLanguageProject.pro.utils.Constants;

/**
 * Description about this Class/Interface/Enum...
 *
 * @author Bùi Trung Hiếu  Created: 14:55 ~ 27/11/2018
 */
public class ClassParser extends Parser<Class> {
    @Override public boolean shouldParse(String line) {
        // parse the line with the regex
        return line.matches(Constants.CLASS_PARSER_PATTERN);
    }

    @Override public Class parse(Block superBlock, Tokenizer tokenizer) {
        // bỏ qua từ khoá class
        tokenizer.nextToken();
        // lấy từ tiếp sau từ class
        String name = tokenizer.nextToken().getToken();

        // Trả về class với tên lấy được
        return new Class(name);
    }
}
