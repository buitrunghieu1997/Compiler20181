/*
 * Copyright(C) 2018 Bùi Trung Hiếu
 * ProgramLanguageCompiler, ProgramLanguageProject.pro.block - IntelliJ IDEA
 * Class.java
 * Created at 14:50 ~ 27/11/2018 by Bùi Trung Hiếu
 */
package ProgramLanguageProject.pro.block;

import ProgramLanguageProject.pro.Type;

/**
 * Một class, extends từ block
 *
 * @author Bùi Trung Hiếu  Created: 14:50 ~ 27/11/2018
 */
public class Class extends Block implements Type {
    private String name;

    public Class(String name) {
        // không có superblock của một class
        super(null); // gọi constructtor của cha
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override public void run() {
        // hàm này được gọi khi trong class có main, hàm này sẽ tìm ra hàm main trong class và chạy
        for (Block b : getSubBlocks()) {
            if(b instanceof Method) {
                Method method = (Method) b;
                if(method.getName().equals("main") && method.getType().equals("void") && method.getParams().length == 0) {
                    method.run();
                }
            }
        }
    }


}
