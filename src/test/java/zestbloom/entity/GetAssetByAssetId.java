package zestbloom.entity;

public class GetAssetByAssetId {
    public int assetId;
    public boolean isDestroyed;

    public int getAssetId() {
        return assetId;
    }

    public void setAssetId(int assetId) {
        this.assetId = assetId;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }

    @Override
    public String toString() {
        return "GetAssetByAssetId{" +
                "assetId=" + assetId +
                ", isDestroyed=" + isDestroyed +
                '}';
    }
}

