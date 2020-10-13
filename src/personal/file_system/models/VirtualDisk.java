package personal.file_system.models;

import java.util.ArrayList;
import java.util.List;

public class VirtualDisk {

    public static char diskChar = 'C';

    private final char diskName;
    private final int diskMaxMemory;
    private int diskMemoryUsed;
    private List<DiskObject> diskObjects;
    private int[] diskMemoryArray;

    public VirtualDisk(int diskMaxMemory) {
        this.diskName = setDiskName();
        this.diskMaxMemory = diskMaxMemory;
        this.diskMemoryUsed = 0;
        this.diskObjects = new ArrayList<>();
        this.diskMemoryArray = new int[diskMaxMemory + 1];
    }

    public int getDiskMemoryUsed() {
        return diskMemoryUsed;
    }

    public char getDiskName() {
        return diskName;
    }

    public int[] getDiskMemoryArray() {
        return diskMemoryArray;
    }

    public int getDiskMaxMemory() {
        return diskMaxMemory;
    }

    public List<DiskObject> getDiskObjects() {
        return diskObjects;
    }

    public void setDiskMemoryUsed(int diskMemoryUsed) {
        this.diskMemoryUsed = diskMemoryUsed;
    }

    public void setDiskObjects(List<DiskObject> diskObjects) {
        this.diskObjects = diskObjects;
    }

    public void setDiskMemoryArray(int[] diskMemoryArray) {
        this.diskMemoryArray = diskMemoryArray;
    }

    private char setDiskName() {
        return diskChar++;
    }
}
