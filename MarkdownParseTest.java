import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void originalFile() throws IOException {
        Path fileName = Path.of("test-file.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);

        assertEquals(List.of("https://something.com", "some-page.html"), links);
    }

    @Test
    public void fileWithImage() throws IOException {
        Path fileName = Path.of("image.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);

        assertEquals(List.of("google.com"), links);
    }

    @Test
    public void incorrectFormat() throws IOException {
        Path fileName = Path.of("incorrect.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);

        assertEquals(List.of(), links);
    }
}