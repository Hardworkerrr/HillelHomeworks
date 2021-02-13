package HomeWork15;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;

public class WorkWithFiles {
    private File[] fileList;
    private static String result="";

    public WorkWithFiles(String resourcesLocation) throws Exception {
        this.fileList = new File(resourcesLocation).listFiles();
        parse();
    }

    public void parse() throws Exception {
        for (File file : fileList) {
            condition(file);
        }
    }

    public void condition(File file) throws Exception {
        if (file.getName().equals("target") || file.getName().equals("test") || file.getName().equals(".idea") || file.getName().equals("convert")) {
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

    public void checkFiles(File file) throws Exception {
        String[] arr = file.getName().split("\\.");
        if (arr[1].equals("yaml")) {
            new File(FileSystems.getDefault().getPath("").toAbsolutePath().toString() + "/convert/").mkdir();
            new ConvertYamlToJson(file, arr).convert();
        } else {
            if (arr[1].equals("json")) {
                new File(FileSystems.getDefault().getPath("").toAbsolutePath().toString() + "/convert/").mkdir();
                new ConvertJsonToYaml(file, arr).convert();
            } else {
                String currRes = file.getName() + ": Different type of file, can't convert ";
                result += currRes + "\n";
            }
        }
    }

    public static List<Character> readFromFile(String path) {
        List<Character> chars = new ArrayList<>();
        try (FileReader fr = new FileReader(path)) {
            int a;
            while ((a = fr.read()) != -1) {
                chars.add((char) a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return chars;
    }

    public static void saveConvert(String jsonString, String newFileName){
        try (FileWriter fw = new FileWriter(FileSystems.getDefault().getPath("").toAbsolutePath().toString() + "/convert/"+ newFileName)) {
            fw.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveResult(String oldFileName,String newFileName, long fileLength, double time ) {
        result += "Файл - " + oldFileName + " сконверировался в фаил - " + newFileName + " успешно." + "\n" +
                "Старый размер : " + fileLength + " байт" + "\n" +
                "Новый размер : " + new File(FileSystems.getDefault().getPath("").toAbsolutePath().toString() + "/convert/" + newFileName).length() + " байт" + "\n" +
                "Время выполнения конвертации : " + time + " мс" + "\n";
    }

    public static void saveTxt() {
        try (FileWriter fw = new FileWriter(FileSystems.getDefault().getPath("").toAbsolutePath().toString() + "/convert/result.txt", true)) {
            fw.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
