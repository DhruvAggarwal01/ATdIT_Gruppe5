package subpanels;

import java.awt.*;
import javax.swing.*;

public class Rectangle {
    private int x;
    private int y;

    public Rectangle(Point p){
        x = (int) p.getX();
        y = (int) p.getY();
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }
}   
