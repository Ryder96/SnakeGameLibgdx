package it.dryconic.andres.collision;

import java.awt.geom.Point2D;

public class Hitbox {

    private Point2D.Float lTop, lBottom, rTop, rBottom;

    public Hitbox(Point2D.Float lTop, Point2D.Float lBottom, Point2D.Float rTop, Point2D.Float rBottom) {
        updateBox(lTop, lBottom, rTop, rBottom);
    }
    private void updateBox(Point2D.Float lTop, Point2D.Float lBottom, Point2D.Float rTop, Point2D.Float rBottom) {
        this.lTop = lTop;
        this.lBottom = lBottom;
        this.rTop = rTop;
        this.rBottom = rBottom;
    }

}
