# baro

**baro** is a simple JNA-based native memory reader/writer for Windows.

#####Searching for a process

```java
Baro.processByID(int processID)
Baro.processByName(String processName)
Baro.processByWindow(String windowName)
```

#####Writing to memory

```java
process.write(0x0, byte[] data);
process.write(0x0, Memory.of(30));
process.write(0x1, Memory.of(true));
```

#####Reading from memory
```java
Memory memory = process.read(0x0, 4);
int value = memory.getInt();
```


####Example Source

```java
public class Baromemter {

    public static void main(String[] args) {
        System.out.println("What's funnier than 24?");
    
        Process process = Baro.processByName("spongebob.exe");
        process.write(0x64, Memory.of(25));
        
        Memory answer = process.read(0x64, 4); // 4 bytes = 1 integer
        System.out.printf("%s!", answer.getInt()); // "25!"
    }

}
```