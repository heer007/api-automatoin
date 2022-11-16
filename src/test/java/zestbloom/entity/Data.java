package zestbloom.entity;

public class Data {
    public GetAssetByAssetId getAssetByAssetId;

    public GetAssetByAssetId getGetAssetByAssetId() {
        return getAssetByAssetId;
    }

    public void setGetAssetByAssetId(GetAssetByAssetId getAssetByAssetId) {
        this.getAssetByAssetId = getAssetByAssetId;
    }

    @Override
    public String toString() {
        return "Data{" +
                "getAssetByAssetId=" + getAssetByAssetId +
                '}';
    }
}


