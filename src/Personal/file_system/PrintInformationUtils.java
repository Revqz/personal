package Personal.file_system;

import java.util.Arrays;

class PrintInformationUtils {

    private PrintInformationUtils() {
    }

    static void printVirtualDiskName(VirtualDisk virtualDisk) {
        System.out.println("Virtual disk name: " + virtualDisk.getDiskName());
        System.out.println();
    }

    static void printVirtualDiskMemoryArray(VirtualDisk virtualDisk) {
        System.out.println("Virtual disk memory array:");
        System.out.println(Arrays.toString(virtualDisk.getDiskArray()));
        System.out.println();
    }

    static void printVirtualDiskCurrentMemoryUsed(VirtualDisk virtualDisk) {
        System.out.println("Virtual disk memory used: " + "["
                + virtualDisk.getDiskMemoryUsed() + "/"
                + virtualDisk.getDiskMaxMemory() + "]");
        System.out.println();
    }

    static void printVirtualDiskObjects(VirtualDisk virtualDisk) {
        System.out.println(virtualDisk.getVirtualDiskObjects());
        System.out.println();
    }
}
