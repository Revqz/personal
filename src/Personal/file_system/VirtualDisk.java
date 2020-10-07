package Personal.file_system;

import Personal.file_system.models.VirtualDiskObject;

import java.util.ArrayList;
import java.util.List;

class VirtualDisk {

    static char diskChar = 'C';

    private char diskName;
    private int diskMaxMemory;
    private int diskMemoryUsed;
    private List<VirtualDiskObject> virtualDiskObjects;
    private int[] diskArray;

    VirtualDisk(int diskMaxMemory) {
        this.diskName = diskChar++;
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

    static void setDiskChar(char diskChar) {
        VirtualDisk.diskChar = diskChar;
    }

    void setDiskName(char diskName) {
        this.diskName = diskName;
    }

    void setDiskMaxMemory(int diskMaxMemory) {
        this.diskMaxMemory = diskMaxMemory;
    }

    void setDiskMemoryUsed(int diskMemoryUsed) {
        this.diskMemoryUsed = diskMemoryUsed;
    }

    void setVirtualDiskObjects(List<VirtualDiskObject> virtualDiskObjects) {
        this.virtualDiskObjects = virtualDiskObjects;
    }

    void setDiskArray(int[] diskArray) {
        this.diskArray = diskArray;
    }

    //    void createFolder(String name) {
//        VirtualDiskObject folder = new Folder(name);
//        addingVirtualDiskObjectToDisk(folder);
//    }
//
//    void createFile(String name, int size, FileType fileType) {
//        VirtualDiskObject file = new File(name, size, fileType);
//        addingVirtualDiskObjectToDisk(file);
//    }
//
//    void createSubfolder(String subFolderName, String folderName) {
//        SubFolder subFolder = new SubFolder(subFolderName);
//        VirtualDiskObject folder = findVirtualDiskObject(folderName);
//        if (nameIsLessThan20Char(subFolder) && isEnoughMemory(subFolder) && folder != null) {
//            folder.addSubFolderToFolderList(subFolder);
//            writingToMemoryArray(subFolder);
//            diskMemoryUsed += subFolder.size;
//        } else {
//            VirtualDiskObject.objectUniqueNumber--;
//        }
//    }
//
//    void addingVirtualDiskObjectToDisk(VirtualDiskObject virtualDiskObject) {
//        if (nameIsLessThan20Char(virtualDiskObject) && isEnoughMemory(virtualDiskObject)) {
//            virtualDiskObjects.add(virtualDiskObject);
//            writingToMemoryArray(virtualDiskObject);
//            diskMemoryUsed += virtualDiskObject.getSize();
//        } else {
//            VirtualDiskObject.objectUniqueNumber--;
//        }
//    }
//
//    void virtualDiskObjectDeletion(String name) {
//        VirtualDiskObject virtualDiskObject = findVirtualDiskObject(name);
//        if (virtualDiskObject != null) {
//            virtualDiskObjects.remove(virtualDiskObject);
//            diskMemoryUsed -= virtualDiskObject.getSize();
//            erasingFromMemoryArray(virtualDiskObject);
//        }
//    }
//
//    @CodeReviewComment(teacher = "в будущем мы будем проходить исключения, стоит посмотреть, возможно, что будет удобнее, чем возвращать null")
//    private VirtualDiskObject findVirtualDiskObject(String name) {
//        for (VirtualDiskObject virtualDiskObject : virtualDiskObjects) {
//            if (virtualDiskObject.getName().equals(name)) {
//                return virtualDiskObject;
//            }
//        }
//
//        throw new IllegalArgumentException();
//    }
//
//    private void writingToMemoryArray(VirtualDiskObject virtualDiskObject) {
//        int counter = 0;
//        int memoryCellIndex = 0;
//        while(virtualDiskObject.size != counter) {
//            if (diskArray[memoryCellIndex] == 0) {
//                diskArray[memoryCellIndex] = virtualDiskObject.uniqueNumber;
//                counter++;
//            }
//            memoryCellIndex++;
//        }
//    }
//
//    private void erasingFromMemoryArray(VirtualDiskObject virtualDiskObject) {
//        int counter = virtualDiskObject.size;
//        for (int i = 0; i < diskArray.length; i++) {
//            if (virtualDiskObject.uniqueNumber == diskArray[i]) {
//                diskArray[i] = 0;
//                counter--;
//            }
//            if (counter == 0) {
//                break;
//            }
//        }
//    }
//
//    void diskDefragmentation() {
//        boolean isSorted = false;
//        while(!isSorted) {
//            isSorted = true;
//            for (int i = diskArray.length - 1; 1 <= i; i--) {
//                if (diskArray[i] > diskArray[i - 1]) {
//                    int temp = diskArray[i];
//                    diskArray[i] = diskArray[i - 1];
//                    diskArray[i - 1] = temp;
//                    isSorted = false;
//                }
//            }
//        }
//    }
//
//    private boolean nameIsLessThan20Char(VirtualDiskObject virtualDiskObject) {
//        return virtualDiskObject.getName().length() <= Folder.MAX_CHAR;
//    }
//
//    private boolean isEnoughMemory(VirtualDiskObject virtualDiskObject) {
//        return diskMaxMemory >= (diskMemoryUsed + virtualDiskObject.size);
//    }
//
//    private char diskName() {
//        VirtualDiskObject.resetObjectUniqueNumber();
//        return diskChar++;
//    }
}
