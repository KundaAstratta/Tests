package stringcalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    @Test
    void should_method_return_0_with_space() {
        Assertions.assertEquals(stringCalculator.add(""),0);
    }

    @Test
    void should_method_return_2_if_1_1() {
        Assertions.assertEquals(stringCalculator.add("1,1"),2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,1,2,1", "2,3","4,1,0,0,0"})
    void should_method_return_with_multi_same_separator(String expr) {
        Assertions.assertEquals(stringCalculator.add(expr),5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,4", "2\n3"})
    void should_method_return_with_one_diff_separator(String expr) {
        Assertions.assertEquals(stringCalculator.add(expr),5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,4,10", "2\n3,4\n6"})
    void should_method_return_with_multi_same_diff_separator(String expr) {
        Assertions.assertEquals(stringCalculator.add(expr),15);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,4,"})
    void should_method_return_with_coma_at_end(String expr) {
        Assertions.assertEquals(stringCalculator.add(expr),5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,\n" , "1,5,\n"})
    void should_method_return_with_no_end_new_line(String expr) {
        Assertions.assertEquals(stringCalculator.add(expr),0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;3;2"})
    void should_method_return_with_one_delimiter(String expr) {
        Assertions.assertEquals(stringCalculator.add(expr),6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;3;\n2"})
    void should_method_return_with_too_many_jump_line(String expr) {
        Assertions.assertEquals(stringCalculator.add(expr),0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//[ttt]\n11ttt2ttt3"})
    void should_method_return_with_no_end_multi_delimiter(String expr) {
        Assertions.assertEquals(stringCalculator.add(expr),16);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,4,1000,1001,2"})
    void should_method_return_without_sup_1000(String expr) {
        Assertions.assertEquals(stringCalculator.add(expr),1007);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,4,1000,1001,-2"})
    void should_method_return_with_negativ(String expr) {
        Assertions.assertEquals(stringCalculator.add(expr),1005);
    }


}
