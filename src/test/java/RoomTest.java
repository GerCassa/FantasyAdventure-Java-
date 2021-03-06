import Creatures.Creature;
import Dungeon.Room;
import PlayerProperties.Weapon;
import Players.Fighters.Warrior;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RoomTest {
    Room room;
    Creature creature;
    Warrior warrior;
    Warrior warrior2;
    Weapon weapon;



    @Before
    public void before(){
        weapon = new Weapon("ShotGun", 100);
        creature = new Creature("minotaur", 100, 50,1);
        warrior = new Warrior("Terminator", 50, weapon);
        warrior2 = new Warrior("Terminator2", 50, weapon);
        room = new Room(100, creature);
    }

    @Test
    public void canCollectTreasure(){
        warrior.attack(creature);
        assertTrue(room.canCollectTreasure());
    }
    @Test
    public void roomHasPlayers(){
        room.addPlayer(warrior);
        assertEquals(1, room.countPlayers());
    }

    @Test
    public void playersCollectBounty(){
        room.addPlayer(warrior);
        room.addPlayer(warrior2);
        warrior.attack(creature);
        room.playersCollectTreasure();
        assertEquals(50 , warrior.getMoney());
    }
}
