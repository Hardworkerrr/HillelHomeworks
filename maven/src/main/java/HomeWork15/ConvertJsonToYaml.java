package HomeWork15;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.gson.Gson;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertJsonToYaml implements Converts {
    File file;
    String[] name;

    public ConvertJsonToYaml(File file, String[] name) {
        this.file=file;
        this.name=name;
    }

    @Override
    public void convert() throws JsonProcessingException {
        long m = System.currentTimeMillis();
        String newFileName = name[0] + ".yaml";
        List<Character> chars = WorkWithFiles.readFromFile(file.getPath());
        String str = chars.stream().map(Object::toString).collect(Collectors.joining());
        Gson gson = new Gson();
        Object obj = gson.fromJson(str, Object.class);
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        String yaml = mapper.writeValueAsString(obj);
        WorkWithFiles.saveConvert(yaml,newFileName);
        WorkWithFiles.saveResult(file.getName(),newFileName,file.length(),(double) (System.currentTimeMillis() - m));
    }
}
