package lab1.business.commands;

import lab1.business.MailInfo;

public class SendMailCmdWelcome implements SendMailCmd {
    public void make(MailInfo mailInfo) {
        System.out.println("Welcome sent to client " + mailInfo);
    }
}
