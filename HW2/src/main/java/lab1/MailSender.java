package lab1;


import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MailSender {

    private Map<Integer, MailGenerator> map = new HashMap<>();

    @SneakyThrows
    public MailSender() {
        Reflections scanner = new Reflections("lab1");
        Set<Class<? extends MailGenerator>> classes = scanner.getSubTypesOf(MailGenerator.class);
        for (Class<? extends MailGenerator> mgClass : classes) {
            if (!Modifier.isAbstract(mgClass.getModifiers())) {
                MailCode annotation = mgClass.getAnnotation(MailCode.class);
                if (annotation != null) {
                    int mailCode = annotation.value();
                    MailGenerator mgObj = mgClass.newInstance();
                    map.put(mailCode, mgObj);
                }
            }
        }
    }

    public void sendMail(MailInfo mailInfo) {

        MailGenerator mailGenerator = map.get(mailInfo.getMailCode());
        if (mailGenerator == null) {
            throw new IllegalStateException(mailInfo.getMailCode() + " not supported yet");
        }
        String html = mailGenerator.generateHtml(mailInfo);
        send(html,mailInfo);


    }

    private void send(String html, MailInfo mailInfo) {
        System.out.println("sending to ... " + html);
    }


}
