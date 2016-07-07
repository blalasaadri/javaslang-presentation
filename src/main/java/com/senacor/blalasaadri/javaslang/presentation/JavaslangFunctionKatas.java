package com.senacor.blalasaadri.javaslang.presentation;

import javaslang.Function0;
import javaslang.Function1;
import javaslang.Function2;
import javaslang.Function3;
import javaslang.collection.Stream;
import javaslang.control.Either;
import javaslang.control.Option;
import javaslang.control.Try;
import javaslang.control.Try.CheckedSupplier;

/**
 * @author Alasdair Collinson, Senacor Technologies AG
 */
public class JavaslangFunctionKatas {

    /**
     * Create a function that repeats a given String as often as requested.
     *
     * @return the given String n times
     */
    public Function2<Integer, String, String> repeat() {
        return (i, s) -> Stream.range(0, i).map(x -> s).mkString();
    }

    /**
     * Create a function that repeats a given String five times.
     * Hint: Use partial application of {@link #repeat()}
     *
     * @return the given String 5 times
     */
    public Function1<String, String> repeatFiveTimes() {
        return repeat().apply(5);
    }

    /**
     * Concatenates two Strings.
     * Hint: Method references can be used.
     *
     * @return the combination of two strings
     */
    public Function2<String, String, String> concat() {
        return String::concat;
    }

    /**
     * First concatinate two strings and then repeat them 5 times.
     * Hint: Methods can be stringed together.
     *
     * @return The given Strings concatinated and repeated 5 times
     */
    public Function2<String, String, String> concatAndRepeatFiveTimes() {
        return concat().andThen(repeatFiveTimes());
    }

    /**
     * We may sometimes want to translate higher dimensional functions into lower dimensional functions. In this case, we are taking a {@link
     * Function3} and want a {@link Function1} which will return a function for the next step each time it's called instead.
     * Hint: Use currying.
     *
     * @param func the higher dimension function
     * @return a {@link Function1} which will, when called with an integer, return a {@link Function1} which only expects an {@link Operation} to
     * complete.
     */
    public Function1<Integer, Function1<Operation, Integer>> alwaysApplyWithFirstValue1(Function3<Integer, Integer, Operation, Integer> func) {
        return func.curried().apply(1);
    }

    /**
     * The method {@link LegacyServiceCall#halve(int)} may throw an exception under unknown circumstances. We want to replace that exception with
     * {@link Option#none()}, as we don't care about the reasons but only about the result.
     * Hint: {@link Function1} has some static methods.
     *
     * @return a function which will return an Option rather than just the original result
     */
    public Function1<Integer, Option<Integer>> halveIfPossible() {
        return Function1.lift(LegacyServiceCall::halve);
    }

    /**
     * When the given function is called, it may throw an exception. If it does so, we want to return {@code Either.left(exception)}. Otherwise we
     * want to return {@code Either.right(result)}.
     * Hint: Try {@link javaslang.control.Try#of(CheckedSupplier)}
     *
     * @param exceptionThrowingFunction a method which may throw an exception when called
     */
    public Either<Throwable, Integer> exceptionsCanBeExtracted(Function0<Integer> exceptionThrowingFunction) {
        Try<Integer> triedResult = Try.of(exceptionThrowingFunction::apply);
        if (triedResult.isFailure()) {
            return Either.left(triedResult.getCause());
        }
        return Either.right(triedResult.get());
    }

    /**
     * Some methods can be very expensive to call or return different results when called at a different time. These functions are not pure functions
     * in the sense of functional programming.
     * If we want a function to remember the result it gave when last called with the same input, we can tell it to remember.
     * Hint: Memoization is the key
     *
     * @param functionAffectedByUnknownFactors a function which is not pure and may return varying results
     * @return a function which will always return the result it first did when called with the same input
     */
    public Function1<Integer, Integer> rememberPriorResults(Function1<Integer, Integer> functionAffectedByUnknownFactors) {
        return functionAffectedByUnknownFactors.memoized();
    }

    public enum Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }
}
