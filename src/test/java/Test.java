import javax.crypto.KeyGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author William Suane on 6/14/2017.
 */
public class Test {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        String key = Base64.getEncoder().encodeToString(keyGen.generateKey().getEncoded());
        System.out.println(key);
    }
}
