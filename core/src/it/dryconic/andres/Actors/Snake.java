package it.dryconic.andres.Actors;

import it.dryconic.andres.utils.SpriteSheet;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class Snake extends AbcActor {

    private List<Point2D.Float> tail;
    private float speedX, speedY;
    private int frame, row, spriteAcross;
    private final int spriteWidth = 64, spriteHeight = 64;
    private SpriteSheet spriteSheet;

    public Snake(Point2D.Float startPos) {
        super(startPos);
        frame = row = spriteAcross = 0;
        speedX = speedY = 0;
        tail = new ArrayList<Point2D.Float>(0);
        spriteSheet = new SpriteSheet(this.SpriteSheetName);
    }

    @Override
    public boolean collide(AbcActor block) {
        return this.position.distance(block.position) <= 10;

    }

    @Override
    public void render() {
        moveSnake();
        updateTexture();
        spriteSheet.render(position);
        drawTail();
    }

    private void updateTexture() {
        int index = (frame / 10) % 5;
        spriteSheet.updateRegion(index * spriteHeight + spriteAcross, row * spriteHeight + spriteAcross, spriteWidth, spriteHeight);
    }

    private void moveSnake() {
        position.x += speedX;
        position.y += speedY;
        if (frame <= 59)
            frame++;
        else
            frame = 0;
    }

    private void drawTail() {
        int index = ((frame / 10) % 5) + 4;
        for (Point2D.Float square : tail) {
            spriteSheet.updateRegion(index,
                    row + 4 + spriteAcross,
                    spriteWidth + spriteAcross,
                    spriteHeight + spriteAcross);
            spriteSheet.render(square);
        }
    }

    @Override
    public void update(float xSpeed, float ySpeed) {
        speedX = xSpeed;
        speedY = ySpeed;
        changeRow(xSpeed, ySpeed);
    }

    private void changeRow(float x, float y) {
        if (x > 0) row = 0;
        if (x < 0) row = 1;
        if (y > 0) row = 2;
        if (y < 0) row = 3;
    }

    @Override
    public void dispose() {
        spriteSheet.dispose();
    }

}
