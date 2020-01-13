package stringcalculator;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//https://osherove.com/tdd-kata-1

public class StringCalculator {

    String separator = ",|\n";

    int add(String numbers) {

        // si rien, retourne 0
        if (numbers.length() == 0) {
            return 0;
        }

        // si ,\n en fin retourne 0
        String[] arrayOfChars = Arrays.stream(numbers.split("")).toArray(String[]::new);
        if (arrayOfChars[arrayOfChars.length - 1].equals("\n") && arrayOfChars[arrayOfChars.length - 2].equals(",")) {
            return 0;
        }


        // Step 4 - fonctionne avec un seul \n entre séparator et la chaine d'addition
        if ((numbers.substring(0, 2)).equals("//")) {

            numbers = numbers.substring(2,numbers.length());
         //   String[] arrayOfRegex = Arrays.stream(numbers.split("\n")).toArray(String[]::new);
            String[] arrayOfRegex = Arrays.stream(numbers.split("\n")).toArray(String[]::new);
            separator = arrayOfRegex[0].toString();

            if (arrayOfRegex.length > 2) {
                // il y a des \n supplémentaires
                return 0;
            }

            //Step 7
            if ((separator.substring(0,1)).equals("[")) {
                separator=(separator.substring(1,separator.length())).split("]")[0];
            }

            numbers = arrayOfRegex[1].toString();
        }



        // 1) String -> tableau de String ("1,2" -> ["1","2"])
        // 2) tableau de String -> tableau de Int (["1","2"] -> [1,2])
        // 3) tableau de Int vers la somme ([1,2] -> 1+2=3)
        int sum = 0;

        String[] arrayOfString = Arrays.stream(numbers.split(separator)).toArray(String[]::new);

        int[] arrayOfInt = Stream.of(arrayOfString).mapToInt(Integer::parseInt).filter(getIntPredicate()).filter(getIntPredicatePositiv()).toArray();

        sum = IntStream.of(arrayOfInt).sum();

        //retourne le résultat
        return sum;
    }


    //Step 5. Negativ not allowed
    public IntPredicate getIntPredicatePositiv() {

        return x ->  x>=0;
    }

    //step 6 ; ajout de filter(x -> x <= 1000)
    public IntPredicate getIntPredicate() {
        return x -> x <= 1000;
    }




}
