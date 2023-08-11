package jlox;

import java.util.List;
import java.util.ArrayList;

import static jlox.TokenType.*; 

class Scanner {
  private final String source;
  private final List<Token> tokens = new ArrayList<>(); // list of tokens to be returned by the scanner??  

  private int start = 0;
  private int current = 0;
  private int line = 1;

  Scanner(String source) { // consturctor 
    this.source = source;
  } 

  List<Token> scanTokens() {
    while (!isAtEnd()) {
      // We are at the beginning of the next lexeme.
      start = current;
      this.scanTokens(); // earlier this was just "scanTokens()"
    }

    tokens.add(new Token(EOF, "", null, line));
    return tokens;
  } 

  private boolean isAtEnd() {
    return current >= source.length();
  }
} 


