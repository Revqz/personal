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
        if (isLessThan20CharName(subFolder) && isEnoughMemory(subFolder) && folder != null) {
            folder.addSubFolderToFolderList(subFolder);
            writingToMemoryArray(subFolder);
            diskMemoryUsed += subFolder.size;
        } else {
            VirtualDiskObject.objectUniqueNumber--;
        }
    }

    void addingVirtualDiskObjectToDisk(VirtualDiskObject virtualDiskObject) {
        if (isLessThan20CharName(virtualDiskObject) && isEnoughMemory(virtualDiskObject)) {
            virtualDiskObjects.add(virtualDiskObject);
            writingToMemoryArray(virtualDiskObject);
            diskMemoryUsed += virtualDiskObject.getSize();
        } else {
            VirtualDiskObject.objectUniqueNumber--;
        }
    }

    void folderDeletion(String name) {
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
        int memoryIndex = 0;
        while(virtualDiskObject.size != counter) {
            if (diskArray[memoryIndex] == 0) {
                diskArray[memoryIndex] = virtualDiskObject.uniqueNumber;
                counter++;
            }
            memoryIndex++;
        }
    }

    private void erasingFromMemoryArray(VirtualDiskObject virtualDiskObject) {
        for (int i = findingUniqueNumberInDiskArray(virtualDiskObject);
             i < findingUniqueNumberInDiskArray(virtualDiskObject) + virtualDiskObject.size; i++) {
            diskArray[i] = 0;
        }
    }

    private int findingUniqueNumberInDiskArray(VirtualDiskObject virtualDiskObject) {
        int uniqueNumber = 0;
        for (int i = 0; i < diskArray.length; i++) {
            if (virtualDiskObject.uniqueNumber == diskArray[i]) {
                uniqueNumber = i;
                break;
            }
        }

        return uniqueNumber;
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

    private boolean isLessThan20CharName(VirtualDiskObject virtualDiskObject) {
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
