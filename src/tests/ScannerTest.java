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
			System.out.println("Enter an expression:");
			String expression = br.readLine();
			CalcScanner scanner = new CalcScanner(expression);
			Token currentToken = scanner.scan();
			while(currentToken.getTokenType() != TokenType.END){
				System.out.println(currentToken.getTokenSpelling());
				currentToken = scanner.scan();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
