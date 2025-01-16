public class HistogramElement {

    private final String key;
    private final int value;

    public HistogramElement(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}
