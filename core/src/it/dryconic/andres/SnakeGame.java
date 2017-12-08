package it.dryconic.andres;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import it.dryconic.andres.Actors.AbcActor;
import it.dryconic.andres.Actors.Actor;
import it.dryconic.andres.Actors.Fruit;
import it.dryconic.andres.Actors.Snake;
import it.dryconic.andres.collision.CollisionDetector;
import it.dryconic.andres.collision._CollisionDetector;

import java.awt.geom.Point2D;
import java.util.Random;

public class SnakeGame extends ApplicationAdapter implements InputProcessor {

    private Actor snake, fruit;
    private _CollisionDetector detector;

    @Override
    public void create() {
        snake = new Snake(new Point2D.Float(50f, 50f));
        fruit = new Fruit(randomFruitPosition());
        detector = new CollisionDetector((AbcActor) snake);
        detector.addActor((AbcActor) fruit);
    }

    private Point2D.Float randomFruitPosition() {
        Random rand = new Random();
        int x = rand.nextInt() % 250;
        int y = rand.nextInt() % 250;
        x = Math.abs(x);
        y = Math.abs(y);
        return new Point2D.Float(x, y);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.input.setInputProcessor(this);
        if(detector.detect() != null){
            Point2D.Float nPos = randomFruitPosition();
            fruit.update(nPos.x,nPos.y);
            detector.update((AbcActor)fruit);
        }
        snake.render();
        fruit.render();


    }

    @Override
    public void dispose() {
        snake.dispose();
        fruit.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        if (Input.Keys.W == keycode || Input.Keys.UP == keycode) {
            snake.update(0.0f, 2.0f);
        }
        if (Input.Keys.S == keycode || Input.Keys.DOWN == keycode) {
            snake.update(0.0f, -2.0f);
        }
        if (Input.Keys.A == keycode || Input.Keys.LEFT == keycode) {
            snake.update(-2.0f, 0.0f);
        }
        if (Input.Keys.D == keycode || Input.Keys.RIGHT == keycode) {
            snake.update(2.0f, 0.0f);
        }


        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
