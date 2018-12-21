/*
 * Copyright(C) 2018 Bùi Trung Hiếu
 * ProgramLanguageCompiler, ProgramLanguageProject.pro - IntelliJ IDEA
 * App.java
 * Created at 19:21 ~ 21/12/2018 by Bùi Trung Hiếu
 */
package ProgramLanguageProject.pro;

import ProgramLanguageProject.pro.runtime.Compiler;

/**
 * Description about this Class/Interface/Enum...
 *
 * @author Bùi Trung Hiếu  Created: 19:21 ~ 21/12/2018
 */
public class App {
  public static void main(String[] args) {
	  String code =
			  "class Variables\n"
			  + "\n"
			  + "    method main require () return void\n"
			  + "        var String string = \"Hello I Love u\"\n"
			  + "        var Integer int = 123456\n"
			  + "\n"
			  + "    method printString require (String str) return String"
			  + "\n"
			  + "    method voidTest require () return void";
	  Compiler.compile(code);
  }
}
