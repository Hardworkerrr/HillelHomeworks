import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("messagesBundle.Lang", new Locale("en"));
        System.out.println(resourceBundle.getString("monday"));
    }
}
