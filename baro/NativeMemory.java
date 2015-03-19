package baro;

final class NativeMemory implements Memory {

	static NativeMemory allocate(long size) {
		return allocate(new com.sun.jna.Memory(size));
	}
	
	static NativeMemory allocate(com.sun.jna.Memory memory) {
		return new NativeMemory(memory);
	}

	private final com.sun.jna.Memory memory;

	private NativeMemory(com.sun.jna.Memory memory) {
		this.memory = memory;
	}

	@Override
	public long size() {
		return memory.size();
	}

	@Override
	public byte[] data() {
		return memory.getByteArray(0, (int) memory.size());
	}

	@Override
	public String dump() {
		return memory.dump();
	}

	@Override
	public byte getByte(int offset) {
		return memory.getByte(offset);
	}

	@Override
	public short getShort(int offset) {
		return memory.getShort(offset);
	}

	@Override
	public char getChar(int offset) {
		return memory.getChar(offset);
	}

	@Override
	public int getInt(int offset) {
		return memory.getInt(offset);
	}

	@Override
	public long getLong(int offset) {
		return memory.getLong(offset);
	}

	@Override
	public float getFloat(int offset) {
		return memory.getFloat(offset);
	}

	@Override
	public double getDouble(int offset) {
		return memory.getDouble(offset);
	}

	@Override
	public String getString(int offset) {
		return memory.getString(offset);
	}

	@Override
	public Memory setByte(int offset, byte value) {
		memory.setByte(offset, value);
		return this;
	}

	@Override
	public Memory setShort(int offset, short value) {
		memory.setShort(offset, value);
		return this;
	}

	@Override
	public Memory setChar(int offset, char value) {
		memory.setChar(offset, value);
		return this;
	}

	@Override
	public Memory setInt(int offset, int value) {
		memory.setInt(offset, value);
		return this;
	}

	@Override
	public Memory setLong(int offset, long value) {
		memory.setLong(offset, value);
		return this;
	}

	@Override
	public Memory setFloat(int offset, float value) {
		memory.setFloat(offset, value);
		return this;
	}

	@Override
	public Memory setDouble(int offset, double value) {
		memory.setDouble(offset, value);
		return this;
	}

	@Override
	public Memory setString(int offset, String value) {
		memory.setString(offset, value);
		return this;
	}

}