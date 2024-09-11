package exercise;

// BEGIN
public class ReversedSequence implements CharSequence{

    String myString;

    @Override
    public int length() {
        return myString.length();
    }

    @Override
    public char charAt(int index) {
        return myString.charAt(index);
    }

    @Override
    public String toString() {
        return myString;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return myString.substring(start, end);
    }

    public ReversedSequence(String myString) {
        this.myString = new StringBuilder(myString).reverse().toString();
    }
}
// END
