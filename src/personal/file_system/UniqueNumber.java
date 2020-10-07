package personal.file_system;

class UniqueNumber {

    private static int objectUniqueNumber = 1;

    private UniqueNumber() {
    }

    static int uniqueNumberGeneration() {
        return objectUniqueNumber++;
    }

    static void resetUniqueNumber() {
        objectUniqueNumber = 1;
    }
}
