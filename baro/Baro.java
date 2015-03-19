package baro;

import java.util.Optional;

import baro.natives.Natives;

public final class Baro {

	public static Optional<Process> processByID(int processID) {
		if (processID < 0)
			return Optional.empty();
		return Optional.of(NativeProcess.open(processID));
	}

	public static Optional<Process> processByName(String processName) {
		return processByID(Natives.processByName(processName));
	}

	public static Optional<Process> processByWindow(String windowName) {
		return processByID(Natives.processByWindow(windowName));
	}

}