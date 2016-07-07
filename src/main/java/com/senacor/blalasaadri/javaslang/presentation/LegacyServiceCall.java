package com.senacor.blalasaadri.javaslang.presentation;

/**
 * @author Alasdair Collinson, Senacor Technologies AG
 */
public final class LegacyServiceCall {

    public static int halve(int i) {
        if (i % 2 == 0) {
            return i / 2;
        }
        throw new IllegalArgumentException(String.format("'%d' cannot be halved", i));
    }

}
