package zw.co.rubiem.netone.portal.domain.commons.utils;

import com.fasterxml.uuid.Generators;

import java.util.UUID;

public class RandomUtils {

    private RandomUtils() {
    }

    public static String uuidGenerator() {
        return String.valueOf(System.nanoTime());
    }

    public static String generateToken() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 6).toUpperCase();
    }

    public static String generateTokenWithSeed(String seed) {
        return generateNameBasedUUID(seed).replace("-", "").substring(0, 4).toUpperCase();
    }

    public static String generateNameBasedUUID(String string) {
        UUID nameBasedUUID = Generators.nameBasedGenerator().generate(string);
        System.out.println(nameBasedUUID.toString());
        return nameBasedUUID.toString();
    }
}
