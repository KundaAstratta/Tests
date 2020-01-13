package foobarquix;

public class FooBar {

    private static final String _FOO = "FOO";
    private static final String _BAR = "BAR";
    private static final String _QIX = "QIX";

    public String fooBarQix(int input) {

        StringBuilder str = new StringBuilder();

        if (input < 0) {
            throw new IllegalArgumentException("les nombres négatifs ne sont pas acceptés");
        }

        if (input % 3 == 0) {
            str.append(_FOO);
        }


        if (input % 5 == 0) {
            str.append(_BAR);
        }

        if (input % 7 == 0) {
            str.append(_QIX);
        }

        if (str.toString().equals("")) {
            str.append(input);
        }

        return str.toString();
    }

}
