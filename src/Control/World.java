package Control;

import view.Button;
import java.util.Random;

public class World {
    private Random rd;
    private Button[][] arrayButton;
    private int[][] arrayMin;
    private boolean[][] arrayBoolean;
    private boolean isComplete;

    public World(int cols, int rows, int boom_num) {
        arrayButton = new Button[cols][rows];
        arrayMin = new int[cols][rows];
        arrayBoolean = new boolean[cols][rows];
        rd = new Random();

        createArrayMin(boom_num, cols, rows);
        System.out.println(boom_num);
        for(int i = 0; i < arrayButton.length; i++){
            for(int j = 0; j < arrayButton[i].length; j++){
                System.out.println(arrayMin[i][j] + " ");
            }
            System.out.println();
        }
        dienSo();
        System.out.println("Boom_num: " + boom_num);
        for(int i = 0; i < arrayMin.length; i++){
            for(int j = 0; j < arrayMin[i].length; j++){
                System.out.println(arrayMin[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean open(int i, int j){
        if(!isComplete){
            if(!arrayBoolean[i][j]){
                if(arrayMin[i][j] == 0){
                    arrayBoolean[i][j] = true;
                    arrayButton[i][j].setNumber(0);
                    arrayButton[i][j].repaint();
                    for(int l = i - 1; l <= i + 1; l++){
                        for(int k = j - 1; k <= j + 1; k++){
                            if(l>=0 && l<=arrayMin.length-1 && k>=0 && k<=arrayMin[i].length-1){
                                if(!arrayBoolean[l][k])
                                open(l, k);
                            }
                        }
                    }
                } else {
                    arrayBoolean[i][j] = true;
                    int number = arrayMin[i][j];
                    if(number != -1){
                        arrayButton[i][j].setNumber(number);
                        arrayButton[i][j].repaint();
                        return true;
                    }
                } 
            }
            if (arrayMin[i][j] == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
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

    public void fullTrue(){
        for(int i = 0; i < arrayBoolean.length; i++){
            for(int j = 0; j < arrayBoolean[i].length; j++){
                if(!arrayBoolean[i][j]){
                    arrayBoolean[i][j] = true;
                }
            }
        }
        isComplete = true;
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