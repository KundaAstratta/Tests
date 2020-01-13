package foobarquix;


import java.util.Arrays;


public  class FooBarQuix {

    private static final String _FOO = "FOO";
    private static final String _BAR = "BAR";
    private static final String _QIX = "QIX";
    private static final int _ZERO = 0;
    private static final int _TROIS = 3;
    private static final int _CINQ = 5;
    private static final int _SEPT = 7;
    private  StringBuilder str = new StringBuilder();

    public String fooBarQix(int input) {

        foobarmain(input);

        return str.toString();

    }

    private void foobarmain(int input) {
        foobar(input);

        foobarquix(input);
    }

    private void foobarquix(int input) {
        String[] result = Arrays.stream(String.valueOf(input).split("")).toArray(String[]::new);

        for (String r : result) {
            int s = Integer.parseInt(r);
            switch (s) {
                case _TROIS :
                    str.append(_FOO);
                    break;
                case _CINQ:
                    str.append(_BAR);
                    break;
                case _SEPT:
                    str.append(_QIX);
                    break;
            }
        }


        if (str.toString().equals("")) {
            str.append(input);
        }
    }

    private void foobar(int input) {
        if (input < _ZERO) { throw new IllegalArgumentException("les nombres négatifs ne sont pas acceptés"); }

        if (input % _TROIS == _ZERO) { str.append(_FOO); }

        if (input % _CINQ == _ZERO) { str.append(_BAR); }

        if (input % _SEPT == _ZERO) { str.append(_QIX); }
    }
}