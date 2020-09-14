package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Solution01 {

	public static void main(String[] args) {
		Solution01	s01 = new Solution01();
		
		int normal	 = 130;
		int shuffled = s01.solution(normal);

		System.out.println("normal..... ["+normal	+"]");
		System.out.println("shuffled... ["+shuffled	+"]");
	}

	public int solution(int intNum) {
		
		String	srtNum		= new Integer(intNum).toString();
		char[]  charNum		= srtNum.toCharArray();
		char[]  charShuffled= new char[charNum.length];

		int tamNum			= charNum.length;
		int meio			= (tamNum/2);
		boolean isEven		= (tamNum%2==0);
		
		int beginPosition	= 0;
		int endPosition		= (tamNum-1);
		for (int i = 0; i < tamNum; i++) {

			charShuffled[i] =charNum[beginPosition];
			
			if (beginPosition==endPosition)
				break;
			
			charShuffled[i+1]=charNum[endPosition];

			beginPosition	= beginPosition + 1;
			endPosition		= endPosition   - 1;
			
			if (beginPosition > meio)
				break;

			i=i+1;
		}
		
		String newShuffled = new String(charShuffled);
		int    intShuffled = new Integer(newShuffled).intValue();
		return intShuffled;
    }
	
	
}
