package jlox;

class Token {
  final TokenType type; // from that enum
  final String lexeme; // what is the actual lexeme 
  final Object literal; // ??? 
  final int line;  // line number in which this token occurs

  Token(TokenType type, String lexeme, Object literal, int line) { // constructor  
    this.type = type;
    this.lexeme = lexeme;
    this.literal = literal;
    this.line = line;
  }

  @Override
  public String toString() { // usefull while printing the token
    return type + " " + lexeme + " " + literal;
  }
}
