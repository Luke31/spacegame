package ch.bbbaden.space.entities;

import ch.bbbaden.space.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.util.Log;

/**
 * @author avi
 */
public class Shot extends Entity {
    
    private Sound mSound;
    
    public Shot(float x, float y) {
        super(x, y, "images/shot.png");
        
        try {
            mSound = new Sound("sounds/laser.wav");
            mSound.play();
        } catch (SlickException e) {
            Log.error("Fehler: " + e.getMessage());
        }
    }

    @Override
    public Type getType() {
        return Entity.Type.Shot;
    }

    public void update(GameContainer container, int delta) {
        mY -= delta * Game.SHOT_SPEED;
        
        // check if y position out of screen boundaries
        if (mY < -50) {
            destroy();
        }
    }
    
}
