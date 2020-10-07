package Personal.file_system;

class FileSystemDemo {

    public static void main(String[] args) throws NoSuchNameException {

        VirtualDisk virtualDisk = new VirtualDisk(40);
        VirtualDiskService virtualDiskService = new VirtualDiskService(virtualDisk);

        PrintInformationUtils.printVirtualDiskName(virtualDisk);
        PrintInformationUtils.printVirtualDiskCurrentMemoryUsed(virtualDisk);
        PrintInformationUtils.printVirtualDiskMemoryArray(virtualDisk);
        PrintInformationUtils.printVirtualDiskObjects(virtualDisk);

        System.out.println("Creating two folders, 1 subfolder and 1 file");
        virtualDiskService.createFolder("Test1");
        virtualDiskService.createFolder("Test2");
        virtualDiskService.createSubfolder("Test2 sub folder", "Test2");
        virtualDiskService.createFile("Game", 10, FileType.EXE);

        PrintInformationUtils.printVirtualDiskCurrentMemoryUsed(virtualDisk);
        PrintInformationUtils.printVirtualDiskMemoryArray(virtualDisk);
        PrintInformationUtils.printVirtualDiskObjects(virtualDisk);

        System.out.println("Deleting folder 'Test2'");
        virtualDiskService.virtualDiskObjectDeletion("Test2");

        PrintInformationUtils.printVirtualDiskCurrentMemoryUsed(virtualDisk);
        PrintInformationUtils.printVirtualDiskMemoryArray(virtualDisk);
        PrintInformationUtils.printVirtualDiskObjects(virtualDisk);

        System.out.println("Creating txt file 'Test3'");
        virtualDiskService.createFile("Test3", 5, FileType.TXT);

        PrintInformationUtils.printVirtualDiskCurrentMemoryUsed(virtualDisk);
        PrintInformationUtils.printVirtualDiskMemoryArray(virtualDisk);
        PrintInformationUtils.printVirtualDiskObjects(virtualDisk);

        System.out.println("Using defragmentation");
        virtualDiskService.diskDefragmentation();

        PrintInformationUtils.printVirtualDiskMemoryArray(virtualDisk);

        VirtualDisk virtualDisk1 = new VirtualDisk(70);
        VirtualDiskService virtualDiskService1 = new VirtualDiskService(virtualDisk1);

        PrintInformationUtils.printVirtualDiskName(virtualDisk1);
        PrintInformationUtils.printVirtualDiskCurrentMemoryUsed(virtualDisk1);
        PrintInformationUtils.printVirtualDiskMemoryArray(virtualDisk1);
        PrintInformationUtils.printVirtualDiskObjects(virtualDisk1);

        System.out.println("Creating folder 'Test4'");
        virtualDiskService1.createFolder("Test4");

        PrintInformationUtils.printVirtualDiskCurrentMemoryUsed(virtualDisk1);
        PrintInformationUtils.printVirtualDiskMemoryArray(virtualDisk1);
        PrintInformationUtils.printVirtualDiskObjects(virtualDisk1);


        System.out.println("Creating text file");
        virtualDiskService1.createFile("Random text", 30, FileType.TXT);

        PrintInformationUtils.printVirtualDiskCurrentMemoryUsed(virtualDisk1);
        PrintInformationUtils.printVirtualDiskMemoryArray(virtualDisk1);
        PrintInformationUtils.printVirtualDiskObjects(virtualDisk1);

        System.out.println("Creating folder and subfolder");
        virtualDiskService1.createFolder("Test5");
        virtualDiskService1.createSubfolder("Test5 in", "Test5");

        PrintInformationUtils.printVirtualDiskCurrentMemoryUsed(virtualDisk1);
        PrintInformationUtils.printVirtualDiskMemoryArray(virtualDisk1);
        PrintInformationUtils.printVirtualDiskObjects(virtualDisk1);

        System.out.println("Trying to create file bigger than disk remaining memory");
        virtualDiskService1.createFile("Big File", 80, FileType.JAVA);

        PrintInformationUtils.printVirtualDiskCurrentMemoryUsed(virtualDisk1);

        System.out.println("Deleting text file and folder 'Test5'");
        virtualDiskService1.virtualDiskObjectDeletion("Random text");
        virtualDiskService1.virtualDiskObjectDeletion("Test5");

        PrintInformationUtils.printVirtualDiskCurrentMemoryUsed(virtualDisk1);
        PrintInformationUtils.printVirtualDiskMemoryArray(virtualDisk1);
        PrintInformationUtils.printVirtualDiskObjects(virtualDisk1);

        System.out.println("Creating exe file");
        virtualDiskService1.createFile("Random text", 30, FileType.EXE);

        PrintInformationUtils.printVirtualDiskCurrentMemoryUsed(virtualDisk1);
        PrintInformationUtils.printVirtualDiskMemoryArray(virtualDisk1);
        PrintInformationUtils.printVirtualDiskObjects(virtualDisk1);

        virtualDiskService1.diskDefragmentation();
        PrintInformationUtils.printVirtualDiskMemoryArray(virtualDisk1);
    }
}
