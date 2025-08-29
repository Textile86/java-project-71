package hexlet.code;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Difference {
    private final String key;
    private final String status;
    private final Object oldValue;
    private final Object newValue;

}

