package controller;

import view.Button;
import view.GamePanel;

import java.util.Random;

public class World {
    private GamePanel game;
    private Random rd;
    private Button[][] arrayButton;
    private int[][] arrayMin;
    private boolean isWin;
    private boolean isLose;
    private boolean[][] arrayBoolean;
    private boolean[][] arrayPutFlag;
    private int flag;
    private int boom_num;

    public World(int cols, int rows, int boom_num, GamePanel game) {
        this.boom_num = boom_num;
        this.game = game;
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
                    if(verifyWinGame()){
                            isLose = true;
                            return false;
                        }

                        return true;
                }else{
                    arrayBoolean[i][j] = true;
                    int number = arrayMin[i][j];

                    if(number != -1){
                        arrayButton[i][j].setNumber(number);
                        arrayButton[i][j].repaint();

                        if(verifyWinGame()){
                            isLose = true;
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
                            //if(a !=i || b != j){
                                arrayButton[a][b].setNumber(10);
                                arrayButton[a][b].repaint();
                            //}
                        }
                    }
                }

                return false;
            }else{
                if(verifyWinGame()){
                    isLose = true;
                    return false;
                }
                return true;
            }
        }else
            return false;
    }

    public boolean clickDouble(int i, int j){
        boolean ishaveBoom = false;
        for(int l = i - 1; l <= i + 1; l++){
            for(int k = j - 1; k <= j + 1; k++){
                if(l>=0 && l<=arrayMin.length-1 && k>=0 && k<=arrayMin[i].length-1){
                    if(!arrayPutFlag[l][k]){
                        if(arrayMin[l][k] == -1){
                            ishaveBoom = true;
                            arrayButton[l][k].setNumber(12);
                            arrayButton[l][k].repaint();
                            arrayBoolean[l][k] = true;
                        }else if(!arrayBoolean[l][k]){
                            if(arrayMin[l][k] == 0){
                                open(l, k);
                            } else {
                                arrayButton[l][k].setNumber(arrayMin[l][k]);
                                arrayButton[l][k].repaint();
                                arrayBoolean[l][k] = true;
                            } 
                        }
                    }
                }
            }
        }
        if(ishaveBoom){
            for(int j2 = 0; j2 < arrayBoolean.length; j2++){
                for(int k = 0; k < arrayBoolean[i].length; k++){
                    if(arrayMin[j2][k] == -1 && !arrayBoolean[j2][k]){
                        arrayButton[j2][k].setNumber(10);
                        arrayButton[j2][k].repaint();
                    }
                }
            }
            return false;
        }
        return true;
    }

    public void putFlag(int i, int j){
        if(!arrayBoolean[i][j]){
            if(arrayPutFlag[i][j]){
                flag--;
                arrayPutFlag[i][j] = false;
                arrayButton[i][j].setNumber(-1);
                arrayButton[i][j].repaint();
                game.getHeader().updatelabelLeft();
            }else if (flag < boom_num){
                flag++;
                arrayPutFlag[i][j] = true;
                arrayButton[i][j].setNumber(9);
                arrayButton[i][j].repaint();
                game.getHeader().updatelabelLeft();
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
                count = 0;

                for(int i = 0; i < arrayMin.length; i++){
                    for(int j = 0; j < arrayMin[i].length; j++){
                        if(arrayMin[i][j]==-1){
                            count++;
                        }
                    }
                }
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

     public boolean[][] getArrayBoolean(){
        return arrayBoolean;
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

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public GamePanel getGame() {
        return game;
    }

    public void setGame(GamePanel game) {
        this.game = game;
    }

    public Random getRd() {
        return rd;
    }

    public void setRd(Random rd) {
        this.rd = rd;
    }

    public int getBoom_num() {
        return boom_num;
    }

    public void setBoom_num(int boom_num) {
        this.boom_num = boom_num;
    }
    
    
    
}