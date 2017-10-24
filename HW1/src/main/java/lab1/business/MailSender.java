package lab1.business;

import lab1.business.commands.SendMailCmd;
import lab1.business.commands.SendMailCmdCallBack;
import lab1.business.commands.SendMailCmdWelcome;

import java.util.HashMap;
import java.util.Map;

public class MailSender {

    public void sendMailOld(MailInfo mailInfo){
        switch (mailInfo.getMailCode()) {
            case 1:
                System.out.println("Welcome sent to client " + mailInfo);
                break;
            case 2:
                System.out.println("We call you back sent to client " + mailInfo);
                break;
        }
    }

    Map<Integer, SendMailCmd> cmdMap = new HashMap<Integer, SendMailCmd>();
    public MailSender() {
        cmdMap.put(1, new SendMailCmdWelcome());
        cmdMap.put(2, new SendMailCmdCallBack());
    }

    public void sendMailNew(MailInfo mailInfo){
        if (cmdMap.containsKey(mailInfo.getMailCode()))
        {
            cmdMap.get(mailInfo.getMailCode()).make(mailInfo);
        }
    }
}