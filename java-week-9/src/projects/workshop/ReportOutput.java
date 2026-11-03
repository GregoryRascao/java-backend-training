import java.io.IOException;
import java.util.List;

public interface ReportOutput {
    void write(List<String> lines) throws IOException;
}