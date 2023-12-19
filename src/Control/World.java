package Control;
import view.Button;
import java.util.Random;

public class World {
    private Button[][] arrayButton;
    private int[][] arrayBoom;
    private Random rd;
    private boolean[][] arrayBoolean;

    public World(int width, int height, int boom_num){
        arrayButton = new Button[width][height];
        arrayBoom = new int[width][height];
        arrayBoolean = new boolean[width][height];

        rd = new Random();

        createArrayBoom(width, height, boom_num);
        System.out.println(boom_num);
        fillNumber();
        
        for(int i = 0; i < arrayBoom.length; i++){
            for(int j = 0; j < arrayBoom[i].length; j++){
                System.out.println(arrayBoom[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void fillNumber(){
        for(int i = 0; i < arrayBoom.length; i++){
            for(int j = 0; j < arrayBoom[i].length; j++){
                if(arrayBoom[i][j] == 0){
                    int count = 0;
                    for(int l = i - 1; l <= i + 1; l++){
                        for(int k = j - 1; k <= j + 1; k++){
                            if(l >= 0 && l <= arrayBoom.length - 1 && k >= 0 && k <= arrayBoom[i].length - 1){
                                if(arrayBoom[l][k] == -1){
                                    count++;
                                }
                            }
                        }
                    }
                    arrayBoom[i][j] = count;
                }
            }
        }
    }

    public boolean open(int i, int j){
        if(!arrayBoolean[i][j]) {
            arrayBoolean[i][j] = true;

            int number = arrayBoom[i][j];
            if(number != -1){
                arrayButton[i][j].setNumber(number);
                arrayButton[i][j].repaint();
                return true;
            }
        }
        return false;
    }

    public void createArrayBoom(int boom_num, int width, int height){
        int locationX = rd.nextInt(width);
        int locationY = rd.nextInt(height);

        arrayBoom[locationX][locationY] = -1;
        int count = 1;
        while (count != boom_num){
            locationX = rd.nextInt(width);
            locationY = rd.nextInt(height);
            if(arrayBoom[locationX][locationY] != -1)
                arrayBoom[locationX][locationY] = -1;
                count = 0;
            for(int i = 0; i < arrayBoom.length ;i++){
                for(int j = 0; j < arrayBoom[i].length; j++){
                    if(arrayBoom[i][j] == -1){
                        count++;
                    }
                }
            }
        }
    }

    public void fullTrue(){
        for(int i = 0; i < arrayBoolean.length; i++){
            for(int j = 0; j < arrayBoolean[i].length; j++){
                if(!arrayBoolean[i][j]){
                    arrayBoolean[i][j] = true;
                }
            }
        }
    }
    public Button[][] getPlayGround() {
        return arrayButton;
    }
    public void setArrayButton(Button[][] playGround) {
        this.arrayButton = playGround;
    }
    public int[][] getArrayBoom() {
        return arrayBoom;
    }
    public void setArrayBoom(int[][] arrayBoom) {
        this.arrayBoom = arrayBoom;
    }

    public Button[][] getArrayButton() {
        return arrayButton;
    }

    public Random getRd() {
        return rd;
    }

    public void setRd(Random rd) {
        this.rd = rd;
    }
}
