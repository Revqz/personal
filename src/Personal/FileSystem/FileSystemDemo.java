package Personal.FileSystem;

import java.util.Arrays;

class FileSystemDemo {

    public static void main(String[] args) {

        VirtualDisk virtualDisk = new VirtualDisk(100);

        virtualDisk.createVirtualDiskObject("Test1");
        virtualDisk.createVirtualDiskObject("Test2");
        System.out.println(Arrays.toString(virtualDisk.getDiskArray()));
        virtualDisk.createVirtualDiskObject("Game", 50, FileType.EXE);
        virtualDisk.createVirtualDiskObject("Test2 sub folder", "Test2");
        virtualDisk.folderDeletion("Test2");


        System.out.println(virtualDisk.getDiskName());
        System.out.println(virtualDisk.getDiskCurrentSize());
        System.out.println(virtualDisk.getVirtualDiskObjects());

        System.out.println(Arrays.toString(virtualDisk.getDiskArray()));

        VirtualDisk virtualDisk1 = new VirtualDisk(70);

        virtualDisk1.createVirtualDiskObject("Test3");
        virtualDisk1.createVirtualDiskObject("Test3 in", "Test3");
        System.out.println();

        System.out.println(virtualDisk1.getDiskName());
        System.out.println(virtualDisk1.getDiskCurrentSize());

        virtualDisk1.createVirtualDiskObject("Big File", 1700, FileType.JAVA);

        System.out.println(virtualDisk1.getDiskCurrentSize());

        virtualDisk1.createVirtualDiskObject("Random text", 30, FileType.TXT);
        System.out.println(virtualDisk1.getDiskCurrentSize());

        virtualDisk1.folderDeletion("Random text");

        System.out.println(virtualDisk1.getDiskCurrentSize());

        System.out.println(Arrays.toString(virtualDisk1.getDiskArray()));
    }
}
