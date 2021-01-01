package practice.functional.biman.prg2;

public abstract class Result {

    static Result success() {
        return new Success();
    }

    static Result failure(String message) {
        return new Failure(message);
    }

    static class Success extends Result {

    }

    static class Failure extends Result {

        private final String failureMessage;

        public Failure(String failureMessage) {
            this.failureMessage = failureMessage;
        }

        public String getFailureMessage() {
            return failureMessage;
        }
    }
}

