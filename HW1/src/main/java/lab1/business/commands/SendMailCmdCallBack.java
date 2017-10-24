package lab1.business.commands;

import lab1.business.MailInfo;

public class SendMailCmdCallBack implements SendMailCmd {
    public void make(MailInfo mailInfo) {
        System.out.println("We call you back sent to client " + mailInfo);
    }
}