package atdit1.group5.subpanels;

import java.awt.*;

/**
 * speichert die Koordinaten von Rechtecken auf der QuarryMap.
 * 
 * @author Sophie Orth, Monica Alessi, Dhruv Aggarwal, Maik Fichtenkamm, Lucas
 *         Lahr
 */
public class Rectangle {
    private int x;
    private int y;

    /**
     * erzegt ein Rechteck und die Koordinaten zuweist.
     * 
     * @param p: Point, der die Koordinaten der eines Rechtecks beinhaltet.
     */
    public Rectangle(Point p) {
        x = (int) p.getX();
        y = (int) p.getY();
    }

    /**
     * Getter-Methode für die Koordinate x
     * 
     * @return x
     */
    public int getX() {
        return this.x;
    }

    /**
     * Setter-Methode für die Koordinate x
     * 
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Getter-Methode für die Koordinate y
     * 
     * @return y
     */
    public int getY() {
        return this.y;
    }

    /**
     * Getter-Methode für die Koordinate y
     * 
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

}
