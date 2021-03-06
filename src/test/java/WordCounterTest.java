import com.wordcounter.WordCounter;
import com.wordcounter.WordCounterException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordCounterTest {

    WordCounter wordCounter = new WordCounter();

    @Before
    public void setup() throws WordCounterException {
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
    public void totalCountOfWeCounterList() {
        assertEquals(13, wordCounter.getSize());
    }

    @Test
    public void whenWordCountForSingleWord() throws WordCounterException {
        assertEquals(1, wordCounter.getCount("Song"));
    }

    @Test
    public void whenWordCountForMultipleWords() throws WordCounterException {
        assertEquals(3, wordCounter.getCount("Flower"));
    }

    @Test
    public void whenWordCountForSingleForeignWords() throws WordCounterException {
        assertEquals(1, wordCounter.getCount("Vineto"));
    }

    @Test
    public void whenWordCountForMultipleForeignWords() throws WordCounterException {
        assertEquals(3, wordCounter.getCount("Flor"));
    }


    @Test(expected = WordCounterException.class)
    public void whenCounterHasNoData() throws WordCounterException {
        wordCounter = new WordCounter();
        assertEquals(3, wordCounter.getCount("Flor"));
    }

    @Test(expected = WordCounterException.class)
    public void whenCounterHasNonAlphabetData() throws WordCounterException {
        wordCounter.add("^&%%^");
        assertEquals(13, wordCounter.getSize());
    }

    @Test(expected = WordCounterException.class)
    public void whenCounterAddNull() throws WordCounterException {
        wordCounter.add(null);
        assertEquals(13, wordCounter.getSize());
    }

    @Test
    public void whenCounterAddAMillion() throws WordCounterException {
        for (int i = 0; i <= 1000000; i++) {
            wordCounter.add("Moon");
        }
        assertEquals(1000001, wordCounter.getCount("Moon"));
    }

}
