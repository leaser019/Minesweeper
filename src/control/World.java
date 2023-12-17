package control;

import java.util.Random;

import view.Button;

public class World {

    private Random rd;
    private Button[][] arrayButton;
    private int[][] arrayMin; //boom la so 10

    private boolean[][] arrayButton;

    private ButtonSmile buttonSmile;
    private LableNumber lbTime, lbBoom;

    public World(int w, int h, int boom){
        arrayButton = new Button[w][h];
        arrayMin = new int[w][h];
        arrayBoolean = new boolean[w][h];
        
        rd = new Random();

        createArrayMin(boom, w, h);
        dienSo();
        System.out.println(boom);
        for(int i = 0; i < arrayMin.length; i++){
            for(int j = 0; j < arrayMin[i].length; j++){
                System.out.println(arrayMin[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean open(int i, int j){
        if(!arrayBoolean[i][j]) {
            arrayBoolean[i][j] = true;


        }
        int number = arrayMin[i][j];

        if(number != 10){
            arrayButton[i][j] = setNumber(number);
            arrayButton[i][j] = repaint();
            
            return true;
        } else {
            return false;
        }
    }

    public void dienSo(){
        for (int i = 0; i < arrayMin.length; i++){
            for(int j = 0; j < arrayMin[i].length; j++){
                if(arrayMin[i][j] == 0){
                    int count = 0;
                    for(int l = i - 1; l <= i + 1; l++){
                        for(int k = j -1; k <= j + 1; k++){
                            if(l >= 0 && l <= arrayMin.length-1 && k >= 0 && k <= arrayMin[i].length-1){
                                if(arrayMin[j][k] == -1){
                                    count++;
                                }
                            }
                        }
                    }
                    arrayMin[i][j] = count;
                }
            }
        }
    }
    public void createArrayMin (int boom, int w, int h){
        int locationX = rd.nextInt(w);
        int locationY = rd.nextInt(h);

        arrayMin[locationX][locationY] = 10;
        int count = 1;
        while(count != boom){
            int locationX = rd.nextInt(w);
            int locationY = rd.nextInt(h);
            if(arrayMin[locationX][locationY] != 10){
                arrayMin[locationX][locationY] = 10;

                count = 0;
                for (int i = 0; i < arrayMin.length; i++){
                    for (int j = 0; j < arrayMin.length; j++){
                        if(arrayMin[i][j] == 10){
                            count++;
                        }
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

    public Button[][] getArrayButton(){
        return arrayButton;
    }

    public void setArrayButton(Button[][] arrayButton){
        this.arrayButton = arrayButton;
    }

    public ButtonSmile getButtonSmile() {
        return buttonSmile;
    }

    public void setButtonSmile(ButtonSmile buttonSmile) {
        this.buttonSmile = buttonSmile;
    }
    
    public LableNumber getlbTime(){
        return lbTime;
    }

    public LableNumber getlbBoom(){
        return lbBoom;
    }

    public void setLbTime(LableNumber lbTime) {
		this.lbTime = lbTime;
	}

	public LableNumber getLbBoom() {
		return lbBoom;
	}

	public void setLbBoom(LableNumber lbBoom) {
		this.lbBoom = lbBoom;
	}

	public boolean[][] getArrayBoolean() {
		return arrayBoolean;
	}

	public void setArrayBoolean(boolean[][] arrayBoolean) {
		this.arrayBoolean = arrayBoolean;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	public boolean[][] getArrayCamCo() {
		return arrayCamCo;
	}

	public void setArrayCamCo(boolean[][] arrayCamCo) {
		this.arrayCamCo = arrayCamCo;
	}

	public int getCo() {
		return co;
	}

	public void setCo(int co) {
		this.co = co;
	}

}
