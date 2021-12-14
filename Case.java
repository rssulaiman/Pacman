package pacman;

public class Case {

	private final int positionX;
	private final int positionY;
	private CaseType type;
	
	public Case(int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.type = type.VIDE;
	}
	
	public void setCaseType(CaseType type) {
		this.type = type;
	}
	
}
