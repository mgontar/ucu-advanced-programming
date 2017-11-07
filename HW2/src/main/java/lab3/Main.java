package lab3;

import lombok.SneakyThrows;
import org.fluttercode.datafactory.impl.DataFactory;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        HttpStatusService httpStatusService = new HttpStatusService();
        DataFactory dataFactory = new DataFactory();

        while (true) {
            int httpStatusCode = dataFactory.getNumberBetween(0, 600);

            try {
                httpStatusService.handleHttpStatus(httpStatusCode);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            Thread.sleep(1000);
        }
    }
}
