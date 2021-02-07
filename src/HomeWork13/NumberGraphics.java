package HomeWork13;

public class NumberGraphics {
    static String[][] zero = {{"###### "},
                              {"#    # "},
                              {"#    # "},
                              {"#    # "},
                              {"###### "}};
    static String[][] one = {{"  ##   "},
                             {" ###   "},
                             {"# ##   "},
                             {"  ##   "},
                             {"###### "}};
    static String[][] two = {{" ####  "},
                             {"#   ## "},
                             {"   ##  "},
                             {"  ##   "},
                             {"###### "}};
    static String[][] three ={{" ####  "},
                              {"#   ## "},
                              {"   ##  "},
                              {"#   ## "},
                              {" ####  "}};
    static String[][] four ={{"##  ## "},
                             {"##  ## "},
                             {"###### "},
                             {"    ## "},
                             {"    ## "}};
    static String[][] five ={{"###### "},
                             {"#      "},
                             {"#####  "},
                             {"     # "},
                             {"#####  "}};
    static String[][] six = {{" ##### "},
                             {"#      "},
                             {"#####  "},
                             {"#    # "},
                             {" ####  "}};
    static String[][] seven ={{"###### "},
                              {"    #  "},
                              {"   #   "},
                              {"  #    "},
                              {" #     "}};
    static String[][] eight ={{" #####  "},
                              {"#     # "},
                              {" #####  "},
                              {"#     # "},
                              {" #####  "}};
    static String[][] nine ={{"###### "},
                             {"#    # "},
                             {"###### "},
                             {"     # "},
                             {"###### "}};


    static String[] mass = new String[3];

    public NumberGraphics() {

    }


    public static void printNumbers(String str){
        str=str.trim();
        char[] numbers = str.toCharArray();
        String print="";
        for (int i = 0; i < zero.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                switch (numbers[j]){
                    case '0': print+=zero[i][0];
                    break;
                    case '1': print+=one[i][0];
                        break;
                    case '2': print+=two[i][0];
                        break;
                    case '3': print+=three[i][0];
                        break;
                    case '4': print+=four[i][0];
                        break;
                    case '5': print+=five[i][0];
                        break;
                    case '6': print+=six[i][0];
                        break;
                    case '7': print+=seven[i][0];
                        break;
                    case '8': print+=eight[i][0];
                        break;
                    case '9': print+=nine[i][0];
                        break;
                    default:
                        System.out.println("Вы ввели не цифру : " + numbers[j]);
                }
            }
            print+="\n";
        }
        System.out.println(print);
    }
}



