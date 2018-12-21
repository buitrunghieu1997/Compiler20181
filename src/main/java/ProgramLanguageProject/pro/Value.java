/*
 * Copyright(C) 2018 Bùi Trung Hiếu
 * ProgramLanguageCompiler, ProgramLanguageProject.pro - IntelliJ IDEA
 * Value.java
 * Created at 15:53 ~ 27/11/2018 by Bùi Trung Hiếu
 */
package ProgramLanguageProject.pro;

/**
 * Đại diện cho một giá trị (cảu 1 biến, 1 hằng, 1 hàm).
 *
 * @author Bùi Trung Hiếu  Created: 15:53 ~ 27/11/2018
 */
public class Value {
    private Type type;
    private Object      value;

    public Value(Type type, Object value) {
        this.type = type;
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
