import com.wordcounter.WordCounter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordCounterTest {

    WordCounter wordCounter = new WordCounter();


    @Before
    public void setup()  {
        wordCounter.add("Sky");
        wordCounter.add("Earth");
        wordCounter.add("Flower");
        wordCounter.add("Flor");
        wordCounter.add("Blume");
        wordCounter.add("Vineto");
        wordCounter.add("Water");
        wordCounter.add("Earth");
        wordCounter.add("Fire");
        wordCounter.add("Animal");
        wordCounter.add("Human");
        wordCounter.add("Animal");
        wordCounter.add("Song");
    }


    @Test
    public void totalCountOfWeCounterList(){
        assertEquals(13,wordCounter.getSize());
    }

    @Test
    public void whenWordCountForSingleWord(){
        assertEquals(1, wordCounter.getCount("Song"));
    }
}
