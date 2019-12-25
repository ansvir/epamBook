package part.two.chapter.three;

public class InvalidSentenceException extends Exception {
    private String message;

    InvalidSentenceException(String message) {
        this.message=message;
    }

    InvalidSentenceException() {}

    @Override
    public String toString() {
        return this.message;
    }
}
