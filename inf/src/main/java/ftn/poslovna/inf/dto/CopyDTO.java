package ftn.poslovna.inf.dto;

public class CopyDTO {
	
	private boolean increase; //increase true = povecamo, increase false = smanjujemo
	private int procenat;
	
	public CopyDTO(){
		
	}

	public boolean isIncrease() {
		return increase;
	}

	public void setIncrease(boolean increase) {
		this.increase = increase;
	}

	public int getProcenat() {
		return procenat;
	}

	public void setProcenat(int procenat) {
		this.procenat = procenat;
	}
	
}
