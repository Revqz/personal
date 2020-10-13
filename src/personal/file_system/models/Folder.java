package personal.file_system.models;

public class Folder extends DiskObject {


    public Folder(String name) {
        this.name = name;
        this.size = MIN_SIZE;
    }
}

