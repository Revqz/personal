package Personal.FileSystem;

import java.util.ArrayList;
import java.util.List;

class VirtualDisk {

    private static char diskChar = 'C';

    private final char diskName;
    private final int diskMaxiSize;
    private int diskCurrentSize;
    private final List<VirtualDiskObject> virtualDiskObjects;
    private final int[] diskArray;

    VirtualDisk(int diskMaxiSize) {
        this.diskName = diskName();
        this.diskMaxiSize = diskMaxiSize;
        this.diskCurrentSize = 0;
        this.virtualDiskObjects = new ArrayList<>();
        this.diskArray = new int[diskMaxiSize];
    }

    int getDiskCurrentSize() {
        return diskCurrentSize;
    }

    char getDiskName() {
        return diskName;
    }

    int[] getDiskArray() {
        return diskArray;
    }

    List<VirtualDiskObject> getVirtualDiskObjects() {
        return virtualDiskObjects;
    }

    void createVirtualDiskObject(String name) {
        VirtualDiskObject folder = new Folder(name);
        if (isFolderNameContainsLessThan20Characters(folder) && isEnoughMemory(folder)) {
            virtualDiskObjects.add(folder);
            diskCurrentSize += folder.getSize();
            virtualDiskObjectWritingToDiskArray(folder);
        }
    }

    void createVirtualDiskObject(String name, int size, FileType fileType) {
        VirtualDiskObject file = new File(name, size, fileType);
        if (isFolderNameContainsLessThan20Characters(file) && isEnoughMemory(file)) {
            virtualDiskObjects.add(file);
            diskCurrentSize += file.size;
            virtualDiskObjectWritingToDiskArray(file);
        }
    }

    void createVirtualDiskObject(String subFolderName, String folderName) {
        SubFolder subFolder = new SubFolder(subFolderName);
        VirtualDiskObject folder = findVirtualDiskObject(folderName);
        if (isFolderNameContainsLessThan20Characters(subFolder) && isEnoughMemory(subFolder)) {
            folder.addSubFolderToFolderList(subFolder);
            diskCurrentSize += subFolder.size;
            virtualDiskObjectWritingToDiskArray(subFolder);
        }
    }

    void folderDeletion(String name) {
        VirtualDiskObject virtualDiskObject = findVirtualDiskObject(name);
        virtualDiskObjects.remove(virtualDiskObject);
        diskCurrentSize -= virtualDiskObject.getSize();
        virtualDiskObjectErasingFromDiskArray(virtualDiskObject);
    }

    private VirtualDiskObject findVirtualDiskObject(String name) {
        VirtualDiskObject virtualDiskObject = null;
        for (VirtualDiskObject vdo : virtualDiskObjects) {
            if (vdo.getName().equals(name)) {
                virtualDiskObject = vdo;
                break;
            }
        }

        return virtualDiskObject;
    }

    void virtualDiskObjectWritingToDiskArray(VirtualDiskObject virtualDiskObject) {
        for (int i = getDiskCurrentSize() + 1; i <= getDiskCurrentSize() + virtualDiskObject.size; i++) {
            diskArray[i] = virtualDiskObject.uniqueNumber;
        }
    }

    void virtualDiskObjectErasingFromDiskArray(VirtualDiskObject virtualDiskObject) {
        for (int i = findingVirtualDiskObjectUniqueNumberInDiskArray(virtualDiskObject); i < findingVirtualDiskObjectUniqueNumberInDiskArray(virtualDiskObject) + virtualDiskObject.size; i++) {
            diskArray[i] = 0;
        }
    }

    private int findingVirtualDiskObjectUniqueNumberInDiskArray(VirtualDiskObject virtualDiskObject) {
        int uniqueNumber = 0;
        for (int i = 0; i < diskArray.length; i++) {
            if (virtualDiskObject.uniqueNumber == diskArray[i]) {
                uniqueNumber = i;
                break;
            }
        }

        return uniqueNumber;
    }

    private boolean isFolderNameContainsLessThan20Characters(VirtualDiskObject virtualDiskObject) {
        return virtualDiskObject.getName().length() <= Folder.MAX_CHAR;
    }

    private boolean isEnoughMemory(VirtualDiskObject virtualDiskObject) {
        return diskMaxiSize >= (diskCurrentSize + virtualDiskObject.size);
    }

    private char diskName() {
        return diskChar++;
    }
}
