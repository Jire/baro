package baro.natives;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

public final class Natives {

	public static final int PROCESS_QUERY_INFORMATION = 0x0400;
	public static final int PROCESS_VM_READ = 0x0010;
	public static final int PROCESS_VM_WRITE = 0x0020;
	public static final int PROCESS_VM_OPERATION = 0x0008;

	public static final Kernel32 KERNEL32 = Kernel32.INSTANCE;
	public static final User32 USER32 = User32.INSTANCE;
	public static final Psapi PSAPI = Psapi.INSTANCE;

	public static Pointer openProcess(int pid) {
		return openProcess(pid, PROCESS_QUERY_INFORMATION | PROCESS_VM_READ
				| PROCESS_VM_WRITE | PROCESS_VM_OPERATION);
	}

	public static Pointer openProcess(int pid, int permissions) {
		return KERNEL32.OpenProcess(permissions, true, pid);
	}

	public static int processByWindow(String windowName) {
		IntByReference pid = new IntByReference(0);
		Pointer window = USER32.FindWindowA(null, windowName);
		USER32.GetWindowThreadProcessId(window, pid);
		return pid.getValue();
	}

	public static int processByName(String processName) {
		int[] processes = new int[1024];
		int[] dummies = new int[1024]; // dummy process list, we don't need it
		PSAPI.EnumProcesses(processes, 1024, dummies);
		for (int pid : processes) {
			char[] names = new char[1024];
			Pointer process = openProcess(pid);
			PSAPI.GetProcessImageFileNameW(process, names, 1024);
			StringBuilder path = new StringBuilder();
			for (int k = 0; k < 1024; k++)
				if (names[k] != 0)
					path.append(names[k]);
			if (path.toString().contains(processName))
				return pid;
		}
		return -1;
	}

	public static Memory readMemory(Pointer process, long address,
			int bytesToRead) {
		IntByReference read = new IntByReference(0);
		Memory output = new Memory(bytesToRead);
		KERNEL32.ReadProcessMemory(process, address, output, bytesToRead, read);
		return output;
	}

	public static void writeMemory(Pointer process, long address, byte[] data) {
		int size = data.length;
		Memory memory = new Memory(size);
		for (int i = 0; i < size; i++)
			memory.setByte(i, data[i]);
		KERNEL32.WriteProcessMemory(process, address, memory, size, null);
	}

}