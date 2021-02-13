package HomeWork15;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertYamlToJson implements Converts {
    private File file;
    private String[] name;

    public ConvertYamlToJson(File file, String[] name) {
        this.file=file;
        this.name=name;
    }

    @Override
    public void convert() throws Exception {
        long m = System.currentTimeMillis();
        String newFileName = name[0] + ".json";
        List<Character> chars = WorkWithFiles.readFromFile(file.getPath());
        String str = chars.stream().map(Object::toString).collect(Collectors.joining());
        Yaml yaml = new Yaml();
        Object obj = yaml.load(str);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(obj);
        WorkWithFiles.saveConvert(jsonString,newFileName);
        WorkWithFiles.saveResult(file.getName(),newFileName,file.length(),(double) (System.currentTimeMillis() - m));
    }
}
