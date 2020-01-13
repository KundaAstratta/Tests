package foobarquix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;


public class FooBarText {

    FooBar foobar = new FooBar();

    FooBarQuix foobarquix = new FooBarQuix();

 //   StringBuilder str = new StringBuilder();
     private String str = "";

    private static final String _FOO = "FOO";
    private static final String _BAR = "BAR";
    private static final String _QIX = "QIX";



    //FooBar tests

    @ParameterizedTest
    @ValueSource(ints = {-3, -90})
    void should_return_error_when_negatif(int input) {
        Assertions.assertThrows(IllegalArgumentException.class,
        () -> new FooBar().fooBarQix(input));

    }

    @Test
    void should_return_self_by_default() {
        Assertions.assertEquals("1", foobar.fooBarQix(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 9, 12})
    void should_return_FOO_when_divide_by_3(int input)  {
        Assertions.assertEquals("FOO",foobar.fooBarQix(input) );
    }


    @ParameterizedTest
    @ValueSource(ints = {5, 10, 20, 25})
    void should_return_BAR_when_divide_by_5(int input)  {
        Assertions.assertEquals("BAR",foobar.fooBarQix(input) );
    }


    @ParameterizedTest
    @ValueSource(ints = {15,30,60})
    void should_return_FOOBAR_when_divide_by_3_and_5(int input)  {
        Assertions.assertEquals("FOOBAR",foobar.fooBarQix(input) );
    }

    @ParameterizedTest
    @ValueSource(ints = {7,14})
    void should_return_QIX_when_divide_by_7(int input)  {
        Assertions.assertEquals("QIX",foobar.fooBarQix(input) );
    }

    @ParameterizedTest
    @ValueSource(ints = {21})
    void should_return_FOOQIX_when_divide_by_3_7(int input)  {
        Assertions.assertEquals("FOOQIX",foobar.fooBarQix(input) );
    }


    @ParameterizedTest
    @ValueSource(ints = {105})
    void should_return_FOOBAR_when_divide_by_3_5_7(int input)  {
        Assertions.assertEquals("FOOBARQIX",foobar.fooBarQix(input) );
    }


    //FooBarQix tests
    @ParameterizedTest
    @ValueSource(ints = {3})
    void should_return_FOOFOO__when_divide(int input)  {
        Assertions.assertEquals("FOOFOO",foobarquix.fooBarQix(input) );
    }


    @ParameterizedTest
    @ValueSource(ints = {33})
    void should_return_FOOFOOFOO__when_divide(int input)  {
        Assertions.assertEquals("FOOFOOFOO",foobarquix.fooBarQix(input) );
    }

    @ParameterizedTest
    @ValueSource(ints = {35})
    void should_return_BARQIXFOOBAR_when_by_3_7_with_3_5(int input)  {
        Assertions.assertEquals("BARQIXFOOBAR",foobarquix.fooBarQix(input) );
    }


    @ParameterizedTest
    @ValueSource(ints = {1530})
    void should_return__generic(int input) {


        if (input % 3 == 0) { str = str +_FOO; }
        if (input % 5 == 0) { str= str + _BAR; }
        if (input % 7 == 0) { str = str + _QIX; }

        String[] result = Arrays.stream(String.valueOf(input).split("")).toArray(String[]::new);

        for (String r : result) {
            int s = Integer.parseInt(r);
            switch (s) {
                case 3:
                    str= str + _FOO;
                    break;
                case 5:
                    str= str + _BAR;
                    break;
                case 7:
                    str= str + _QIX;
                    break;
            }
        }

        System.out.println(str);
        Assertions.assertEquals(str,foobarquix.fooBarQix(input));
    }

}
