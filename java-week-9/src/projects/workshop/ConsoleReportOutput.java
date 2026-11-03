import java.util.List;

public class ConsoleReportOutput implements ReportOutput {
    @Override
    public void write(List<String> lines) {
        for (String line : lines) {
            System.out.println(line);
        }
    }
}