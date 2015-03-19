package baro;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class Utils {
	
	static ByteBuffer buffer(int size, ByteOrder order) {
		return ByteBuffer.allocate(size).order(order);
	}
	
	static ByteBuffer buffer(int size) {
		return buffer(size, ByteOrder.nativeOrder());
	}

}