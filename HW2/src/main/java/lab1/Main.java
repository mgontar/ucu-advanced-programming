package lab1;

import lombok.SneakyThrows;
import org.fluttercode.datafactory.impl.DataFactory;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        MailSender mailSender = new MailSender();
        DataFactory dataFactory = new DataFactory();

        while (true) {
            MailInfo mailInfo = null;
            mailInfo = new MailInfo(dataFactory.getNumberBetween(1, 4));
            mailInfo.setClient(new Client(dataFactory.getName(), dataFactory.getNumberBetween(10, 100)));
            try {
                mailSender.sendMail(mailInfo);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            Thread.sleep(1000);
        }
    }
}
