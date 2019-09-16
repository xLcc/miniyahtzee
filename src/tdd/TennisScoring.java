package tdd;

class TennisScoring {

    private static final String ADVANTAGE = "advantage";
    private static final String DEUCE = "deuce";
    private static final String SPACE = " ";
    private int scoreOne;
    private int scoreTwo;

    TennisScoring(int scoreOne, int scoreTwo) {

        this.scoreOne = scoreOne;
        this.scoreTwo = scoreTwo;
    }


    String announcement() {

        int diff = scoreOne - scoreTwo;
        String result;

        result = checkIfWin(scoreOne, scoreTwo, diff);
        if (result != null) return result;
        result = checkAdv(diff);
        if (result != null) return result;

        if (checkDeuce(diff==0, scoreOne)) return DEUCE;


        return getAnnouncement(scoreOne) + SPACE + getAnnouncement(scoreTwo);
    }


    private String checkAdv(int diff) {
        if (scoreOne >= 3 && scoreTwo >= 3 ){
            if (diff == 1)
                return ADVANTAGE + SPACE + getAnnouncement(scoreTwo);
            else if (diff == -1)
                return getAnnouncement(scoreOne) + SPACE + ADVANTAGE;
        }
        return null;
    }


    private static String checkIfWin(int scoreOne, int scoreTwo, int diff) {
        if (scoreOne >= 4 && diff >= 2){
            return "first player won";
        }else if (scoreTwo >= 4 && diff <= (-2))
            return "second player won";
        return null;
    }


    private static boolean checkDeuce(boolean flag, int score) {
        return flag && score >= 3;
    }


    private String getAnnouncement(int score) {

        switch (score) {
            case 0:
                return "love";
            case 1:
                return "fifteen";
            case 2:
                return "thirty";
            case 3:
                return "forty";
            default:
                return null;
        }
    }


    void playerOneWinAPoint() {
        this.scoreOne++;
    }


    void playerTwoWinAPoint() {
        this.scoreTwo++;
    }
}
