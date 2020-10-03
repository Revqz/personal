package Personal.FileSystem;

class SubFolder extends Folder {

    SubFolder(String name) {
        super(name);
        this.size = MIN_SIZE;
        this.uniqueNumber = setUniqueNumber();
    }
}
