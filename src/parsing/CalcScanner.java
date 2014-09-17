package parsing;

import util.CharacterIterator;

/*Scanner will read input and tokenize it*/
public class CalcScanner {
	private CharacterIterator inputIterator;
	private StringBuffer currentSpelling;
	private char currentChar;
	private static final char INPUT_END_FLAG = '\0';

	public CalcScanner(String input) {
		inputIterator = new CharacterIterator(input);
		if (inputIterator.hasNext()) {
			currentChar = inputIterator.next();
		}
	}

	private TokenType scanToken() {
		switch (currentChar) {
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9': {
			takeIt();
			while (isDigit(currentChar)) {
				takeIt();
			}
			if (currentChar != '.') {
				return TokenType.INTEGER;
			} else {
				takeIt();
				while (isDigit(currentChar)) {
					takeIt();
				}
				return TokenType.REAL;
			}
		}
		case '+':
		case '-': {
			takeIt();
			return TokenType.ADDSUBOP;
		}
		case '*':
		case '/': {
			takeIt();
			return TokenType.MULTDIVOP;
		}
		case '(':
			takeIt();
			return TokenType.LEFTPAREN;
		case ')':
			takeIt();
			return TokenType.RIGHTPAREN;
		default: {
			takeIt();
			return TokenType.ERROR;
		}
		}
	}

	private boolean isDigit(char currentChar) {
		// TODO Auto-generated method stub
		switch (currentChar) {
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9': {
			return true;
		}
		default:
			return false;
		}
	}

	private void takeIt() {
		// TODO Auto-generated method stub
		currentSpelling.append(currentChar);
		if(inputIterator.hasNext()){
			currentChar = inputIterator.next();
		}
		else{
			currentChar = INPUT_END_FLAG;
		}
	}
	private void removeWhiteSpace(){
		while (currentChar == ' ') {
			takeIt();
		}
	}
	public Token scan() {
		//no more characters left in the input
		if(currentChar==INPUT_END_FLAG){
			return new Token(TokenType.END, null);
		}
		removeWhiteSpace();
		currentSpelling = new StringBuffer("");
		TokenType currentTokenType = scanToken();
		return new Token(currentTokenType, currentSpelling.toString());
	}
}
