/*
 * Copyright(C) 2018 Bùi Trung Hiếu
 * ProgramLanguageCompiler, ProgramLanguageProject.pro.block - IntelliJ IDEA
 * VariableBlock.java
 * Created at 11:39 ~ 21/12/2018 by Bùi Trung Hiếu
 */
package main.java.ProgramLanguageProject.pro.block;

import main.java.ProgramLanguageProject.pro.Type.BuildInType;
import main.java.ProgramLanguageProject.pro.Type.Type;
import main.java.ProgramLanguageProject.pro.varl.Variable;

/**
 * Class này chính là một khai báo biến mà chưa xác định được kiểu dữ liệu là nguyên thuỷ hay không
 *
 * @author Bùi Trung Hiếu  Created: 11:39 ~ 21/12/2018
 */
public class VariableBlock extends Block {
	private String type;
	private String name;
	private Object value;
	
	public String getType() {
		return type;
	}
	
	public String getName() {
		return name;
	}
	
	public Object getValue() {
		return value;
	}
	
	public VariableBlock(Block superBlock, String type, String name, Object value) {
		super(superBlock);
		this.type = type;
		this.name = name;
		this.value = value;
	}
	
	@Override public void run() {
		/*
		 * Đoạn này xđ kiểu dl là nguyên thuỷ hay k
		 */
		Type t = Type.match(type);
		if(t == BuildInType.VOID) {
			throw new IllegalStateException("Không thể khai báo biến kiểu void.");
		}
		
		// thêm biến vs kiểu dl vừa nhận diện được vào khối cha của nó
		getSuperBlock().addVariable(new Variable(getSuperBlock(), t, name, value));
	}
}
