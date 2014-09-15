package tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import parsing.CalcScanner;
import parsing.Token;
import parsing.TokenType;

public class ScannerTest {
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringBuffer expression = new StringBuffer("");
			char currentChar;
			do{
				currentChar = (char) br.read();
				expression.append(currentChar);
				
			}while(currentChar!='\n');
			CalcScanner scanner = new CalcScanner(expression.toString());
			//CalcScanner scanner = new CalcScanner("test");
			Token currentToken = scanner.scan();
			while(currentToken.getTokenType() != TokenType.END){
				System.out.println(currentToken.getTokenSpelling());
				currentToken = scanner.scan();
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
