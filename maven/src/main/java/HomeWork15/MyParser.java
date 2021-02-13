package HomeWork15;

import java.nio.file.FileSystems;


public class MyParser {
    private String resourcesLocation;

    public MyParser() throws Exception {
        this.resourcesLocation = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
        new WorkWithFiles(resourcesLocation);
    }

    public MyParser(String resourcesLocation) throws Exception {
        this.resourcesLocation = resourcesLocation;
        new WorkWithFiles(resourcesLocation);
    }

}

