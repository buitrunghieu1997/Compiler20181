/*
 * Copyright(C) 2018 Bùi Trung Hiếu
 * ProgramLanguageCompiler, ProgramLanguageProject.pro.parser - IntelliJ IDEA
 * Parser.java
 * Created at 14:36 ~ 27/11/2018 by Bùi Trung Hiếu
 */
package main.java.ProgramLanguageProject.pro.parser;

import main.java.ProgramLanguageProject.pro.block.Block;
import main.java.ProgramLanguageProject.pro.tokenizer.Tokenizer;

/**
 * Class dùng để parse các thành phần mở rộng (generic type, sẽ được extend sau) từ khối lệnh
 *
 * @author Bùi Trung Hiếu  Created: 14:36 ~ 27/11/2018
 */
public abstract class Parser<T extends Block>{
    /**
     * Đọc một dòng code và kiểm tra xem có cần parse không sử dụng biểu thức chính quy
     * @param line loc
     * @return
     */
    public abstract boolean shouldParse(String line);

    /**
     * Đọc khối lệnh cha và dùng tockenizer sau đó trả về đoạn code kiểu T (có thể là class, method, lặp, ...)
     * @param superBlock khối lệnh cha
     * @param tokenizer bộ nhận biết token
     * @return T (super BuildInType is Block)
     */
    public abstract T parse(Block superBlock, Tokenizer tokenizer);
}
