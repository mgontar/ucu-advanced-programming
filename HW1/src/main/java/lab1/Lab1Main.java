package lab1;

import lab1.business.Client;
import lab1.business.MailInfo;
import lab1.business.MailSender;
import org.fluttercode.datafactory.impl.DataFactory;

public class Lab1Main {
    public static void main(String[] args) throws InterruptedException {
        MailSender mailSender = new MailSender();
        DataFactory dataFactory = new DataFactory();

        while (true) {
            doWork(mailSender, dataFactory);
            Thread.sleep(1000);
        }
    }

    private static void doWork(MailSender mailSender, DataFactory dataFactory) {
        Client client = new Client(dataFactory.getName(), dataFactory.getNumberBetween(10, 20));
        MailInfo mailInfo = new MailInfo(client, dataFactory.getNumberBetween(1,3));
        mailSender.sendMailNew(mailInfo);
    }
}
