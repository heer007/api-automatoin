package zestbloom.responseentity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.restassured.response.ResponseBody;

import java.util.ArrayList;
import java.util.Date;

public class Asset {
    public int total_count;
    public ArrayList<Datum> data;
}
 class Arc3{
}

 class Arc69{
    public String standard;
    public Properties properties;
    public String description;
    public String external_url;
    public String mime_type;
}

 class AssetInfo{
    public String url;
    public String name;
    public int round;
    public int total;
    public String freeze;
    public String creator;
    public String manager;
    public String reserve;
    public String url_b64;
    public String clawback;
    public int decimals;
    public String name_b64;
    public String unit_name;
    public Object metadata_hash;
    public String unit_name_b64;
    public boolean default_frozen;
}

 class AssetMetadata{
    public Arc3 arc3;
    public Arc69 arc69;
}

 class Datum{
    public String description;
    public String network;
    public Media media;
    public int id;
    public int asset_id;
    public boolean is_destroyed;
    public String name;
    public Object embedding;
    public AssetInfo asset_info;
    public AssetMetadata asset_metadata;
}

 class Media{
    public String url;
    public String mime;
}

 class Properties{
    public String id;
    public String url;
    public Date time;
    public String type;
    @JsonProperty("class")
    public String myclass;
    public int depth;
    public String place;
    public String title;
    public String source;
    public String subType;
    public double latitude;
    public double longitude;
    public double magnitude;
    public String name;
    @JsonProperty("Level")
    public String level;
    public String descriptionOfNFT;
}
