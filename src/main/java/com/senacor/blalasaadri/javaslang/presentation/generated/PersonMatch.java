package com.senacor.blalasaadri.javaslang.presentation.generated;

import javaslang.Tuple;
import javaslang.Tuple1;
import javaslang.match.annotation.Patterns;
import javaslang.match.annotation.Unapply;

/**
 * @author Alasdair Collinson, Senacor Technologies AG
 */
@Patterns
public class PersonMatch {

    @Unapply
    public static Tuple1<Integer> age(AbstractPerson p) {
        return Tuple.of(p.age());
    }

    @Unapply
    public static Tuple1<String> firstName(AbstractPerson p) {
        return Tuple.of(p.firstName());
    }

    @Unapply
    public static Tuple1<String> lastName(AbstractPerson p) {
        return Tuple.of(p.lastName());
    }
}
