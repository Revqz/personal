package personal.file_system.models;

import personal.file_system.FileType;

public class File extends VirtualDiskObject {

    FileType fileType;

    public File(String name, int size, FileType fileType) {
        this.name = name;
        this.size = MIN_SIZE + size;
        this.fileType = fileType;
        this.uniqueNumber = 0;
    }

    public void addSubFolderToFolderList(SubFolder subFolder) throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    @Override
    public String toString() {
        return "File{" +
                "fileType=" + fileType +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", uniqueNumber=" + uniqueNumber +
                '}';
    }
}
