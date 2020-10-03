package Personal.FileSystem;

import java.util.ArrayList;
import java.util.List;

class VirtualDisk {

    private static char diskChar = 'C';

    private final char diskName;
    private final int diskMaxMemory;
    private int diskMemoryUsed;
    private final List<VirtualDiskObject> virtualDiskObjects;
    private final int[] diskArray;

    VirtualDisk(int diskMaxMemory) {
        this.diskName = diskName();
        this.diskMaxMemory = diskMaxMemory;
        this.diskMemoryUsed = 0;
        this.virtualDiskObjects = new ArrayList<>();
        this.diskArray = new int[diskMaxMemory + 1];
    }

    int getDiskMemoryUsed() {
        return diskMemoryUsed;
    }

    char getDiskName() {
        return diskName;
    }

    int[] getDiskArray() {
        return diskArray;
    }

    int getDiskMaxMemory() {
        return diskMaxMemory;
    }

    List<VirtualDiskObject> getVirtualDiskObjects() {
        return virtualDiskObjects;
    }

    void createFolder(String name) {
        VirtualDiskObject folder = new Folder(name);
        addingVirtualDiskObjectToDisk(folder);
    }

    void createFile(String name, int size, FileType fileType) {
        VirtualDiskObject file = new File(name, size, fileType);
        addingVirtualDiskObjectToDisk(file);
    }

    void createSubfolder(String subFolderName, String folderName) {
        SubFolder subFolder = new SubFolder(subFolderName);
        VirtualDiskObject folder = findVirtualDiskObject(folderName);
        if (nameIsLessThan20Char(subFolder) && isEnoughMemory(subFolder) && folder != null) {
            folder.addSubFolderToFolderList(subFolder);
            writingToMemoryArray(subFolder);
            diskMemoryUsed += subFolder.size;
        } else {
            VirtualDiskObject.objectUniqueNumber--;
        }
    }

    void addingVirtualDiskObjectToDisk(VirtualDiskObject virtualDiskObject) {
        if (nameIsLessThan20Char(virtualDiskObject) && isEnoughMemory(virtualDiskObject)) {
            virtualDiskObjects.add(virtualDiskObject);
            writingToMemoryArray(virtualDiskObject);
            diskMemoryUsed += virtualDiskObject.getSize();
        } else {
            VirtualDiskObject.objectUniqueNumber--;
        }
    }

    void virtualDiskObjectDeletion(String name) {
        VirtualDiskObject virtualDiskObject = findVirtualDiskObject(name);
        if (virtualDiskObject != null) {
            virtualDiskObjects.remove(virtualDiskObject);
            diskMemoryUsed -= virtualDiskObject.getSize();
            erasingFromMemoryArray(virtualDiskObject);
        }
    }

    private VirtualDiskObject findVirtualDiskObject(String name) {
        for (VirtualDiskObject virtualDiskObject : virtualDiskObjects) {
            if (virtualDiskObject.getName().equals(name)) {
                return virtualDiskObject;
            }
        }

        return null;
    }

    //Надо найти более оптимальный вариант заполнения ячеек памяти
    private void writingToMemoryArray(VirtualDiskObject virtualDiskObject) {
        int counter = 0;
        int memoryCellIndex = 0;
        while(virtualDiskObject.size != counter) {
            if (diskArray[memoryCellIndex] == 0) {
                diskArray[memoryCellIndex] = virtualDiskObject.uniqueNumber;
                counter++;
            }
            memoryCellIndex++;
        }
    }

    private void erasingFromMemoryArray(VirtualDiskObject virtualDiskObject) {
        int counter = virtualDiskObject.size;
        for (int i = 0; i < diskArray.length; i++) {
            if (virtualDiskObject.uniqueNumber == diskArray[i]) {
                diskArray[i] = 0;
                counter--;
            }
            if (counter == 0) {
                break;
            }
        }
    }

    void diskDefragmentation() {
        boolean isSorted = false;
        while(!isSorted) {
            isSorted = true;
            for (int i = diskArray.length - 1; 1 <= i; i--) {
                if (diskArray[i] > diskArray[i - 1]) {
                    int temp = diskArray[i];
                    diskArray[i] = diskArray[i - 1];
                    diskArray[i - 1] = temp;
                    isSorted = false;
                }
            }
        }
    }

    private boolean nameIsLessThan20Char(VirtualDiskObject virtualDiskObject) {
        return virtualDiskObject.getName().length() <= Folder.MAX_CHAR;
    }

    private boolean isEnoughMemory(VirtualDiskObject virtualDiskObject) {
        return diskMaxMemory >= (diskMemoryUsed + virtualDiskObject.size);
    }

    private char diskName() {
        VirtualDiskObject.resetObjectUniqueNumber();
        return diskChar++;
    }
}
