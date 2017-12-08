package it.dryconic.andres.Actors;

import it.dryconic.andres.utils.SpriteSheet;

import java.awt.geom.Point2D;
import java.util.Random;

public class Fruit extends AbcActor{

    private SpriteSheet spriteSheet;
    private int index = 0;

    public Fruit(Point2D.Float point){
        super(point);
        spriteSheet = new SpriteSheet(this.SpriteSheetName);
    }

    @Override
    public boolean collide(AbcActor block) {
        return false;
    }

    @Override
    public void render() {
        updateTexture();
        spriteSheet.render(position);
    }

    private void updateTexture() {
        spriteSheet.updateRegion(index * 64,8 * 64,64,64);
    }

    @Override
    public void update(float x, float y) {
        position.x = x;
        position.y = y;
        Random random = new Random();
        index = random.nextInt() % 5;
        index = Math.abs(index);
    }

    @Override
    public void dispose() {
        spriteSheet.dispose();
    }
}
