package com.senacor.blalasaadri.javaslang.presentation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.senacor.blalasaadri.javaslang.presentation.JavaslangFunctionKatas.Operation;

import javaslang.Function1;
import javaslang.Function3;
import javaslang.control.Either;
import javaslang.control.Option;

/**
 * @author Alasdair Collinson, Senacor Technologies AG
 */
public class JavaslangFunctionKatasTest {

    private JavaslangFunctionKatas javaslangFunctionKatas;

    @Before
    public void setup() {
        javaslangFunctionKatas = new JavaslangFunctionKatas();
    }

    @Test
    public void stringIsRepeatedNTimes() {
        assertThat(javaslangFunctionKatas.repeat().apply(5, "Hello, World "))
            .isEqualTo("Hello, World " + "Hello, World " + "Hello, World " + "Hello, World " + "Hello, World ");
    }

    @Test
    public void stringIsRepeatedFiveTimes() {
        assertThat(javaslangFunctionKatas.repeatFiveTimes().apply("Hello, World "))
            .isEqualTo("Hello, World " + "Hello, World " + "Hello, World " + "Hello, World " + "Hello, World ");
    }

    @Test
    public void concatWillConcatinateString() {
        assertThat(javaslangFunctionKatas.concat().apply("Hello, World")).isEqualTo("Hello, World");
    }

    @Test
    public void concatAndRepeatFiveTimesWillConcatenatedAndThenRepeatAStringFiveTimes() {
        assertThat(javaslangFunctionKatas.concatAndRepeatFiveTimes().apply("Hello,", "World "))
            .isEqualTo("Hello, World " + "Hello, World " + "Hello, World " + "Hello, World " + "Hello, World ");
    }

    @Test
    public void curryingAFunctionReturnsAStringOfFunction1s() {
        Function3<Integer, Integer, Operation, Integer> func = (a, b, o) -> {
            switch(o) {
                case ADD: return a + b;
                case SUBTRACT: return a - b;
                case MULTIPLY: return a * b;
                case DIVIDE: return a / b;
                default: throw new IllegalArgumentException(String.format("Operation '%s' is unknown", o));
            }
        };

        Function1<Integer, Function1<Operation, Integer>> result = javaslangFunctionKatas.alwaysApplyWithFirstValue1(func);
        Function1<Operation, Integer> withTwo = result.apply(2);

        assertThat(withTwo.apply(Operation.ADD)).isEqualTo(3);
        assertThat(withTwo.apply(Operation.SUBTRACT)).isEqualTo(-1);
        assertThat(withTwo.apply(Operation.MULTIPLY)).isEqualTo(2);
        assertThat(withTwo.apply(Operation.DIVIDE)).isEqualTo(0);
    }

    @Test
    public void halvingAnEvenNumberResultsInOptionOfHalf() {
        assertThat(javaslangFunctionKatas.halveIfPossible().apply(4).get()).isEqualTo(2);
    }

    @Test
    public void halvingAnOddNumberResultsInNone() {
        assertThat(javaslangFunctionKatas.halveIfPossible().apply(5)).isEqualTo(Option.none());
    }

    @Test
    public void ifAnExceptionIsThrownItCanBeCaughtAndReturned() {
        assertThat(javaslangFunctionKatas.exceptionsCanBeExtracted(() -> {
            throw new IllegalStateException("Something is wrong");
        })).isEqualTo(Either.left(new IllegalStateException("Something is wrong")));
    }

    @Test
    public void ifNoExceptionIsThrownTheResultIsReturned() {
        assertThat(javaslangFunctionKatas.exceptionsCanBeExtracted(() -> 42)).isEqualTo(Either.right(42));
    }

    @Test
    public void memoization() {
        Function1<Integer, Integer> random = (i) -> new Random().nextInt(i);

        Function1<Integer, Integer> memoizedFunction = javaslangFunctionKatas.rememberPriorResults(random);

        assertThat(memoizedFunction.apply(10)).isEqualTo(memoizedFunction.apply(10));
    }
}