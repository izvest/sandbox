package sandbox.model;

public class ValidationResult<T> {

    private boolean valid;
    private String selite;
    private T payload;

    public ValidationResult(boolean valid, String selite, T payload){
        this.valid = valid;
        this.selite = selite;
        this.payload = payload;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getSelite() {
        return selite;
    }

    public void setSelite(String selite) {
        this.selite = selite;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

}