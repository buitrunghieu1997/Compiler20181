/*
 * Copyright(C) 2018 Bùi Trung Hiếu
 * ProgramLanguageCompiler, ProgramLanguageProject.pro - IntelliJ IDEA
 * Type.java
 * Created at 11:23 ~ 21/12/2018 by Bùi Trung Hiếu
 */
package ProgramLanguageProject.pro.Type;

/**
 * Description about this Class/Interface/Enum...
 *
 * @author Bùi Trung Hiếu  Created: 11:23 ~ 21/12/2018
 */
public interface Type {
	// không chỉ trả về các kiểu dữ liệu được định nghĩa sẵn mà còn có thể trả về các kiểu dữ liệu qua class cảu người dùng
	// Do đó tạo interface này, bất cứ cái gì impl nó đều có thể coi như 1 kiểu trả về: vd class
	public static Type match(String str) {
		try { // thử trả vè kiểu dữ liệu nguyên thuỷ
			return BuildInType.valueOf(str.toUpperCase()); // các enum built in được khai báo là uppercase chấp nhận người dùng viết ở mọi dạng còn class thì bắt buộc phải đúng
		} catch (Exception e) { // nếu không được thì tìm kiếm trong tập các class và trả về kiểu dữ liệu dạng mở rộng do ng dùng quy định
			//TODO: Match kiểu thu được với 1 class được người dùng định nghĩa
			return null;
		}
	}
}