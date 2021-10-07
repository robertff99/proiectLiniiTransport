package client.Raport;

import java.io.File;
import java.io.IOException;

public interface Report {
    File createReport(String path, String name) throws IOException;

}
