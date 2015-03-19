package baro;

public interface Process {

	void write(long address, byte[] data);

	default void write(long address, Memory memory) {
		write(address, memory.data());
	}

	Memory read(long address, int numberOfBytes);

}