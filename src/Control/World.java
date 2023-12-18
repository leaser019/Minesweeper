package Control;
import view.Button;
import java.util.Random;

public class World {
    private Button[][] arrayButton;
    private int[][] arrayBoom; //arrayMin = arrayBoom
    private Random rd;

    public World(int width, int height, int boom_num){
        arrayButton = new Button[width][height];
        arrayBoom = new int[width][height];

        rd = new Random();

        createArrayBoom(width, height, boom_num);
        System.out.println(boom_num);
        fillNumber();
    }

    public void fillNumber(){
        for(int i = 0; i < arrayBoom.length; i++){
            for(int j = 0; j < arrayBoom[i].length; j++){
                if(arrayBoom[i][j] == 0){
                    int count = 0;
                    for(int l = i - 1; l <= i + 1; l++){
                        for(int k = j - 1; k <= j + 1; k++){
                            if(l >= 0 && l <= arrayBoom.length - 1 && k >= 0&& k <= arrayBoom[i].length - 1){
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

    public void createArrayBoom(int width, int height, int boom_num){
        int locationX = rd.nextInt(width);
        int locationY = rd.nextInt(height);

        arrayBoom[locationX][locationY] = -1;
        int count = 1;
        while (count != boom_num){
            locationX = rd.nextInt(width);
            locationY = rd.nextInt(height);
            if(arrayBoom[locationX][locationY] != -1)
            arrayBoom[locationX][locationY] = -1;
            for(int i = 0; i < arrayBoom.length ;i++){
                for(int j = 0; j < arrayBoom[i].length; j++){
                    if(arrayBoom[i][j] == -1){
                        count++;
                    }
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
    public int[][] getArrayBoom() {
        return arrayBoom;
    }
    public void setArrayBoom(int[][] arrayBoom) {
        this.arrayBoom = arrayBoom;
    }
    
    
}
