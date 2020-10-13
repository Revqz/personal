package personal.file_system.services;

import personal.file_system.models.DiskObject;
import personal.file_system.models.VirtualDisk;

public class DiskMemoryService {

    private final VirtualDisk virtualDisk;

    public DiskMemoryService(VirtualDisk virtualDisk) {
        this.virtualDisk = virtualDisk;
    }

    void addingDiskObjectToDiskMemory(DiskObject diskObject) {
        virtualDisk.setDiskMemoryUsed(increaseUsedMemory(diskObject));
        writingToMemoryArray(diskObject);
    }

    void erasingDiskObjectFromDiskMemory(DiskObject diskObject) {
        virtualDisk.setDiskMemoryUsed(decreaseUsedMemory(diskObject));
        erasingFromMemoryArray(diskObject);
    }

    private void writingToMemoryArray(DiskObject diskObject) {
        int[] diskArray = virtualDisk.getDiskMemoryArray();
        int counter = 0;
        int memoryCellIndex = 0;
        while (diskObject.getSize() != counter) {
            if (diskArray[memoryCellIndex] == 0) {
                diskArray[memoryCellIndex] = diskObject.getUniqueNumber();
                counter++;
            }
            memoryCellIndex++;
        }
        virtualDisk.setDiskMemoryArray(diskArray);
    }

    private void erasingFromMemoryArray(DiskObject diskObject) {
        int[] diskArray = virtualDisk.getDiskMemoryArray();
        int counter = diskObject.getSize();
        for (int i = 0; i < diskArray.length; i++) {
            if (diskObject.getUniqueNumber() == diskArray[i]) {
                diskArray[i] = 0;
                counter--;
            }
            if (counter == 0) {
                break;
            }
        }
        virtualDisk.setDiskMemoryArray(diskArray);
    }

    private int increaseUsedMemory(DiskObject diskObject) {
        return virtualDisk.getDiskMemoryUsed() + diskObject.getSize();
    }

    private int decreaseUsedMemory(DiskObject diskObject) {
        return virtualDisk.getDiskMemoryUsed() - diskObject.getSize();
    }
}
