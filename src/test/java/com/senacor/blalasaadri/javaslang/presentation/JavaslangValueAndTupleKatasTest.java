package com.senacor.blalasaadri.javaslang.presentation;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import javaslang.Tuple1;
import javaslang.Tuple2;
import javaslang.Tuple3;
import javaslang.Tuple8;

/**
 * @author Alasdair Collinson, Senacor Technologies AG
 */
public class JavaslangValueAndTupleKatasTest {

    private static final int INTEGER = 42;
    private static final String STRING = "Hello, World";
    private static final LocalDate LOCAL_DATE = LocalDate.of(1987, 5, 17);
    private static final boolean BOOL = false;
    private static final Random RANDOM = new Random();
    private AreYouCrazyError throwable;
    private Field field;

    public JavaslangValueAndTupleKatas javaslangValueAndTupleKatas;

    @Before
    public void setup() throws NoSuchFieldException {
        javaslangValueAndTupleKatas = new JavaslangValueAndTupleKatas();
        throwable = new AreYouCrazyError("That's nuts!");
        field = JavaslangValueAndTupleKatasTest.class.getField("javaslangValueAndTupleKatas");
    }

    @Test
    public void getTupleOfOne() {
        Tuple1<Integer> tuple = javaslangValueAndTupleKatas.createATupleFromOneElement(INTEGER);

        assertThat(tuple._1).isEqualTo(INTEGER);
    }

    @Test
    public void getTupleOfTwo() {
        Tuple2<Integer, String> tuple = javaslangValueAndTupleKatas.createATupleFromTwoElements(INTEGER, STRING);

        assertThat(tuple._1).isEqualTo(INTEGER);
        assertThat(tuple._2).isEqualTo(STRING);
    }

    @Test
    public void getTupleOfThree() {
        Tuple3<Integer, String, LocalDate> tuple = javaslangValueAndTupleKatas.createATupleFromThreeElements(INTEGER, STRING, LOCAL_DATE);

        assertThat(tuple._1).isEqualTo(INTEGER);
        assertThat(tuple._2).isEqualTo(STRING);
        assertThat(tuple._3).isEqualTo(LOCAL_DATE);
    }

    @Test
    public void getTupleOfEight() {
        Tuple8<Integer, String, LocalDate, Boolean, Throwable, Random, Field, Enum<?>> tuple = javaslangValueAndTupleKatas
            .createATupleFromEightElements(INTEGER, STRING, LOCAL_DATE, BOOL, throwable, RANDOM, field,
                ReasonsWhyIThinkYoureCrazy.YOU_HAVE_LIKE_A_MILLION_CATS);

        assertThat(tuple._1).isEqualTo(INTEGER);
        assertThat(tuple._2).isEqualTo(STRING);
        assertThat(tuple._3).isEqualTo(LOCAL_DATE);
        assertThat(tuple._4).isEqualTo(BOOL);
        assertThat(tuple._5).isEqualTo(throwable);
        assertThat(tuple._6).isEqualTo(RANDOM);
        assertThat(tuple._7).isEqualTo(field);
        assertThat(tuple._8).isEqualTo(ReasonsWhyIThinkYoureCrazy.YOU_HAVE_LIKE_A_MILLION_CATS);
    }

    private class AreYouCrazyError extends Error {

        public AreYouCrazyError(String message) {
            super(message);
        }

        public AreYouCrazyError(String message, Throwable cause) {
            super(message, cause);
        }
    }

    private enum ReasonsWhyIThinkYoureCrazy {
        YOU_HAVE_LIKE_A_MILLION_CATS
    }
}