package Expection;

public class InvalidBookCountException extends IllegalArgumentException {
    String expect;

    public InvalidBookCountException(String expect) {
        this.expect = expect;
    }

    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect;
    }
}
