import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class FileReportOutput implements ReportOutput {
    private final Path path;

    public FileReportOutput(Path path) {
        if (path == null) {
            throw new IllegalArgumentException("Path cannot be null");
        }
        this.path = path;
    }

    @Override
    public void write(List<String> lines) throws IOException {
        SimpleFiles.writeLines(path, lines);
    }
}