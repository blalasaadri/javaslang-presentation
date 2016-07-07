package com.senacor.blalasaadri.javaslang.presentation;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Random;

import javaslang.Tuple1;
import javaslang.Tuple2;
import javaslang.Tuple3;
import javaslang.Tuple8;

/**
 * @author Alasdair Collinson, Senacor Technologies AG
 */
public class JavaslangValueAndTupleKatas {

    /**
     * Create a {@link javaslang.Tuple} from the given parameter.
     *
     * @param integer an integer which should be wrapped in a tuple
     * @return a tuple containing the given parameter
     */
    public Tuple1<Integer> createATupleFromOneElement(Integer integer) {
        return null;
    }

    /**
     * Create a {@link javaslang.Tuple} from the given parameters.
     *
     * @param integer an integer which should be wrapped in a tuple
     * @param string a string which should be wrapped in a tuple
     * @return a tuple containing the given parameters
     */
    public Tuple2<Integer, String> createATupleFromTwoElements(Integer integer, String string) {
        return null;
    }

    /**
     * Create a {@link javaslang.Tuple} from the given parameters.
     *
     * @param integer an integer which should be wrapped in a tuple
     * @param string a string which should be wrapped in a tuple
     * @param localDate a localDate which should be wrapped in a tuple
     * @return a tuple containing the given parameters
     */
    public Tuple3<Integer, String, LocalDate> createATupleFromThreeElements(Integer integer, String string, LocalDate localDate) {
        return null;
    }

    /**
     * Create a {@link javaslang.Tuple} from the given parameters.
     *
     * @param integer an integer which should be wrapped in a tuple
     * @param string a string which should be wrapped in a tuple
     * @param localDate a date which should be wrapped in a tuple
     * @param bool a boolean which should be wrapped in a tuple
     * @param throwable a Throwable which should be wrapped in a tuple
     * @param random a Random which should be wrapped in a tuple
     * @param field a Field which should be wrapped in a tuple
     * @param enumeration an enum which should be wrapped in a tuple
     * @return a tuple containing the given parameters
     */
    public Tuple8<Integer, String, LocalDate, Boolean, Throwable, Random, Field, Enum<?>> createATupleFromEightElements(Integer integer,
        String string, LocalDate localDate, Boolean bool, Throwable throwable, Random random, Field field, Enum<?> enumeration) {
        return null;
    }
}
