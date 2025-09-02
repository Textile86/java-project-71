package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Difference;
import java.util.List;

public class JsonFormatter {
    public static String format(List<Difference> differences) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(differences);
    }
}

