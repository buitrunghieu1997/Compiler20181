package yacc;

import com.Ostermiller.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileStuff {

  private static BufferedReader bufferedReaderObject;
  private static String lastRead = "";
  private static String inputProgram = "";
  private static String tobefiltered;
  private static String fileName = "./Yacc/example/stuff.c";
  private static StringTokenizer st;
  private static boolean commentFlag = false;
  private static boolean debugMode = true;

  public static void readFile() {
    String data = "";
    try {
      bufferedReaderObject = new BufferedReader(new FileReader(fileName));

      while ((data = bufferedReaderObject.readLine()) != null) {
        // myParserObject.decideParse(data);
        // System.out.println("message received"+data);

        if (data.contains("(")
            || data.contains(")")
            || data.contains("{")
            || data.contains("}")
            || data.contains("do")
            || data.contains("while")
            || data.contains("break")
            || data.contains("if")
            || data.contains("else")
            || data.contains("switch")
            || data.contains("case")
            || data.contains("break")
            || data.contains("/*")
            || data.contains("*/")) {
          inputProgram += data;
          System.out.println(data);
        }
      }

      st = new StringTokenizer(inputProgram, " \t\n\r\f", "=#<>{}()+;*");

    } catch (Exception e) {
      System.out.println("Exception in InitClass.readFileLine : " + e.getMessage());
    }
  }

  public static String getToken() {
    if (st.hasMoreTokens()) {
      String str = st.nextToken();
      if (FileStuff.debugMode) System.out.println("token : " + str);
      return str;
    } else {
      Myscanner.setEofFlag(true);
      return " ";
    }
  }

  public static boolean isDebugMode() {
    return debugMode;
  }

  public static BufferedReader getBufferedReaderObject() {
    return bufferedReaderObject;
  }

  public static String getLastRead() {
    return lastRead;
  }

  public static String getInputProgram() {
    return inputProgram;
  }

  public static String getTobefiltered() {
    return tobefiltered;
  }

  public static String getFileName() {
    return fileName;
  }

  public static StringTokenizer getSt() {
    return st;
  }

  public static boolean isCommentFlag() {
    return commentFlag;
  }
}
