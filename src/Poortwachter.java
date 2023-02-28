/*    Er is een poort en daarbij een poortwachter als je hierdoorheen wilt dan zegt de poortwachter een getal en jij moet een getal terug zeggen.
        # als jouw antwoord correct is mag je erdoorheen. Paul wilt door de poort de poortwachter zegt acht. Paul antwoord met 4 en mag doorlopen.
        # Bas wil ook door de poort de poortwachter zegt twaalf en bas zegt 6.
        # jij wilt er ook doorheen de poortwachter zegt elf. Wat moet je antwoorden?
        # jouw antwoord zou moeten zijn 3 want elf bestaat uit 3 letters.
*/
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
public class Poortwachter {
    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber = random.nextInt(10) + 1;
        HashMap<Integer, String> hmConverter = new HashMap<>();
        hmConverter.put(1, "een");
        hmConverter.put(2, "twee");
        hmConverter.put(3, "drie");
        hmConverter.put(4, "vier");
        hmConverter.put(5, "vijf");
        hmConverter.put(6, "zes");
        hmConverter.put(7, "zeven");
        hmConverter.put(8, "acht");
        hmConverter.put(9, "negen");
        hmConverter.put(10, "tien");
        int guesses = 3;
        boolean key = true;
        while (key) {
            System.out.println("Hi, ik ben de Poortwachter. Om door te kunnen gaan moet je het volgende raadseltje oplossen. Als ik twee zeg dan zeg jij 4, als ik negen zeg dan zeg jij 5. Wat zeg jij bij het volgende getal?: ");
            System.out.println(hmConverter.get(randomNumber));
            key = (tryAgain(hmConverter, key, randomNumber, guesses));
        }
    }

    public static boolean tryAgain(HashMap<Integer, String> name, boolean sleutel, int randomNumber, int guesses) {
        Scanner scanner = new Scanner(System.in);
        guesses--;
        System.out.println("Voer een getal tussen de 1 en 10 in:");
        int input = scanner.nextInt();
        if (input == (name.get(randomNumber).length())) {
            System.out.println("Gefeliciteerd je hebt gekozen voor " + input + ". Het antwoord is goed!");
            System.out.println("Kom maar door de poort!");
            sleutel = false;
        } else {
            System.out.println("Helaas! Het antwoord is niet correct. Je hebt nog " + guesses + " pogingen");
            System.out.println("Probeer het nog een keer");
            tryAgain(name, sleutel, randomNumber, guesses);
            if (guesses == 0) {
                System.out.println("Helaas je pogingen zijn op. Je mag niet naar binnen. De poort gaat nu sluiten!");
                sleutel = false;
            }
        }
        return sleutel;

    }
}