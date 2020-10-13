package personal.file_system.models;

import personal.file_system.miscs.FileType;

public class File extends DiskObject {

    FileType fileType;

    public File(String name, int size, FileType fileType) {
        this.name = name;
        this.size = MIN_SIZE + size;
        this.fileType = fileType;
    }

    public void setDirectory(String directory) {
        this.directory = directory + "\\" + name + "." + fileType;
    }

    @Override
    public String toString() {
        return "File{" +
                "fileType=" + fileType +
                ", directory='" + directory + '\'' +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", uniqueNumber=" + uniqueNumber +
                '}';
    }
}
