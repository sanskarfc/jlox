package jlox;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;


public class Lox {
  static Boolean hadError = false;
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
    run(new String(bytes, Charset.defaultCharset())); 

    // Indicate an error in the exit code.
    if (hadError) System.exit(65);
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
      run(line); 
      hadError = false;
    }
  }   

  private static void run(String source) {
    Scanner scanner = new java.util.Scanner(System.in);
    List<Token> tokens = scanner.scanTokens();

    // For now, just print the tokens.
    for (Token token : tokens) {
      System.out.println(token);
    }
  }  

    static void error(int line, String message) {
    report(line, "", message);
  }

  private static void report(int line, String where, String message) {
    System.err.println(
        "[line " + line + "] Error" + where + ": " + message);
    hadError = true;
  }
}  



