package Personal.FileSystem;

class FileSystemDemo {

    public static void main(String[] args) {

        VirtualDisk virtualDisk = new VirtualDisk(40);

        PrintInformation.printVirtualDiskName(virtualDisk);
        PrintInformation.printVirtualDiskCurrentMemoryUsed(virtualDisk);
        PrintInformation.printVirtualDiskMemoryArray(virtualDisk);
        PrintInformation.printVirtualDiskObjects(virtualDisk);

        System.out.println("Creating two folders, 1 subfolder and 1 file");
        virtualDisk.createFolder("Test1");
        virtualDisk.createFolder("Test2");
        virtualDisk.createSubfolder("Test2 sub folder", "Test2");
        virtualDisk.createFile("Game", 10, FileType.EXE);

        PrintInformation.printVirtualDiskCurrentMemoryUsed(virtualDisk);
        PrintInformation.printVirtualDiskMemoryArray(virtualDisk);
        PrintInformation.printVirtualDiskObjects(virtualDisk);

        System.out.println("Deleting folder 'Test2'");
        virtualDisk.virtualDiskObjectDeletion("Test2");

        PrintInformation.printVirtualDiskCurrentMemoryUsed(virtualDisk);
        PrintInformation.printVirtualDiskMemoryArray(virtualDisk);
        PrintInformation.printVirtualDiskObjects(virtualDisk);

        System.out.println("Creating txt file 'Test3'");
        virtualDisk.createFile("Test3", 5, FileType.TXT);

        PrintInformation.printVirtualDiskCurrentMemoryUsed(virtualDisk);
        PrintInformation.printVirtualDiskMemoryArray(virtualDisk);
        PrintInformation.printVirtualDiskObjects(virtualDisk);

        System.out.println("Using defragmentation");
        virtualDisk.diskDefragmentation();

        PrintInformation.printVirtualDiskMemoryArray(virtualDisk);

        VirtualDisk virtualDisk1 = new VirtualDisk(70);

        PrintInformation.printVirtualDiskName(virtualDisk1);
        PrintInformation.printVirtualDiskCurrentMemoryUsed(virtualDisk1);
        PrintInformation.printVirtualDiskMemoryArray(virtualDisk1);
        PrintInformation.printVirtualDiskObjects(virtualDisk1);

        System.out.println("Creating folder 'Test4'");
        virtualDisk1.createFolder("Test4");

        PrintInformation.printVirtualDiskCurrentMemoryUsed(virtualDisk1);
        PrintInformation.printVirtualDiskMemoryArray(virtualDisk1);
        PrintInformation.printVirtualDiskObjects(virtualDisk1);

        System.out.println("Creating text file");
        virtualDisk1.createFile("Random text", 30, FileType.TXT);

        PrintInformation.printVirtualDiskCurrentMemoryUsed(virtualDisk1);
        PrintInformation.printVirtualDiskMemoryArray(virtualDisk1);
        PrintInformation.printVirtualDiskObjects(virtualDisk1);

        System.out.println("Creating folder and subfolder");
        virtualDisk1.createFolder("Test5");
        virtualDisk1.createSubfolder("Test5 in", "Test5");

        PrintInformation.printVirtualDiskCurrentMemoryUsed(virtualDisk1);
        PrintInformation.printVirtualDiskMemoryArray(virtualDisk1);
        PrintInformation.printVirtualDiskObjects(virtualDisk1);

        System.out.println("Trying to create file bigger than disk remaining memory");
        virtualDisk1.createFile("Big File", 80, FileType.JAVA);

        PrintInformation.printVirtualDiskCurrentMemoryUsed(virtualDisk1);

        System.out.println("Deleting text file and folder 'Test5'");
        virtualDisk1.virtualDiskObjectDeletion("Random text");
        virtualDisk1.virtualDiskObjectDeletion("Test5");

        PrintInformation.printVirtualDiskCurrentMemoryUsed(virtualDisk1);
        PrintInformation.printVirtualDiskMemoryArray(virtualDisk1);
        PrintInformation.printVirtualDiskObjects(virtualDisk1);

        System.out.println("Creating exe file");
        virtualDisk1.createFile("Random text", 30, FileType.EXE);

        PrintInformation.printVirtualDiskCurrentMemoryUsed(virtualDisk1);
        PrintInformation.printVirtualDiskMemoryArray(virtualDisk1);
        PrintInformation.printVirtualDiskObjects(virtualDisk1);

        virtualDisk1.diskDefragmentation();
        PrintInformation.printVirtualDiskMemoryArray(virtualDisk1);
    }
}
