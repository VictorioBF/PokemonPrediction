import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ImageDownloader {
    public static void DownloadImage(String url, String filePath) {
        try (InputStream in = URI.create(url).toURL().openStream()) {
            Files.copy(in, Paths.get(filePath));
        } catch (Exception e) {
            System.out.println("Failed to download image from " + url);
            e.printStackTrace();
        }
    }
}
