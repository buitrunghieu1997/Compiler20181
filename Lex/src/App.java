/*
 * Copyright(C) 2018 Bùi Trung Hiếu
 * ProgramLanguageCompiler, PACKAGE_NAME - IntelliJ IDEA
 * App.java
 * Created at 22:57 ~ 21/12/2018 by Bùi Trung Hiếu
 */

import lexial.Sentence;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Description about this Class/Interface/Enum...
 *
 * @author Bùi Trung Hiếu Created: 22:57 ~ 21/12/2018
 */
public class App {
  public static void main(String[] args) {
    String dirName = "./Lex/example/";

    try {
      for (int i = 0; i < args.length; i++) {
        if (args[i].equals("-dir")) {
          i++;
          if (i >= args.length) {
            throw new Error("Missing directory name.");
          }
          dirName = args[i];
        } else {
          throw new Error("Usage: java Main -dir directory");
        }
      }
      if (dirName == null) {
        throw new Error("Directory not specified.");
      }

      Sentence lexer = new Sentence();
      System.setErr(new PrintStream(new FileOutputStream(new File(dirName, "program.err"))));
      System.setOut(new PrintStream(new FileOutputStream(new File(dirName, "program.out"))));
      lexer.yylex();
    } catch (Exception e) {
      System.out.println("Exception in Main " + e.toString());
      e.printStackTrace();
    }
  }
}
