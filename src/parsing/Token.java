package parsing;

public class Token {
	private String tokenSpelling;
	private TokenType tokenType;
	public Token(TokenType tokenType, String tokenSpelling){
		this.tokenSpelling = tokenSpelling;
		this.tokenType = tokenType;
	}
	public String getTokenSpelling(){
		return tokenSpelling;
	}
	public TokenType getTokenType(){
		return tokenType;
	}
}
