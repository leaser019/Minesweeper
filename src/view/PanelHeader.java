package view;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class PanelHeader extends JPanel {
    private GamePanel game;
    private JPanel panelLeft, panelRight, panelCenter;
    private Number labelLeft, labelRight;
    private SmileButton icon;
    private Button[][] arrayButton;

    public PanelHeader(GamePanel game) {
        this.game = game;
        this.init();
        this.add(panelLeft, BorderLayout.EAST);
        this.add(panelRight, BorderLayout.WEST);
        this.add(panelCenter, BorderLayout.CENTER);

        panelLeft.add(labelLeft);
        panelCenter.add(icon);
        panelRight.add(labelRight);
    }

    private void init() {
        this.setLayout(new BorderLayout());
        BorderLayout layout = (BorderLayout) this.getLayout();
        layout.setVgap(160);
        panelLeft = new JPanel();
        panelRight = new JPanel();
        panelCenter = new JPanel();

        labelLeft = new Number(this, "000");
        labelRight = new Number(this, "000");
        icon = new SmileButton(this);

        arrayButton = game.getPanelPlay().getArrayButton();
    }

    public GamePanel getGame() {
        return game;
    }

    public void setGame(GamePanel game) {
        this.game = game;
    }

    public Button[][] getArrayButton() {
        return arrayButton;
    }

    public void setArrayButton(Button[][] arrayButton) {
        this.arrayButton = arrayButton;
    }
}
