import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Bonus {
    public static void main(String[] args) {
        HashSet<Integer> secretnumber = randomNumberGenerator();
        String stringnumber =  setToStringConverter(secretnumber);
        System.out.println(stringnumber);
        feedback(stringnumber);
    }

    public static HashSet<Integer> randomNumberGenerator(){
        Random random = new Random();
        int ranNum = random.nextInt(6)+1;
        HashSet<Integer> ranNums = new HashSet<>();
        int key = 0;
        while (key < 4){
            ranNums.add(ranNum);
            key++;
        }
        return ranNums;
    }

    public static String setToStringConverter(HashSet<Integer> nums){
        String numberToText= "";
        for(Integer n : nums){
            numberToText += n + " ";
        }
        return numberToText;
    }

    /*
     Deze methode is voor de bonus opdracht.
     */
    public static void feedback(String stringnumber) {
        while(true) {
            Scanner scanner = new Scanner(System.in);
            StringBuilder feedback = new StringBuilder();
            System.out.println("take a guess");
            String guess = scanner.nextLine();
            if (Objects.equals(guess, stringnumber)) {
                System.out.println("gefeliciteerd je hebt het goed");
            } else {
                for (int i = 0; i < 4; i++) {
                    if (guess.substring(i, i + 1).equals(stringnumber.substring(i, i + 1))) {
                        feedback.append("+");
                    } else if (stringnumber.contains(guess.substring(i, i + 1))) {
                        feedback.append("0");
                    } else {
                        feedback.append("X");
                    }
                }
            }
            System.out.println(feedback.toString());
        }
    }
}
