package baro;

import baro.natives.Natives;

import com.sun.jna.Pointer;

final class NativeProcess implements Process {

	static NativeProcess open(int pid) {
		return new NativeProcess(Natives.openProcess(pid));
	}

	private final Pointer pointer;

	private NativeProcess(Pointer pointer) {
		this.pointer = pointer;
	}

	@Override
	public void write(long address, byte[] data) {
		Natives.writeMemory(pointer, address, data);
	}

	@Override
	public Memory read(long address, int numberOfBytes) {
		return NativeMemory.allocate(Natives.readMemory(pointer, address, numberOfBytes));
	}

}