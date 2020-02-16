package sandbox.model;

public class BooleanResult<T> {

    private boolean result;
    private String selite;
    private T payload;

    public BooleanResult(boolean result, String selite, T payload){
        this.result = result;
        this.selite = selite;
        this.payload = payload;
    }

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
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