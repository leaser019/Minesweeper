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

    public JPanel getPanelLeft() {
        return panelLeft;
    }

    public void setPanelLeft(JPanel panelLeft) {
        this.panelLeft = panelLeft;
    }

    public JPanel getPanelRight() {
        return panelRight;
    }

    public void setPanelRight(JPanel panelRight) {
        this.panelRight = panelRight;
    }

    public JPanel getPanelCenter() {
        return panelCenter;
    }

    public void setPanelCenter(JPanel panelCenter) {
        this.panelCenter = panelCenter;
    }

    public Number getLabelLeft() {
        return labelLeft;
    }

    public void setLabelLeft(Number labelLeft) {
        this.labelLeft = labelLeft;
    }

    public Number getLabelRight() {
        return labelRight;
    }

    public void setLabelRight(Number labelRight) {
        this.labelRight = labelRight;
    }

    public SmileButton getIcon() {
        return icon;
    }

    public void setIcon(SmileButton icon) {
        this.icon = icon;
    }
    public Button[][] getArrayButton() {
        return arrayButton;
    }

    public void setArrayButton(Button[][] arrayButton) {
        this.arrayButton = arrayButton;
    }
}
