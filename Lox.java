import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Lox {
  public static void main(String[] args) throws IOException {
    if (args.length > 1) { // incorrect usage 
      System.out.println("Usage: jlox [script]");
      System.exit(64); 
    } else if (args.length == 1) { // runFile mode 
      runFile(args[0]);
    } else { // repl mode
      runPrompt();
    }
  } 

  // reads all the bytes. calls the run function with the bytes and the ??charset?? 
  private static void runFile(String path) throws IOException {
    byte[] bytes = Files.readAllBytes(Paths.get(path));
    // run(new String(bytes, Charset.defaultCharset()));
  } 


  // repl mode  
  // for each line typed, executes that line using the run function
  private static void runPrompt() throws IOException {
    InputStreamReader input = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(input);

    for (;;) { 
      System.out.print("> ");
      String line = reader.readLine();
      if (line == null) break;
      // run(line);
    }
  } 
 



}  



