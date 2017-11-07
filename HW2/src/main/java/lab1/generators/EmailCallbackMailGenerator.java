package lab1.generators;

import lab1.MailCode;
import lab1.MailGenerator;
import lab1.MailInfo;

@MailCode(2)
public class EmailCallbackMailGenerator implements MailGenerator {
    @Override
    public String generateHtml(MailInfo mailInfo) {
        return "<html> don't call use we call you</html>";
    }
}
