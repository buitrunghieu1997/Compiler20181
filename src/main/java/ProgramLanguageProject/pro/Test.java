/*
 * Copyright(C) 2018 Bùi Trung Hiếu
 * ProgramLanguageCompiler, ProgramLanguageProject.pro - IntelliJ IDEA
 * Test.java
 * Created at 16:33 ~ 21/12/2018 by Bùi Trung Hiếu
 */
package ProgramLanguageProject.pro;

import ProgramLanguageProject.pro.tokenizer.Token;
import ProgramLanguageProject.pro.tokenizer.Tokenizer;

/**
 * Description about this Class/Interface/Enum...
 *
 * @author Bùi Trung Hiếu Created: 16:33 ~ 21/12/2018
 */
public class Test {

  public static void main(String[] args) {
    String code =
        "class Variables\n"
            + "\n"
            + "    method main require () return void\n"
            + "        var String string = \"Hello I Love u\"\n"
            + "        String str = getString()\n"
            + "        printString(str)\n"
            + "\n"
            + "    method printString require (String str) return void\n"
            + "        print str\n"
            + "\n"
            + "    method getString require () return String\n"
            + "        return \"Hello\"";

    Tokenizer tokenizer = new Tokenizer(code);

    while (tokenizer.hasNextToken()) {
      Token t = tokenizer.nextToken();
      System.out.println(t.getType() + " " + t.getToken());
    }
  }
}
