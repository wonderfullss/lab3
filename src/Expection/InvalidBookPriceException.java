package Expection;

public class InvalidBookPriceException extends IllegalArgumentException {
    String expect;

    public InvalidBookPriceException(String expect) {
         this.expect = expect;
    }

    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect;
    }
}
