
public enum Input {
	
	INPUT0, INPUT1, INPUT2, INPUT3, INPUT4, INPUT5, INPUT6, MAX_INPUT;
	
	public static Input fromInt(int num){
		
		switch(num){
		case 0: return INPUT0; //TERMINATE
		case 1: return INPUT1; //KEY
		case 2: return INPUT2; //SEAT
		case 3: return INPUT3; //UNSEAT
		case 4: return INPUT4; //BELT
		case 5: return INPUT5; //UNBELT
		case 6: return INPUT6; //TIMER EXPIRES
		default: return MAX_INPUT;
		}
		
	}
	
}
