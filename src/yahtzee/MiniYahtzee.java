package yahtzee;


import java.util.ArrayList;
import java.util.List;

class MiniYahtzee {

    public static void main(String[] args) {
        score(args[0], args[1], args[2], args[3]);
    }

    static int score(String nomination, String d1, String d2, String d3) {

        List<Integer> params = new ArrayList<>();
        params.add(checkAndConvert(d1));
        params.add(checkAndConvert(d2));
        params.add(checkAndConvert(d3));

        int score = 0;
        switch (nomination){
            case "ones":
                score = new Sums().scores(1, params);
                break;
            case "twos":
                score = new Sums().scores(2, params);
                break;
            case "threes":
                score = new Sums().scores(3, params);
                break;
        }

        return score;
    }

    private static int checkAndConvert(String num) {
        if (!num.isEmpty())
            return Integer.parseInt(num);
        else {
            throw new RuntimeException("Empty inputs");
        }
    }
}

class Sums {
    int scores(int iterator, List<Integer> inputs) {

        return inputs.stream()
                .filter(d -> d == iterator)
                .reduce(0, Integer::sum);
    }
}
