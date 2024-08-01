import java.util.HashMap;
import java.util.Map;

public class ShapeRegistry {
    private Map<String, Shape> m1 = new HashMap<>();

    public void addPrototype(String key, Shape shape){
        m1.put(key,shape);
    }

    public Shape getPrototype(String key){
        if(!m1.containsKey(key)){
            throw new IllegalArgumentException("Incorrect key provided to get Shape from factory");
        }
        return m1.get(key);
    }
}
