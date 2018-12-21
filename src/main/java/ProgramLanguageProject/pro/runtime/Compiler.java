/*
 * Copyright(C) 2018 Bùi Trung Hiếu
 * ProgramLanguageCompiler, ProgramLanguageProject.pro - IntelliJ IDEA
 * Compiler.java
 * Created at 13:57 ~ 21/12/2018 by Bùi Trung Hiếu
 */
package ProgramLanguageProject.pro.runtime;

import ProgramLanguageProject.pro.block.Block;
import ProgramLanguageProject.pro.block.Class;
import ProgramLanguageProject.pro.block.Method;
import ProgramLanguageProject.pro.parser.ClassParser;
import ProgramLanguageProject.pro.parser.MethodParser;
import ProgramLanguageProject.pro.parser.Parser;
import ProgramLanguageProject.pro.parser.VariableParser;
import ProgramLanguageProject.pro.tokenizer.Token;
import ProgramLanguageProject.pro.tokenizer.Tokenizer;

import java.util.ArrayList;

/**
 * Description about this Class/Interface/Enum...
 *
 * @author Bùi Trung Hiếu Created: 13:57 ~ 21/12/2018
 */
public class Compiler {
  private ArrayList<Class> classes;
  
  public static void compile(String code) {
    new Compiler(code);
  }

  private Compiler(String code) {
    this.classes = new ArrayList<Class>();
    Parser<?>[] parsers =
        new Parser<?>[] {new ClassParser(), new MethodParser(), new VariableParser()};
    Class main = null;
    Block block = null;
    boolean success = false;
    System.out.println("_______________________________________________________________");
    System.out.println("Code to traversal is:\n" + code);
    System.out.println("_______________________________________________________________");
    System.out.println("Refine code:");
    code = code.replaceAll("(\\s)*(\n){2,}(\\s)*", "\n");
    System.out.println(code);
    for (String line : code.split("\n")) {
      success = false;
      line = line.trim();
      Tokenizer tokenizer = new Tokenizer(line);
      System.out.println("_______________________________________________________________");
      System.out.println("Traversal line: " + line);

      System.out.println("Tokenizer Analyzer:");
      Tokenizer tokenizerBak = new Tokenizer(line);

      while (tokenizerBak.hasNextToken()) {
        Token t = tokenizerBak.nextToken();
        System.out.println(t.getType() + " " + t.getToken());
      }

      for (Parser<?> parser : parsers) {
        // kiểm tra độ hợp lệ của dòng code
        if (parser.shouldParse(line)) {
          System.out.println("Valid line: " + line);
          Block newblock = parser.parse(block, tokenizer);

          if (newblock instanceof Class) { // nếu là class thì thêm vào dạng class
            System.out.println("Found Block of type Class");
            classes.add((Class) newblock);
          } else if (newblock
              instanceof
              Method) { // đọc tất cả các method có trong class (nếu k xét thì chỉ đọc được 1
            // method)
            System.out.println("Found Block of type Method");
            block.getBlockTree().get(0).addBlock(newblock); // thêm method vào nút con của class
          } else { // nếu k phải class thì thêm vào dạng block
            System.out.println(
                "Adding "
                    + newblock.getClass().getSimpleName()
                    + " to "
                    + block.getClass().getSimpleName());
            block.addBlock(newblock);
          }

          block = newblock; // đệ quy
          success = true;
          break;
        }
      }
      if (!success) {
        System.out.println("_______________________________________________________________");
        throw new IllegalArgumentException("Invalid line: " + line);
      }
    }
    System.out.println("Traversal line of code end.");
    System.out.println("_______________________________________________________________");
    System.out.println("Beginning traversal Classes and methods.");
    for (Class c : classes) {
      System.out.println("Traversal class: " + c.getName());
      for (Block b : c.getSubBlocks()) {
        System.out.println("Found Block of type " + b.getClass().getSimpleName());
        if (b instanceof Method) {
          System.out.println("Found method name: " + ((Method) b).getName());
          Method method = (Method) b;
          if (method.getName().equals("main")
              && method.getType().equals("void")
              && method.getParams().length == 0) {
            main = c;
          }
        }
      }
    }

    System.out.println("End traversal Classes and methods.");
    System.out.println("_______________________________________________________________");

    if (main == null) {
      throw new IllegalStateException("No main method!");
    } else {
      System.out.println("Class " + main.getName() + " contain main method.");
    }

    main.run();
    System.out.println("Compile end.");
    System.out.println("_______________________________________________________________");
  }
}
