package zestbloom;

public class GraphQLQueries {




    public static String getAssetsBy_firstAssetId_hasMedia_isDestroyed_limit_network_offset_orderBy(String firstAssetId,
                                                                                                    String hasMedia,
                                                                                                    String isDestroyed,
                                                                                                    String limit,
                                                                                                    String network,
                                                                                                    String offset,
                                                                                                    String orderBy){
        return "getAssets(firstAssetId: "+firstAssetId+", hasMedia: "+hasMedia+", isDestroyed: "+isDestroyed+", limit: "+limit+", network: "+network+", offset: "+offset+", orderBy: "+orderBy+") {\\n" +
                "        assetId\\n" +
                "  }";
    }


    public static String getAssetsBy_createdAt_description_id_isDestroyed_isNsfw_name_network_updatedAt(
            ){
        return "getAssets {createdAt" +
                "    id\\n" +
                "    description\\n" +
                "    isDestroyed\\n" +
                "    isNsfw\\n" +
                "    name\\n" +
                "    network\\n" +
                "  }";
    }

    public static String getAssetsBy_name_values(){
        return "getAssets {\\n" +
                "\\n" +
                "    stringTraits {\\n" +
                "      name\\n" +
                "      value\\n" +
                "    }\\n" +
                "  }";
    }

    public static String getAssetsByassestIdandNetwork(String id){
        return "getAssetByAssetId(assetId: "+id+", network: ALGO) {\\n" +
                "    id\\n" +
                "  }";
    }

    public static String getAssetsByassestIdandNetworkWithAssetInfo(String id){
        return "getAssetByAssetId(assetId: "+id+", network: ALGO) {\\n" +
                "    assetInfo\\n" +
                "  }";
    }

    public static String getAssetsByassestIdandNetworkWithAssetInfoAssetMetaDataNameNetwork(String id){
        return "getAssetByAssetId(assetId: "+id+", network: ALGO) {\\n" +
                "    assetInfo\\n" +
                "assetMetadata\\n"+
                "name\\n"+
                "network\\n"+
                "  }";
    }
    public static String getAssetsByassestsIdandNetworkWithAssetInfoAssetMetaDataNameNetwork(String id){
        return "  getAssetsByAssetId(assetIds: ["+id+"], network: ALGO) {\\n" +
                "    assetInfo\\n" +
                "    assetMetadata\\n" +
                "    network\\n" +
                "    name\\n" +
                "  }";
    }

    public static String getTagsWthID(){
        return "getTags {\\n" +
                "    id\\n" +
                "  }";
    }
    public static String getTagsWthName(){
        return "getTags {\\n" +
                "    name\\n" +
                "  }";
    }
    public static String getTagsWthimit(){
        return "getTags(limit: 1) {\\n" +
                "        id\\n" +
                "      }";
    }

    public static String getTagWithId(){
        return "getTag(tagName: \\\"string91\\\") {\\n" +
                "    id\\n" +
                "  }";
    }

    public static String getTagWithName(){
        return "getTag(tagName: \\\"string91\\\") {\\n" +
                "    name\\n" +
                "  }";
    }
}

