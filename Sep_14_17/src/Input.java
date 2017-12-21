
public enum Input {
	
	INPUT0, INPUT1, INPUT2, INPUT3, INPUT4, INPUT5, INPUT6, INPUT7, INPUT8, INPUT9, MAX_INPUT;
	
	public static Input fromInt(int num){
		
		switch(num){
		case 0: return INPUT0;
		case 1: return INPUT1;
		case 2: return INPUT2;
		case 3: return INPUT3;
		case 4: return INPUT4;
		case 5: return INPUT5;
		case 6: return INPUT6;
		case 7: return INPUT7;
		case 8: return INPUT8;
		case 9: return INPUT9;
		default: return MAX_INPUT;
		}
		
	}
	
}
