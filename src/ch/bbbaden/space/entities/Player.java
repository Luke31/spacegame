package ch.bbbaden.space.entities;

import ch.bbbaden.space.Game;
import ch.bbbaden.space.Space;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

/**
 * @author avi
 */
public class Player extends Entity {
    
    protected Space mSpace;
    protected int mTimeSinceLastShot;
    
    public Player(float x, float y, Space space) {
        super(x, y, "images/player.png");
        mSpace = space;
        mTimeSinceLastShot = 0;
    }

    @Override
    public Type getType() {
        return Type.Player;
    }

    public void update(GameContainer container, int delta) {
        Input input = container.getInput();
        
        if (input.isKeyDown(Input.KEY_LEFT)) {
            mX -= delta * Game.PLAYER_SPEED;
            if (mX < 0) mX = 0;
        }
        
        if (input.isKeyDown(Input.KEY_RIGHT)) {
            mX += delta * Game.PLAYER_SPEED;
            if (mX > Game.SCREEN_WIDTH) mX = Game.SCREEN_WIDTH;
        }
        
        if (input.isKeyDown(Input.KEY_UP)) {
            mY -= delta * Game.PLAYER_SPEED;
            if (mY < 0) mY = 0;
        }
        
        if (input.isKeyDown(Input.KEY_DOWN)) {
            mY += delta * Game.PLAYER_SPEED;
            if (mY > Game.SCREEN_HEIGHT) mY = Game.SCREEN_HEIGHT;
        }
        
        mTimeSinceLastShot += delta;
        if (mTimeSinceLastShot > Game.TIME_BETWEEN_SHOTS && input.isKeyDown(Input.KEY_SPACE)) {
            mTimeSinceLastShot = 0;
            mSpace.addEntity(new Shot(mX, mY - 25));
        }
    }
    
}
