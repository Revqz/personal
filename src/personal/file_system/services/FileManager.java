package personal.file_system.services;


import personal.file_system.exceptions.InvalidDiskObjectException;
import personal.file_system.exceptions.NoSuchNameException;
import personal.file_system.exceptions.NotEnoughMemoryException;
import personal.file_system.exceptions.TooLongNameException;
import personal.file_system.miscs.UniqueNumber;
import personal.file_system.models.DiskObject;
import personal.file_system.models.Folder;
import personal.file_system.models.VirtualDisk;

import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private final VirtualDisk virtualDisk;
    private final DiskMemoryService diskMemoryService;

    public FileManager(VirtualDisk virtualDisk) {
        this.virtualDisk = virtualDisk;
        diskMemoryService = new DiskMemoryService(virtualDisk);
    }

    void addingFolderToFileSystem(DiskObject folder) {
        addingDiskObjectToDisk(folder);
        folder.setDirectory(folder.getDirectory());
    }

    void addingFileToFileSystem(DiskObject file) {
        addingDiskObjectToDisk(file);
        file.setDirectory(file.getDirectory());
    }

    void addingSubObjectToFileSystem(String folderName, DiskObject subObject)
            throws NoSuchNameException, InvalidDiskObjectException {
        DiskObject folder = findDiskObject(folderName);
        if (folder instanceof Folder) {
            addingDiskObjectToDisk(subObject);
            subObject.setDirectory(getDirectory(folderName));

        } else throw new InvalidDiskObjectException();
    }

    void addingFileToSubFolder(String folderName, DiskObject file)
            throws NoSuchNameException, InvalidDiskObjectException {
        DiskObject folder = findDiskObject(folderName);
        if (folder instanceof Folder) {
            addingDiskObjectToDisk(file);
            file.setDirectory(getDirectory(folderName));

        } else throw new InvalidDiskObjectException();
    }

    private String getDirectory(String name) throws NoSuchNameException {
        DiskObject diskObject = findDiskObject(name);
        return diskObject.getDirectory();
    }

    private DiskObject findDiskObject(String name) throws NoSuchNameException {
        for (DiskObject diskObject : virtualDisk.getDiskObjects()) {
            if (diskObject.getName().equals(name)) {
                return diskObject;
            }
        }
        throw new NoSuchNameException();
    }

    private void addingDiskObjectToDisk(DiskObject diskObject) {
        try {
            diskObjectCheckForExceptions(diskObject);
            List<DiskObject> diskObjects = virtualDisk.getDiskObjects();
            diskObjects.add(diskObject);
            diskObject.setUniqueNumber(UniqueNumber.uniqueNumberGeneration());
            diskMemoryService.addingDiskObjectToDiskMemory(diskObject);
            virtualDisk.setDiskObjects(diskObjects);
        } catch (NotEnoughMemoryException | TooLongNameException e) {
            System.out.println(e.getMessage());
        }
    }

    void diskObjectDeletion(String name) throws NoSuchNameException {
        List<DiskObject> diskObjectsToDelete = new ArrayList<>();
        List<DiskObject> diskObjects = virtualDisk.getDiskObjects();
        DiskObject diskObject = findDiskObject(name);
        for (DiskObject diskObj : diskObjects) {
            if (diskObj.getDirectory().contains(diskObject.getDirectory())) {
                diskMemoryService.erasingDiskObjectFromDiskMemory(diskObject);
                diskObjectsToDelete.add(diskObj);
            }
        }
        diskObjects.removeAll(diskObjectsToDelete);
        virtualDisk.setDiskObjects(diskObjects);
    }

    private void diskObjectCheckForExceptions(DiskObject diskObject) throws TooLongNameException, NotEnoughMemoryException {
        checkNameLength(diskObject);
        checkIfEnoughMemory(diskObject);
    }

    private void checkNameLength(DiskObject diskObject) throws TooLongNameException {
        if (diskObject.getName().length() >= DiskObject.MAX_CHAR) {
            throw new TooLongNameException("Name longer than 20 char");
        }
    }

    private void checkIfEnoughMemory(DiskObject diskObject) throws NotEnoughMemoryException {
        if (virtualDisk.getDiskMaxMemory() <= (virtualDisk.getDiskMemoryUsed() + diskObject.getSize())) {
            throw new NotEnoughMemoryException("Not enough memory");
        }
    }
}
