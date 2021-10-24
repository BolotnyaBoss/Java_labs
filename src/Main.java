import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Знайти і видрукувати всі трійки слів, які можуть претендувати на прізвище, ім’я та по-батькові деяких осіб.
Видрукувати речення-сусіди для того речення, в якому було знайдено відповідну інформацію.
Замінити знайдену інформацію на найбільшу кількість слів у кожному реченні.
 */

public class Main {

    public static boolean PIBCheck(String sentence){
        String[] wordList = sentence.split(" ");
        for(int i = 0; i < wordList.length - 2; i++){
            if(Character.isUpperCase(wordList[i].charAt(0)) &&
                    Character.isUpperCase(wordList[i+1].charAt(0)) &&
                    Character.isUpperCase(wordList[i+2].charAt(0))) return true;
        }
        return false;
    }

    public static String PIBFind(String sentence){
        String[] w = sentence.split(" ");
        for(int i = 0; i < w.length - 2; i++){
            if(Character.isUpperCase(w[i].charAt(0)) &&
                    Character.isUpperCase(w[i+1].charAt(0)) &&
                    Character.isUpperCase(w[i+2].charAt(0))) return String.join(" ", w[i], w[i+1], w[i+2]);
        }
        return "";
    }

    public static int maxWordCount(List<String> list) {
        int max = 0;
        for (String item: list) {
            if (max < item.split(" ").length) max = item.split(" ").length;
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("All data from file\n");
        List<String> a = Arrays.stream(String.join("\n", Files
                                .readAllLines(Paths.get("C:\\Users\\likht\\IdeaProjects\\Lab_4\\src\\input.txt")))
                        .split("[.?!;]"))
                .map(String::trim)
                .collect(Collectors.toList());
        a.forEach(x -> {
            System.out.println(x);
        });
        System.out.println("\n--------------------------------------------------------------\n");

        System.out.println("Find and print all PIB\n");
        for (String sentence: a) {
            if(PIBCheck(sentence)) {
                System.out.println(PIBFind(sentence));
            }
        }
        System.out.println("\n--------------------------------------------------------------\n");
        System.out.println("Find and sentence sentence neighbors\n");
        for (int i = 0; i < a.size(); i++) {
            if(PIBCheck(a.get(i))){
                if (i == 0) System.out.println(a.get(i+1));
                else if (i == a.size() - 1) System.out.println(a.get(i-1));
                else System.out.println(String.join("\n", a.get(i-1),a.get(i+1)));
            }
        }
        System.out.println("\n--------------------------------------------------------------\n");
        System.out.println("Replace PIB to max word count\n");
        int maxCount = maxWordCount(a);
        for (int i = 0; i < a.size(); i++) {
            if(PIBCheck(a.get(i))){
                System.out.println(a.get(i).replaceAll(PIBFind(a.get(i)), String.valueOf(maxCount)));
            }
            else System.out.println(a.get(i));
        }
    }
}