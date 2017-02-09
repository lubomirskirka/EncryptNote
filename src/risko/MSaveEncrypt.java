package risko;

import org.jasypt.util.text.BasicTextEncryptor;

/**
 * Created by Ľubomír Skirka on 05.02.2017.
 */
public class MSaveEncrypt extends MSave {
    private BasicTextEncryptor encryptor;

    public MSaveEncrypt(String fileName, String password) {
        super(fileName);
        encryptor = new BasicTextEncryptor();
        encryptor.setPassword(password);
    }

    @Override
    public void write(int lineNumber, String data) {
        super.write(lineNumber, encryptor.encrypt(data));
    }

    @Override
    public String read(int lineNumber) {
        return encryptor.decrypt(super.read(lineNumber));
    }

    public void setPassword(String password){
        encryptor = new BasicTextEncryptor();
        encryptor.setPassword(password);
    }
}
