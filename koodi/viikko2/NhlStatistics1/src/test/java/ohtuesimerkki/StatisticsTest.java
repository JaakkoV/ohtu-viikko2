/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.rmi.CORBA.Stub;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jaakvirt
 */
public class StatisticsTest {

    Reader readerStub = new Reader() {
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {
        // luodaan Staatistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void topScorers() {
        List<Player> expected = readerStub.getPlayers();
        Collections.sort(expected);
        assertEquals(expected.get(0).getName(), stats.topScorers(1).get(0).getName());
    }
    
    @Test
    public void team() {
        Player expected = new Player("Lemieux", "PIT", 45, 54);
        assertEquals(expected.getName(), stats.team("PIT").get(0).getName());
    }
    
    @Test
    public void search() {
        Player expected = new Player("Lemieux", "PIT", 45, 54);
        assertEquals(expected.getName(), stats.search("Lemieux").getName());
        assertEquals(null, stats.search("empty"));
    }
    
}
    