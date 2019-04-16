package app;

import java.util.HashSet;
import java.util.Set;

class SquareNumbers {

    private Set<Integer> squares;

    SquareNumbers(int n) {
        Set<Integer> squares = new HashSet<>();
        int highestIndex = (int) Math.sqrt(2 * n - 1);

        for (int i = 1; i <= highestIndex; i++) {
            squares.add(i * i);
        }

        this.squares = squares;
    }

     boolean isSquare(int number) {
        return squares.contains(number);
    }

}
