package by;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Test {
    public static void main(String[] args) throws IOException {
        Test.encodeFromUTF_8InKOI8_R();
        Test.encodeFromKOI8_RInUTF_8();
    }

    private static void encodeFromUTF_8InKOI8_R() throws IOException {
        FileInputStream fis = new FileInputStream("src/by/FileFromRead");
        FileOutputStream fos = new FileOutputStream("src/by/FileFromWriteEncodingKOI8-R");
        byte[] arrayBytes = new byte[fis.available()];
        fis.read(arrayBytes);
        String stringDataFile = new String(arrayBytes, StandardCharsets.UTF_8);
        Charset koi8_r = Charset.forName("KOI8-R");
        arrayBytes = stringDataFile.getBytes(koi8_r);
        fos.write(arrayBytes);
        fis.close();
        fos.close();
    }

    private static void encodeFromKOI8_RInUTF_8() throws IOException {
        FileInputStream fis = new FileInputStream("src/by/FileFromWriteEncodingKOI8-R");
        FileOutputStream fos = new FileOutputStream("src/by/FileFromWriteEncodingUTF-8");
        byte[] arrayBytes = new byte[fis.available()];
        fis.read(arrayBytes);
        String stringDataFile2 = new String(arrayBytes, "KOI8-R");
        Charset utf_8 = StandardCharsets.UTF_8;
        arrayBytes = stringDataFile2.getBytes(utf_8);
        fos.write(arrayBytes);
        fis.close();
        fos.close();
    }
}
