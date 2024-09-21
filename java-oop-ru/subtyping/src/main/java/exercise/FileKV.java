package exercise;

import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage{
    private String path;
    private Map<String, String> map;

    @Override
    public void set(String key, String value) {
        map = Utils.deserialize(Utils.readFile(path));
        map.put(key, value);
        Utils.writeFile(path, Utils.serialize(map));
    }

    @Override
    public void unset(String key) {
        map = Utils.deserialize(Utils.readFile(path));
        map.remove(key);
        Utils.writeFile(path, Utils.serialize(map));
    }

    @Override
    public String get(String key, String defaultValue) {
        map = Utils.deserialize(Utils.readFile(path));
        return map.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return Utils.deserialize((Utils.readFile(path)));
    }

    public FileKV(String path, Map<String, String> map){
        this.path = path;
        this.map = map;
        Utils.writeFile(path, Utils.serialize(map));
    }
}
// END
