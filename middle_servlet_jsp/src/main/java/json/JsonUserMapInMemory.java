package json;

import java.util.concurrent.ConcurrentHashMap;

public class JsonUserMapInMemory {
    private static final JsonUserMapInMemory INSTANCE = new JsonUserMapInMemory();
    private ConcurrentHashMap<JsonUser, JsonUser> jsonUserMap = new ConcurrentHashMap<>();

    public static JsonUserMapInMemory getInstance() {
        return INSTANCE;
    }

    public void addJsonUser(JsonUser jsonUser) {

        jsonUserMap.put(jsonUser, jsonUser);
    }
    public void dellJsonUser(JsonUser jsonUser) {

        jsonUserMap.remove(jsonUser);
    }
    public ConcurrentHashMap getMap() {
        return jsonUserMap;
    }
}
