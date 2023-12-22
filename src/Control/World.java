package Control;

import view.Button;
import java.util.Random;

public class World {
    private Random rd;
    private Button[][] arrayButton;
    private int[][] arrayMin;
    private boolean isWin;
    private boolean isLose;
    private boolean[][] arrayBoolean;
    private boolean[][] arrayPutFlag;
    private int boom_num;

    public World(int cols, int rows, int boom_num) {
        this.boom_num = boom_num;

        arrayButton = new Button[cols][rows];
        arrayMin = new int[cols][rows];
        arrayBoolean = new boolean[cols][rows];
        arrayPutFlag = new boolean[cols][rows];
        rd = new Random();

        createArrayMin(boom_num, cols, rows);
        dienSo();
    }

    public boolean open(int i, int j){
        
        if(!isWin && !isLose){
            if(!arrayBoolean[i][j]){

                if(arrayMin[i][j] == 0){
                    arrayBoolean[i][j] = true;
                    arrayButton[i][j].setNumber(0);
                    arrayButton[i][j].repaint();

                    if(verifyWinGame()){
                        isLose = true;
                        fullTrue();
                        return false;
                    }

                    for(int l = i - 1; l <= i + 1; l++){
                        for(int k = j - 1; k <= j + 1; k++){
                            if(l>=0 && l<=arrayMin.length-1 && k>=0 && k<=arrayMin[i].length-1){
                                if(!arrayBoolean[l][k]){
                                      open(l,k);
                                }
                            }
                        }
                    }
                }else{
                    arrayBoolean[i][j] = true;
                    int number = arrayMin[i][j];

                    if(number != -1){
                        arrayButton[i][j].setNumber(number);
                        arrayButton[i][j].repaint();

                        if(verifyWinGame()){
                            isLose = true;
                            fullTrue();
                            return false;
                        }

                        return true;
                    } 
                }
            }
            if(arrayMin[i][j] == -1){
                arrayButton[i][j].setNumber(11);
                arrayButton[i][j].repaint();
                isWin = true;

                for(int a = 0; a < arrayBoolean.length; a++){
                    for(int b = 0; b < arrayBoolean[i].length; b++){
                        if(arrayMin[a][b] == -1 && !arrayBoolean[a][b]){
                            arrayButton[a][b].setNumber(10);
                            arrayButton[a][b].repaint();
                        }
                    }
                }

                return false;
            }else{
                return true;
            }
        }else
            return false;
    }

    public void putFlag(int i, int j){
        if(!arrayBoolean[i][j]){
            if(arrayPutFlag[i][j]){
                arrayPutFlag[i][j] = false;
                arrayButton[i][j].setNumber(-1);
                arrayButton[i][j].repaint();
            }else{
                arrayPutFlag[i][j] = false;
                arrayButton[i][j].setNumber(9);
                arrayButton[i][j].repaint();
            }
        }
    }

    public boolean verifyWinGame(){
        int numberOfUnopen = 0;
        for(int i = 0; i < arrayBoolean.length; i++){
            for(int j = 0; j < arrayBoolean[i].length; j++){
                if(!arrayBoolean[i][j]){
                    numberOfUnopen++;
                }
            }
        }
        if(numberOfUnopen == boom_num)
            return true;
        else
            return false;
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

    public void setArrayBoolean(boolean[][] arrayBoolean){
        this.arrayBoolean = arrayBoolean;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean isWin) {
        this.isWin = isWin;
    }

    public boolean isLose() {
        return isLose;
    }

    public void setLose(boolean isLose) {
        this.isLose = isLose;
    }

    public boolean[][] getArrayPutFlag() {
        return arrayPutFlag;
    }

    public void setArrayPutFlag(boolean[][] arrayPutFlag) {
        this.arrayPutFlag = arrayPutFlag;
    }
    
}