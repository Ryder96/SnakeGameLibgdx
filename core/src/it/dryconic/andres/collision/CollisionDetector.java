package it.dryconic.andres.collision;

import it.dryconic.andres.Actors.AbcActor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollisionDetector implements _CollisionDetector {

    private AbcActor mainActor;
    private List<AbcActor> blocks;

    public CollisionDetector(AbcActor main) {
        blocks = new ArrayList<AbcActor>();
        mainActor = main;
    }

    public void addActor(AbcActor actor) {
        blocks.add(actor);
    }

    @Override
    public void update(AbcActor actor) {
        blocks.add(actor);
    }


    @Override
    public AbcActor detect() {
        Iterator<AbcActor> itBlocks = blocks.iterator();
        boolean found = false;
        AbcActor rtrn = null, block;
        while (!found && itBlocks.hasNext()) {
            block = itBlocks.next();
            found = mainActor.collide(block);
            if(found) {
                rtrn = block;
            }
        }
        return rtrn;
    }
}
