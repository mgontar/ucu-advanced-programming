package lab1.business.commands;

import lab1.business.MailInfo;

public interface SendMailCmd {
    void make(MailInfo mailInfo);
}