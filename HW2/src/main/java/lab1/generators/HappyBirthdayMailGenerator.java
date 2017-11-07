package lab1.generators;

import lab1.MailCode;
import lab1.MailGenerator;
import lab1.MailInfo;

@MailCode(3)
public class HappyBirthdayMailGenerator implements MailGenerator {
    @Override
    public String generateHtml(MailInfo mailInfo) {
        return "happy birthday " + mailInfo.getClient().getName();
    }
}
