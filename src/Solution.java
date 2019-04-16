import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Stream;

public class Solution {

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        //Check synchronization 
        // Return the minimum number of characters to make the password strong
        int sym = 0;
        String numbers = "0123456789";
        String lower_case = "abcdefghijklmnopqrstuvwxyz";
        String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special_characters = "!@#$%^&*()-+";

        Set<Character> stringSet = new TreeSet<Character>();
        for (int i = 0; i < password.length(); i++) {
            stringSet.add(password.charAt(i));
        }
        Set<Character> localeStringSet1 = new TreeSet<Character>();
        Set<Character> localeStringSet2 = new TreeSet<Character>();
        Set<Character> localeStringSet3 = new TreeSet<Character>();
        Set<Character> localeStringSet4 = new TreeSet<Character>();

        Set<Character> numbersSet = new TreeSet<Character>();
        for (int i = 0; i < numbers.length(); i++) {
            numbersSet.add(numbers.charAt(i));
        }

        Set<Character> lowerCase = new TreeSet<Character>();
        for (int i = 0; i < lower_case.length(); i++) {
            lowerCase.add(lower_case.charAt(i));
        }

        Set<Character> upperCase = new TreeSet<Character>();
        for (int i = 0; i < upper_case.length(); i++) {
            upperCase.add(upper_case.charAt(i));
        }

        Set<Character> specialChars = new TreeSet<Character>();
        for (int i = 0; i < special_characters.length(); i++) {
            specialChars.add(special_characters.charAt(i));
        }

        if (password.length() < 6) {
            sym = 6 - password.length();
        }

        int answer = 0;

        localeStringSet1.addAll(stringSet);
        localeStringSet2.addAll(stringSet);
        localeStringSet3.addAll(stringSet);
        localeStringSet4.addAll(stringSet);

        localeStringSet1.retainAll(numbersSet);
        System.out.println(localeStringSet1);
        if (localeStringSet1.isEmpty()) {
            System.out.println(localeStringSet1);
            answer++;
            System.out.println(answer);
        }

        localeStringSet2.retainAll(lowerCase);
        System.out.println(localeStringSet2);
        if (localeStringSet2.isEmpty()) {
            System.out.println(localeStringSet2);
            answer++;
            System.out.println(answer);
        }

        localeStringSet3.retainAll(upperCase);
        System.out.println(localeStringSet3);
        if (localeStringSet3.isEmpty()) {
            System.out.println(localeStringSet3);
            answer++;
            System.out.println(answer);
        }

        localeStringSet4.retainAll(specialChars);
        System.out.println(localeStringSet4);
        if (localeStringSet4.isEmpty()) {
            System.out.println(localeStringSet4);
            answer++;
            System.out.println(answer);
        }

        if (answer < sym){
            return answer;
        } else {
            return sym;
        }


        /*for (int i = 0; i < bigMfS.length();) {
            if ((i == bigMfS.length()-1) && (password.indexOf(numbersChar[i]) == -1)){
                answer ++;
                System.out.println(answer);
            }
            if (password.indexOf(numbersChar[i]) == -1 ){
               i++;
            }
             else {
                answer = 0;
                break;
            }
        }*/
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        System.out.println(answer);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
