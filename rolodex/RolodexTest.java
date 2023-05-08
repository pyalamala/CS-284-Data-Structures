package rolodex;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RolodexTest {

    @Test
    public void constructorTest(){
        Rolodex r = new Rolodex();
        assertEquals(r.toString(), "Separator A\n" + "Separator B\n" + "Separator C\n" + "Separator D\n" + "Separator E\n" + "Separator F\n" + "Separator G\n" + "Separator H\n" + "Separator I\n" + "Separator J\n" + "Separator K\n" + "Separator L\n" + "Separator M\n" +
        "Separator N\n" + "Separator O\n" + "Separator P\n" + "Separator Q\n" + "Separator R\n" + "Separator S\n" + "Separator T\n" + "Separator U\n" + "Separator V\n" + "Separator W\n" + "Separator X\n" + "Separator Y\n" + "Separator Z\n");

    }
    
    @Test
    public void containsTest(){
        Rolodex r = new Rolodex();
        r.addCard("Eren", "777");
        assertEquals(r.contains("Eren"), true);
        assertEquals(r.contains("Annie"), false);

    }

    @Test
    public void sizeTest(){
        Rolodex r = new Rolodex();
        r.addCard("Eren", "777");
        r.addCard("Annie", "345");
        r.addCard("Destiny", "234");
        r.addCard("Ash", "444");
        assertEquals(r.size(), 4);
    }

    @Test
    public void lookupTest(){
        Rolodex r = new Rolodex();
        r.addCard("Eren", "777");
        r.addCard("Annie", "345");
        r.addCard("Eren", "234");
        assertEquals(r.lookup("Eren").toString(), "[234, 777]");
    }
    
    @Test
    public void addCardTest(){
        Rolodex r = new Rolodex();
        r.addCard("Eren", "777");
        r.addCard("Annie", "345");
        assertEquals(r.toString(), "Separator A\n" + "Name: Annie, Cell: 345\n" + "Separator B\n" + "Separator C\n" + "Separator D\n" + "Separator E\n" + "Name: Eren, Cell: 777\n" + "Separator F\n" + "Separator G\n" + "Separator H\n" + "Separator I\n" + "Separator J\n" + "Separator K\n" + "Separator L\n" + "Separator M\n" +
        "Separator N\n" + "Separator O\n" + "Separator P\n" + "Separator Q\n" + "Separator R\n" + "Separator S\n" + "Separator T\n" + "Separator U\n" + "Separator V\n" + "Separator W\n" + "Separator X\n" + "Separator Y\n" + "Separator Z\n");
    }

    @Test
    public void removeCardTest(){
        Rolodex r = new Rolodex();
        r.addCard("Eren", "777");
        r.addCard("Annie", "345");
        r.removeCard("Eren", "777");
        assertEquals(r.toString(), "Separator A\n" + "Name: Annie, Cell: 345\n" + "Separator B\n" + "Separator C\n" + "Separator D\n" + "Separator E\n" + "Separator F\n" + "Separator G\n" + "Separator H\n" + "Separator I\n" + "Separator J\n" + "Separator K\n" + "Separator L\n" + "Separator M\n" +
        "Separator N\n" + "Separator O\n" + "Separator P\n" + "Separator Q\n" + "Separator R\n" + "Separator S\n" + "Separator T\n" + "Separator U\n" + "Separator V\n" + "Separator W\n" + "Separator X\n" + "Separator Y\n" + "Separator Z\n");
    }

    @Test
    public void removeAllCards(){
        Rolodex r = new Rolodex();
        r.addCard("Eren", "777");
        r.addCard("Annie", "345");
        r.addCard("Eren", "234");
        r.removeAllCards("Eren");
        assertEquals(r.toString(), "Separator A\n" + "Name: Annie, Cell: 345\n" + "Separator B\n" + "Separator C\n" + "Separator D\n" + "Separator E\n" + "Separator F\n" + "Separator G\n" + "Separator H\n" + "Separator I\n" + "Separator J\n" + "Separator K\n" + "Separator L\n" + "Separator M\n" +
        "Separator N\n" + "Separator O\n" + "Separator P\n" + "Separator Q\n" + "Separator R\n" + "Separator S\n" + "Separator T\n" + "Separator U\n" + "Separator V\n" + "Separator W\n" + "Separator X\n" + "Separator Y\n" + "Separator Z\n");
    }
}
