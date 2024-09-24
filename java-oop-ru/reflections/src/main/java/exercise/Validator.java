package exercise;

import java.lang.reflect.Field;
import java.util.*;

// BEGIN
public class Validator {
    public static List<String> validate(Address address) throws IllegalAccessException {
        List<String> result = new ArrayList<>();
        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(address);
            if (field.isAnnotationPresent(NotNull.class) && Objects.isNull(value)) {
                result.add(field.getName());
            }
        }
        return result;
    }

    public static Map<String, List<String>> advancedValidate(Address address) throws IllegalAccessException {
        Map<String, List<String>> result = new HashMap<>();
        Field[] fields = address.getClass().getDeclaredFields();
        String nullStr = "can not be null";
        String lengthStr = "length less than ";
        for (Field field : fields) {
            String name = field.getName();
            field.setAccessible(true);
            Object value = field.get(address);
            List<String> errors = new ArrayList<>();

            if (field.isAnnotationPresent(NotNull.class) && Objects.isNull(value)) {
                errors = result.containsKey(field.getName()) ? result.get(name) : new ArrayList<>();
                errors.add(nullStr);
            }

            if (field.isAnnotationPresent(MinLength.class)) {
                MinLength minLength = field.getAnnotation(MinLength.class);
                if (value.toString().length() < minLength.minLength()) {
                    errors = result.containsKey(field.getName()) ? result.get(name) : new ArrayList<>();
                    errors.add(lengthStr + minLength.minLength());
                }
            }

            if (!errors.isEmpty()) {
                result.put(name, errors);
            }
        }
        return result;
    }
}
// END
