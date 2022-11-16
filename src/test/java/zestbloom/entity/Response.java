package zestbloom.entity;

public class Response {
    public Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Root{" +
                "data=" + data +
                '}';
    }

}