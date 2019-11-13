package json;

import java.util.concurrent.ConcurrentHashMap;

public class JsonUserMapInMemory {
    private ConcurrentHashMap<JsonUser, JsonUser> jsonUserMap = new ConcurrentHashMap<>();
    public void addJsonUser (JsonUser jsonUser) {
        jsonUserMap.put(jsonUser, jsonUser);
    }
    public void dellJsonUser (JsonUser jsonUser) {
        jsonUserMap.remove(jsonUser);
    }
}
