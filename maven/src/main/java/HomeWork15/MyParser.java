package HomeWork15;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.gson.Gson;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyParser {
    private String resourcesLocation;
    private File[] fileList;
    private String result;
    private final String newResourcesLocation = FileSystems.getDefault().getPath("").toAbsolutePath().toString() + "/src/main/resources/convert/";

    public MyParser() {
        this.resourcesLocation = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
        this.fileList = new File(resourcesLocation).listFiles();
    }

    public MyParser(String resourcesLocation) {
        this.resourcesLocation = resourcesLocation;
        this.fileList = new File(resourcesLocation).listFiles();
    }

    public void parse() throws Exception {
        for (File file : fileList) {
            condition(file);
        }
    }

    public void condition(File file) throws Exception {
        if (file.getName().equals("target") || file.getName().equals("test") || file.getName().equals(".idea")) {
            return;
        }
        if (file.isFile()) {
            checkFiles(file);
        } else {
            for (File f : file.listFiles()) {
                condition(f);
            }
        }
    }

    public String getResourcesLocation() {
        return resourcesLocation;
    }

    public String getNewResourcesLocation() {
        return newResourcesLocation;
    }

    public void checkFiles(File file) throws Exception {
        String[] arr = file.getName().split("\\.");
        if (arr[1].equals("yaml")) {
            resourcesLocation = file.getParent();
            new File(newResourcesLocation).mkdir();
            parseYamlToJson(file, arr);
        } else {
            if (arr[1].equals("json")) {
                resourcesLocation = file.getParent();
                new File(newResourcesLocation).mkdir();
                parseJsonToYaml(file, arr);
            } else {
                String currRes = file.getName() + ": Different type of file, can't convert ";
                result += currRes + "\n";
            }
        }
    }

    public void parseYamlToJson(File file, String[] name) throws Exception {
        long m = System.currentTimeMillis();
        String newFileName = name[0] + ".json";
        List<Character> chars = new ArrayList<>();
        try (FileReader fr = new FileReader(file.getPath())) {
            int a;
            while ((a = fr.read()) != -1) {
                chars.add((char) a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str = chars.stream().map(Object::toString).collect(Collectors.joining());
        Yaml yaml = new Yaml();
        Object obj = yaml.load(str);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(obj);
        try (FileWriter fw = new FileWriter(newResourcesLocation + newFileName)) {
            fw.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        result += "Файл - " + file.getName() + " сконверировался в фаил - " + newFileName + " успешно." + "\n" +
                "Старый размер : " + file.length() + " байт" + "\n" +
                "Новый размер : " + new File(newResourcesLocation + newFileName).length() + " байт" + "\n" +
                "Время выполнения конвертации : " + (double) (System.currentTimeMillis() - m) + " мс" + "\n";
    }

    public void parseJsonToYaml(File file, String[] name) throws Exception {
        long m = System.currentTimeMillis();
        String newFileName = name[0] + ".yaml";
        List<Character> chars = new ArrayList<>();
        try (FileReader fr = new FileReader(file.getPath())) {
            int a;
            while ((a = fr.read()) != -1) {
                chars.add((char) a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str = chars.stream().map(Object::toString).collect(Collectors.joining());
        Gson gson = new Gson();
        Object obj = gson.fromJson(str, Object.class);
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        String yaml = mapper.writeValueAsString(obj);
        try (FileWriter fw = new FileWriter(newResourcesLocation + newFileName)) {
            fw.write(yaml);
        } catch (IOException e) {
            e.printStackTrace();
        }
        result += "Файл - " + file.getName() + " сконверировался в фаил - " + newFileName + " успешно." + "\n" +
                "Старый размер : " + file.length() + " байт" + "\n" +
                "Новый размер : " + new File(newResourcesLocation + newFileName).length() + " байт" + "\n" +
                "Время выполнения конвертации : " + (double) (System.currentTimeMillis() - m) + " мс" + "\n";
    }

    public void saveResult() {
        try (FileWriter fw = new FileWriter(resourcesLocation + "/result.txt", true)) {
            fw.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

