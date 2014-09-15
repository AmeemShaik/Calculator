package util;

import java.util.Iterator;

public class CharacterIterator implements Iterator<Character>{
	
	private String input;
	private int position;
	
	public CharacterIterator(String input){
		this.input = input;
		position = 0;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return position < input.length(); 

	}

	@Override
	public Character next() {
		// TODO Auto-generated method stub
		return input.charAt(position++);
	}
}
