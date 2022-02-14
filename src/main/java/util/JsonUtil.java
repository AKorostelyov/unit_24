package util;

import com.google.gson.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class JsonUtil {
    public static String serialize(Object obj) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(obj);
    }

    public static<T> String serializeCollection(List<T> collection) {
        JsonObject result = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        result.add(collection.get(0).getClass().getSimpleName().toLowerCase(Locale.ROOT), jsonArray);

        for (Object obj : collection) {
            jsonArray.add(serialize(obj));
        }
        return result.toString();
    }

    public static <T> T deserialize(String json, Class<T> type) {
        return new Gson().fromJson(json, type);
    }

    public static <T> List<T> deserializeCollection(String json, Class<T> type) {
        List<T> collection = new ArrayList<>();
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        JsonArray jsonCollection = jsonObject.getAsJsonArray(jsonObject.keySet().toArray()[0].toString());
        for (JsonElement jsonElement : jsonCollection) {
            collection.add(deserialize(jsonElement.getAsString(), type));
        }
        return collection;
    }
}
