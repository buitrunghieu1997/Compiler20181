/*
 * Copyright(C) 2018 Bùi Trung Hiếu
 * ProgramLanguageCompiler, ProgramLanguageProject.pro - IntelliJ IDEA
 * Parameter.java
 * Created at 15:55 ~ 27/11/2018 by Bùi Trung Hiếu
 */
package main.java.ProgramLanguageProject.pro.varl;


import main.java.ProgramLanguageProject.pro.Type.Type;

/**
 * Đại diện cho một tham số (vd như tha số của hàm)
 *
 * @author Bùi Trung Hiếu  Created: 15:55 ~ 27/11/2018
 */
public class Parameter {
    private Type   type;
    private String name;

    public Parameter(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }
}
