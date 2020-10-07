package Personal.file_system;

import Personal.file_system.models.File;
import Personal.file_system.models.Folder;
import Personal.file_system.models.SubFolder;
import Personal.file_system.models.VirtualDiskObject;

import java.util.List;

class VirtualDiskService {

    private final VirtualDisk virtualDisk;

    VirtualDiskService(VirtualDisk virtualDisk) {
        this.virtualDisk = virtualDisk;
        UniqueNumber.resetUniqueNumber();
    }

    void createFolder(String name) {
        VirtualDiskObject folder = new Folder(name);
        addingVirtualDiskObjectToDisk(folder);
    }

    void createFile(String name, int size, FileType fileType) {
        VirtualDiskObject file = new File(name, size, fileType);
        addingVirtualDiskObjectToDisk(file);
    }

    void createSubfolder(String subFolderName, String folderName) throws NoSuchNameException {
        SubFolder subFolder = new SubFolder(subFolderName);
        VirtualDiskObject folder = findVirtualDiskObject(folderName);
        if (nameIsLessThan20Char(subFolder) && isEnoughMemory(subFolder)) {
            folder.addSubFolderToFolderList(subFolder);
            subFolder.setUniqueNumber(UniqueNumber.uniqueNumberGeneration());
            writingToMemoryArray(subFolder);
            virtualDisk.setDiskMemoryUsed(decreaseUsedMemory(subFolder));
        }
    }

    private void addingVirtualDiskObjectToDisk(VirtualDiskObject virtualDiskObject) {
        if (nameIsLessThan20Char(virtualDiskObject) && isEnoughMemory(virtualDiskObject)) {
            List<VirtualDiskObject> virtualDiskObjects = virtualDisk.getVirtualDiskObjects();
            virtualDiskObjects.add(virtualDiskObject);
            virtualDiskObject.setUniqueNumber(UniqueNumber.uniqueNumberGeneration());
            writingToMemoryArray(virtualDiskObject);
            virtualDisk.setDiskMemoryUsed(increaseUsedMemory(virtualDiskObject));
            virtualDisk.setVirtualDiskObjects(virtualDiskObjects);
        }
    }

    void virtualDiskObjectDeletion(String name) throws NoSuchNameException {
        List<VirtualDiskObject> virtualDiskObjects = virtualDisk.getVirtualDiskObjects();
        VirtualDiskObject virtualDiskObject = findVirtualDiskObject(name);
        virtualDiskObjects.remove(virtualDiskObject);
        virtualDisk.setDiskMemoryUsed(decreaseUsedMemory(virtualDiskObject));
        erasingFromMemoryArray(virtualDiskObject);
        virtualDisk.setVirtualDiskObjects(virtualDiskObjects);
    }

    private VirtualDiskObject findVirtualDiskObject(String name) throws NoSuchNameException {
        for (VirtualDiskObject virtualDiskObject : virtualDisk.getVirtualDiskObjects()) {
            if (virtualDiskObject.getName().equals(name)) {
                return virtualDiskObject;
            }
        }
        throw new NoSuchNameException();
    }

    private void writingToMemoryArray(VirtualDiskObject virtualDiskObject) {
        int[] diskArray = virtualDisk.getDiskArray();
        int counter = 0;
        int memoryCellIndex = 0;
        while(virtualDiskObject.getSize() != counter) {
            if (diskArray[memoryCellIndex] == 0) {
                diskArray[memoryCellIndex] = virtualDiskObject.getUniqueNumber();
                counter++;
            }
            memoryCellIndex++;
        }
        virtualDisk.setDiskArray(diskArray);
    }

    private void erasingFromMemoryArray(VirtualDiskObject virtualDiskObject) {
        int[] diskArray = virtualDisk.getDiskArray();
        int counter = virtualDiskObject.getSize();
        for (int i = 0; i < diskArray.length; i++) {
            if (virtualDiskObject.getUniqueNumber() == diskArray[i]) {
                diskArray[i] = 0;
                counter--;
            }
            if (counter == 0) {
                break;
            }
        }
        virtualDisk.setDiskArray(diskArray);
    }

    void diskDefragmentation() {
        int[] diskArray = virtualDisk.getDiskArray();
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
        virtualDisk.setDiskArray(diskArray);
    }

    private boolean nameIsLessThan20Char(VirtualDiskObject virtualDiskObject) {
        return virtualDiskObject.getName().length() <= VirtualDiskObject.MAX_CHAR;
    }

    private boolean isEnoughMemory(VirtualDiskObject virtualDiskObject) {
        return virtualDisk.getDiskMaxMemory() >= (virtualDisk.getDiskMemoryUsed() + virtualDiskObject.getSize());
    }

    private int increaseUsedMemory(VirtualDiskObject virtualDiskObject) {
        return virtualDisk.getDiskMemoryUsed() + virtualDiskObject.getSize();
    }

    private int decreaseUsedMemory(VirtualDiskObject virtualDiskObject) {
        return virtualDisk.getDiskMemoryUsed() - virtualDiskObject.getSize();
    }
}
