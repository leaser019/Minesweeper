package Control;

import view.Button;
import java.util.Random;

public class World {
    private Random rd;
    private Button[][] arrayButton;
    private int[][] arrayMin;

    public World(int width, int height, int boom_num) {
        arrayButton = new Button[width][height];
        arrayMin = new int[width][height];
        rd = new Random();

        createArrayMin(boom_num, width, height);
        System.out.println(boom_num);
        for(int i = 0; i < arrayButton.length; i++){
            for(int j = 0; j < arrayButton[i].length; j++){
                System.out.println(arrayMin[i][j] + " ");
            }
            System.out.println();
        }
        dienSo();
    }

    public void open(int i, int j){
        int number = arrayMin[i][j];
        if(number != -1){
            arrayButton[i][j].setNumber(number);
            arrayButton[i][j].repaint();
        }
    }

    public void createArrayMin(int boom_num, int width, int height){
        int count  = 0;
        while(count < boom_num){
            int locationX = rd.nextInt(width);
            int locationY = rd.nextInt(height);

            if (arrayMin[locationX][locationY] != -1) {
                arrayMin[locationX][locationY] = -1;
                count++;
            }
    
        }
    }

    public void dienSo(){
        for(int i = 0; i < arrayMin.length; i++){
            for(int j  = 0; j < arrayMin[i].length; j++){
                if(arrayMin[i][j] == 0){
                    int count = 0;
                    for(int l = i - 1; l <= i + 1; l++){
                        for(int k = j - 1; k <= j + 1; k++){
                            if(l>=0 && l<=arrayMin.length-1 && k>=0 && k<=arrayMin[i].length-1)
                            if(arrayMin[l][k] == -1){
                                count++;
                            }
                        }
                    }
                    arrayMin[i][j] = count;
                }
            }
        }
    }
    public Button[][] getArrayButton() {
        return arrayButton;
    }

    public void setArrayButton(Button[][] arrayButton) {
        this.arrayButton = arrayButton;
    }

    public int[][] getArrayMin() {
        return arrayMin;
    }

    public void setArrayMin(int[][] arrayMin) {
        this.arrayMin = arrayMin;
    }
}