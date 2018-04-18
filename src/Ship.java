
public class Ship {

    static final int ONE_DECK_SHIP = 1;
    static final int TWO_DECK_SHIP = 2;
    static final int THREE_DECK_SHIP = 3;
    static final int FOUR_DECK_SHIP = 4;

    private int[] ship;

    public Ship() {
        ship = new int[11];


    }

    public int [] addTypeShips(){

        for (int i = 0; i < ship.length; i++) {
            switch(i){
                case 0: ship[i] = FOUR_DECK_SHIP;
                break;
                case 1:
                case 2: ship[i] = THREE_DECK_SHIP;
                break;
                case 3:
                case 4:
                case 5: ship[i] = TWO_DECK_SHIP;
                break;
                case 6:
                case 7:
                case 8:
                case 9: ship[i] = ONE_DECK_SHIP;
                break;

            }
        }
        return ship;
    }

}
