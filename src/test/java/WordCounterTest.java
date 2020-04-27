import com.wordcounter.WordCounter;
import com.wordcounter.WordCounterException;
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

    @Test
    public void whenWordCountForMultipleWords() {
        assertEquals(3, wordCounter.getCount("Flower"));
    }

    @Test
    public void whenWordCountForSingleForeignWords()  {
        assertEquals(1, wordCounter.getCount("Vineto"));
    }

    @Test
    public void whenWordCountForMultipleForeignWords()  {
        assertEquals(3, wordCounter.getCount("Flor"));
    }


    @Test(expected = WordCounterException.class)
    public void whenCounterHasNoData() throws WordCounterException {
        wordCounter=new WordCounter();
        assertEquals(3, wordCounter.getCount("Flor"));
    }

}
