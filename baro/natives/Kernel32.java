package baro.natives;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.StdCallLibrary;

public interface Kernel32 extends StdCallLibrary {

	Kernel32 INSTANCE = (Kernel32) Native.loadLibrary("Kernel32",
			Kernel32.class);

	boolean WriteProcessMemory(Pointer process, long address, Pointer buffer,
			int size, IntByReference written);

	boolean ReadProcessMemory(Pointer process, long address, Pointer buffer,
			int size, IntByReference written);

	Pointer OpenProcess(int desired, boolean inherit, int pid);

	int GetLastError();

}