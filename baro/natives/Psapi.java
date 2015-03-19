package baro.natives;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary;

public interface Psapi extends StdCallLibrary {

	Psapi INSTANCE = (Psapi) Native.loadLibrary("Psapi", Psapi.class);

	boolean EnumProcesses(int[] processes, int size, int[] output);

	int GetProcessImageFileNameW(Pointer process, char[] output, int length);

}