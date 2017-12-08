package it.dryconic.andres.collision;

import it.dryconic.andres.Actors.AbcActor;

public interface _CollisionDetector {

    AbcActor detect();
    void addActor(AbcActor actor);
    void update(AbcActor actor);
}
