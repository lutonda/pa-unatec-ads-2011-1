/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.service.upload;


import java.util.Random;

/**
 *
 * @author Dirceu
 */
public class Guid {

    private static Guid guidFactory = new Guid();
    static Random random = new Random();

    public static void setGuidImpl(Guid factory) {
        guidFactory = factory;
    }

    public static String getString() {
        return guidFactory.getGuidString().toUpperCase();
    }

    protected String getGuidString() {
        long rand = (random.nextLong() & 0x7FFFFFFFFFFFFFFFL) |
                0x4000000000000000L;
        return Long.toString(rand, 8) +
                Long.toString(System.currentTimeMillis() & 0xFFFFFFFFFFFFFL, 8);
    }
}
