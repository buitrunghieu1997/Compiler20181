import java_cup.runtime.Symbol;
import yacc.FileStuff;
import yacc.Myscanner;
import yacc.parser;

public class Test {

 public static void main(String str[]) {
	 
	  //read from the file
	  FileStuff.readFile();
	  
	  Myscanner myScannerObject = new Myscanner();
	  parser    parser_obj      = new parser(myScannerObject);

      /* open input files, etc. here */
      Symbol parse_tree = null;

      try {
        if (FileStuff.isDebugMode())
          parse_tree = parser_obj.debug_parse();
        else
          parse_tree = parser_obj.parse();
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
	/* do close out here */
      }
      handler.HandleFlow.printFlow();
      
 }
}