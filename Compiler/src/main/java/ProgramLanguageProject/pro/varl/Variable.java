/*
 * Copyright(C) 2018 Bùi Trung Hiếu
 * ProgramLanguageCompiler, ProgramLanguageProject.pro - IntelliJ IDEA
 * Variable.java
 * Created at 18:09 ~ 27/11/2018 by Bùi Trung Hiếu
 */
package main.java.ProgramLanguageProject.pro.varl;

import main.java.ProgramLanguageProject.pro.Type.Type;
import main.java.ProgramLanguageProject.pro.block.Block;

/**
 * Class đại diện cho một biến
 *
 * @author Bùi Trung Hiếu  Created: 18:09 ~ 27/11/2018
 */
public class Variable extends Value {
    // Block mà biến thuộc về
    private Block block;
    private String name;

    public Variable(Block block, Type type, String name, Object value) {
        super(type, value);
        this.block = block;
        this.name = name;
    }

    public Block getBlock() {
        return block;
    }

    public String getName() {
        return name;
    }
}
