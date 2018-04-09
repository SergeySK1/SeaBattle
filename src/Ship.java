import java.util.Arrays;

public class Ship {

    private int[] ship;

    public Ship() {
        ship = new int[10];
        ship = addAutoShips(ship);

    }

    public int [] addAutoShips(int[] arr){
        int count = 1;

        for (int i = 0; i < 10; i++){
            if (i < 4) {
                arr[i] = count;
                if (i == 3) count++;
            }
            else if (i > 3 && i < 7){
                arr[i] = count;
                if (i == 6) count++;
            }
            else if (i > 6 && i < 9) {
                arr[i] = count;
                if (i == 8) count++;
            }
            else if (i > 8 && i < 10){
                arr[i] = count;
            }
        }


        return arr;
    }

    public int getIndexElement(int index) {
        return ship[index];
    }

    public int [] getAllShipElements() {
        return ship;
    }
}
