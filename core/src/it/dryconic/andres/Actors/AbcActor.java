package it.dryconic.andres.Actors;

import it.dryconic.andres.providers.PathProvider;

import java.awt.geom.Point2D;

public abstract class AbcActor implements Actor{

    final String SpriteSheetName = PathProvider.ASSET_PATH + "snake.png";
    Point2D.Float position;

    public AbcActor(Point2D.Float point){
        position = point;
    }

    public abstract boolean collide(AbcActor block);
}
