package control;

import java.util.Random;

import view.Button;
import view.SmileButton;
import view.GamePanel;
import view.Number;

public class World {

    private Random rd;

    private Button[][] arrayButton;
    private int[][] arrayBoom;

    private boolean[][] arrayBoolean;

    private static boolean[][] arrayFlag;
    private int flag;

    private SmileButton smileButton;
    private Number labelRight, labelLeft;

    private int boom_num;

    private GamePanel game;

    private boolean isComplete;

    private boolean isEnd;

    public World(int width, int height, int boom_num, GamePanel game){
        this.game = game;
        this.boom_num = boom_num;

        arrayButton  = new Button[width][height];
        arrayBoom = new int[width][height];
        arrayBoolean = new boolean[width][height];
        arrayFlag = new boolean[width][height];

        rd = new Random();

        createArrayBoom(boom_num, width, height);
        fillNumber();
    }

    public boolean clickDouble(int i, int j){
        boolean ishaveBoom = false;

        for(int l = i - 1; l <= i + 1; l++){
            for(int k = j - 1; k <= j + 1; k++){
                if(l >= 0 && l <= arrayBoom.length - 1 && k >= 0 && k <= arrayBoom[i].length -1){
                    if(!arrayFlag[l][k]){
                        if(arrayBoom[l][k] == -1) {
                            ishaveBoom = true;
                            arrayButton[l][k].setS(12);
                            arrayButton[l][k].repaint();
                            arrayBoolean[l][k] = true;
                        } else if(!arrayBoolean[l][k]){
                            if(arrayBoom[l][k] == 0){
                                open(l, k);
                            } else {
                                arrayButton[l][k].setNumber(arrayBoom[l][k]);
                                arrayButton[l][k].repaint();
                                arrayBoolean[l][k] = true;
                            }
                        }
                    }
                }
            }
        }

        if(ishaveBoom) {
            for(int j2 = 0; j2 < arrayBoolean.length; j2++){
                for(int k = 0; k < arrayBoolean[i].length; k++){
                    if(arrayBoom[j2][k] == -1 && !arrayBoolean[j2][k]){
                        arrayButton[j2][k].setNumber(10);
                        arrayButton[j2][k].repaint();
                    }
                }
            }
            return false;
        }
        return true;
    }

    public void setFlag(int i, int j){
        if(!arrayBoolean[i][j]){
            if(arrayFlag[i][j]){
                flag--;
                arrayFlag[i][j] = false;
                arrayButton[i][j].setNumber(-1);
                arrayButton[i][j].repaint();
                game.getHeader().updateLableLeft();
            } else if(flag < boom_num){
                flag++;
                arrayFlag[i][j] = true;
                arrayButton[i][j].setNumber(9);
                arrayButton[i][j].repaint();
                game.getHeader().updateLableLeft();
            }
        }
    }

    public boolean open(int i, int j) {

		if (!isComplete && !isEnd) {
			if (!arrayBoolean[i][j]) {
				if (arrayBoom[i][j] == 0) {

					arrayBoolean[i][j] = true;
					arrayButton[i][j].setNumber(0);
					arrayButton[i][j].repaint();

					if (checkWin()) {
						isEnd = true;

						return false;
					}

					for (int l = i - 1; l <= i + 1; l++) {
						for (int k = j - 1; k <= j + 1; k++) {
							if (l >= 0 && l <= arrayBoom.length - 1 && k >= 0 && k <= arrayBoom[i].length - 1) {
								if (!arrayBoolean[l][k]) {
									open(l, k);
								}
							}
						}
					}

					if (checkWin()) {
						isEnd = true;

						return false;
					}

				} else {

					int number = arrayBoom[i][j];

					if (number != -1) {

						arrayBoolean[i][j] = true;

						arrayButton[i][j].setNumber(number);
						arrayButton[i][j].repaint();

						if (checkWin()) {
							isEnd = true;

							return false;
						}

						return true;
					}
				}
			}

			if (arrayBoom[i][j] == -1) {
				arrayButton[i][j].setNumber(11);
				arrayButton[i][j].repaint();
				isComplete = true;

				for (int j2 = 0; j2 < arrayBoolean.length; j2++) {
					for (int k = 0; k < arrayBoolean[i].length; k++) {
						if (arrayBoom[j2][k] == -1 && !arrayBoolean[j2][k]) {
							if (j2 != i || k != j) {
								arrayButton[j2][k].setNumber(10);
								arrayButton[j2][k].repaint();
							}
						}
					}
				}

				return false;
			} else {

				if (checkWin()) {
					isEnd = true;

					return false;
				}

				return true;
			}
		} else

			return false;

	}

	public boolean checkWin() {
		int count = 0;
		for (int i = 0; i < arrayBoolean.length; i++) {
			for (int j = 0; j < arrayBoolean[i].length; j++) {
				if (!arrayBoolean[i][j]) {
					count++;
				}
			}
		}
		if (count == boom_num)
			return true;
		else
			return false;
	}

    public void fillNumber() {
        for(int i = 0; i < arrayBoom.length; i++){
            for(int j = 0; j < arrayBoom[i].length; j++){
                if(arrayBoom[i][j] == 0){
                    int count = 0;
                    for (int l = i -1; l <= i + 1; l++){
                        for(int k = j - 1; k <= j + 1; k++){
                            if(l >= 0 && l <= arrayBoom.length - 1 && k >= 0 && k < arrayBoom[i].length - 1){
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

    public void createArrayBoom(int boom_num, int width, int height){
        int locationX = rd.nextInt(width);
        int locationY = rd.nextInt(height);

        arrayBoom[locationX][locationY] = -1;
        int count = 1;
        while (count != boom_num){
            locationX = rd.nextInt(width);
            locationY = rd.nextInt(height);
            if (arrayBoom[locationX][locationY] != -1){

                arrayBoom[locationX][locationY] = -1;

                count = 0;
                for(int i = 0; i < arrayBoom.length; i++){
                    for(int j = 0; j < arrayBoom[i].length; j++){
                        if(arrayBoom[i][j] == -1){
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

    public Button[][] getAButton(){
        return arrayButton;
    } 

    public void setArrayButton(Button[][] arrayButton){
        this.arrayButton = arrayButton;
    }

    public SmileButton getButtonSmile() {
        return smileButton;
    }

    public void setButtonSmile(SmileButton buttonSmile){
        this.smileButton = buttonSmile;
    }

    public Number getLbTime() {
        return labelRight;
    }

    public void setLbTime(Number labelRight){
        this.labelRight = labelRight;
    }

    public static boolean[][] getArrayFlag(){
        return arrayFlag;
    }

    public Number getLableLeft() {
		return labelLeft;
	}

	public void setLbBoom(Number labelRight) {
		this.labelRight = labelRight;
	}

	public boolean[][] getArrayBoolean() {
		return arrayBoolean;
	}

	public void setArrayBoolean(boolean[][] arrayBoolean) {
		this.arrayBoolean = arrayBoolean;
	}

	public boolean isComplete() {
		return isComplete();
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public boolean isEnd() {
		return isEnd();
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

    public int getFlag(){
        return flag;
    }

    public void setFlag(int flag){
        this.flag = flag;
    }

    public Button[][] getArrayButton() {
        return null;
    }

    public SmileButton getSmileButton() {
        return null;
    }
}


