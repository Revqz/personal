package personal.file_system;

import personal.file_system.exceptions.InvalidDiskObjectException;
import personal.file_system.exceptions.NoSuchNameException;
import personal.file_system.miscs.FileType;
import personal.file_system.miscs.PrintInformationUtils;
import personal.file_system.models.VirtualDisk;
import personal.file_system.services.VirtualDiskService;

class FileSystemDemo {

    public static void main(String[] args)
            throws NoSuchNameException, InvalidDiskObjectException {

        VirtualDisk virtualDisk = new VirtualDisk(40);
        VirtualDiskService virtualDiskService = new VirtualDiskService(virtualDisk);

        PrintInformationUtils.printDiskName(virtualDisk);
        PrintInformationUtils.printDiskCurrentMemoryUsed(virtualDisk);
        PrintInformationUtils.printDiskMemoryArray(virtualDisk);
        PrintInformationUtils.printDiskObjects(virtualDisk);

        System.out.println("Creating two folders, 1 subfolder and 1 file");
        virtualDiskService.createFolder("Test1");
        virtualDiskService.createFolder("Test2");
        virtualDiskService.createSubFolder("Test2", "Test2 sub folder");
        virtualDiskService.createFile("Game", 10, FileType.EXE);

        PrintInformationUtils.printDiskCurrentMemoryUsed(virtualDisk);
        PrintInformationUtils.printDiskMemoryArray(virtualDisk);
        PrintInformationUtils.printDiskObjects(virtualDisk);

        System.out.println("Creating sub folder with too long name");
        virtualDiskService.createSubFolder("Test1", "Too long name to create folder");

        PrintInformationUtils.printDiskCurrentMemoryUsed(virtualDisk);
        PrintInformationUtils.printDiskMemoryArray(virtualDisk);
        PrintInformationUtils.printDiskObjects(virtualDisk);

        System.out.println("Deleting folder 'Test2'");
        virtualDiskService.deleteDiskObject("Test2");

        PrintInformationUtils.printDiskCurrentMemoryUsed(virtualDisk);
        PrintInformationUtils.printDiskMemoryArray(virtualDisk);
        PrintInformationUtils.printDiskObjects(virtualDisk);

        System.out.println("Creating txt file 'Test3'");
        virtualDiskService.createFile("Test3", 5, FileType.TXT);

        PrintInformationUtils.printDiskCurrentMemoryUsed(virtualDisk);
        PrintInformationUtils.printDiskMemoryArray(virtualDisk);
        PrintInformationUtils.printDiskObjects(virtualDisk);

        System.out.println("Using defragmentation");
        virtualDiskService.diskDefragmentation();

        PrintInformationUtils.printDiskMemoryArray(virtualDisk);

        VirtualDisk virtualDisk1 = new VirtualDisk(70);
        VirtualDiskService virtualDiskService1 = new VirtualDiskService(virtualDisk1);

        PrintInformationUtils.printDiskName(virtualDisk1);
        PrintInformationUtils.printDiskCurrentMemoryUsed(virtualDisk1);
        PrintInformationUtils.printDiskMemoryArray(virtualDisk1);
        PrintInformationUtils.printDiskObjects(virtualDisk1);

        System.out.println("Creating folder 'Test4'");
        virtualDiskService1.createFolder("Test4");

        PrintInformationUtils.printDiskCurrentMemoryUsed(virtualDisk1);
        PrintInformationUtils.printDiskMemoryArray(virtualDisk1);
        PrintInformationUtils.printDiskObjects(virtualDisk1);


        System.out.println("Creating text file");
        virtualDiskService1.createFile("Random text", 30, FileType.TXT);

        PrintInformationUtils.printDiskCurrentMemoryUsed(virtualDisk1);
        PrintInformationUtils.printDiskMemoryArray(virtualDisk1);
        PrintInformationUtils.printDiskObjects(virtualDisk1);

        System.out.println("Creating folder and subfolder");
        virtualDiskService1.createFolder("Test5");
        virtualDiskService1.createSubFolder("Test5", "Test5 in");

        PrintInformationUtils.printDiskCurrentMemoryUsed(virtualDisk1);
        PrintInformationUtils.printDiskMemoryArray(virtualDisk1);
        PrintInformationUtils.printDiskObjects(virtualDisk1);

        System.out.println("Trying to create file bigger than disk remaining memory");
        virtualDiskService1.createFile("Big File", 80, FileType.JAVA);

        PrintInformationUtils.printDiskCurrentMemoryUsed(virtualDisk1);

        System.out.println("Deleting text file and folder 'Test5'");
        virtualDiskService1.deleteDiskObject("Random text");
        virtualDiskService1.deleteDiskObject("Test5");

        PrintInformationUtils.printDiskCurrentMemoryUsed(virtualDisk1);
        PrintInformationUtils.printDiskMemoryArray(virtualDisk1);
        PrintInformationUtils.printDiskObjects(virtualDisk1);

        System.out.println("Creating exe file");
        virtualDiskService1.createFile("Random text", 30, FileType.EXE);

        PrintInformationUtils.printDiskCurrentMemoryUsed(virtualDisk1);
        PrintInformationUtils.printDiskMemoryArray(virtualDisk1);
        PrintInformationUtils.printDiskObjects(virtualDisk1);

        System.out.println("Creating txt file in Test4 folder");
        virtualDiskService1.createFileInFolder("Test4", "Text test", 10, FileType.TXT);

        PrintInformationUtils.printDiskCurrentMemoryUsed(virtualDisk1);
        PrintInformationUtils.printDiskMemoryArray(virtualDisk1);
        PrintInformationUtils.printDiskObjects(virtualDisk1);

        virtualDiskService1.diskDefragmentation();
        PrintInformationUtils.printDiskMemoryArray(virtualDisk1);
    }
}
