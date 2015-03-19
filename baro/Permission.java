package baro;

public enum Permission {

	READ(0x10),
	WRITE(0x20),
	OPERATION(0x8);
	
	private final int value;
	
	Permission(int value) {
		this.value = value;
	}
	
	public int value() {
		return value;
	}
	
}