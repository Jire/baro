package baro;

import static baro.Utils.buffer;

import java.nio.ByteBuffer;

public interface Memory {

	static Memory allocate(long size) {
		return NativeMemory.allocate(size);
	}

	static Memory allocate(byte[] data) {
		Memory memory = allocate(data.length);
		return memory.set(0, data);
	}

	static Memory allocate(ByteBuffer buffer) {
		return allocate(buffer.array());
	}
	
	static Memory of(boolean value) {
		return of(value ? 1 : 0);
	}

	static Memory of(byte value) {
		return allocate(buffer(1).put(value));
	}

	static Memory of(short value) {
		return allocate(buffer(2).putShort(value));
	}

	static Memory of(char value) {
		return allocate(buffer(2).putChar(value));
	}

	static Memory of(int value) {
		return allocate(buffer(4).putInt(value));
	}

	static Memory of(long value) {
		return allocate(buffer(8).putLong(value));
	}

	static Memory of(float value) {
		return allocate(buffer(4).putFloat(value));
	}

	static Memory of(double value) {
		return allocate(buffer(8).putDouble(value));
	}

	static Memory of(String value) {
		return allocate(value.getBytes());
	}

	long size();

	byte[] data();

	String dump();

	byte getByte(int offset);

	short getShort(int offset);

	char getChar(int offset);

	int getInt(int offset);

	long getLong(int offset);

	float getFloat(int offset);

	double getDouble(int offset);

	String getString(int offset);

	default byte getByte() {
		return getByte(0);
	}

	default short getShort() {
		return getShort(0);
	}

	default char getChar() {
		return getChar(0);
	}

	default int getInt() {
		return getInt(0);
	}

	default long getLong() {
		return getLong(0);
	}

	default float getFloat() {
		return getFloat(0);
	}

	default double getDouble() {
		return getDouble(0);
	}

	default String getString() {
		return getString(0);
	}

	Memory setByte(int offset, byte value);

	Memory setShort(int offset, short value);

	Memory setChar(int offset, char value);

	Memory setInt(int offset, int value);

	Memory setLong(int offset, long value);

	Memory setFloat(int offset, float value);

	Memory setDouble(int offset, double value);

	Memory setString(int offset, String value);

	default Memory set(int offset, byte[] data) {
		for (int i = 0; i < data.length; i++)
			setByte(offset + i, data[i]);
		return this;
	}

}