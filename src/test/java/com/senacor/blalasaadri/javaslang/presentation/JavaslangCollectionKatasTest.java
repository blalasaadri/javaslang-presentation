package com.senacor.blalasaadri.javaslang.presentation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javaslang.collection.List;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

/**
 * @author Alasdair Collinson, Senacor Technologies AG
 */
@RunWith(JUnitParamsRunner.class)
public class JavaslangCollectionKatasTest {

    private JavaslangCollectionKatas javaslangCollectionKatas;

    @Before
    public void setup() {
        javaslangCollectionKatas = new JavaslangCollectionKatas();
    }

    @Test
    public void listWithFiveUniqueNumbers() {
        List<Integer> list = javaslangCollectionKatas.createListWithFiveDifferentNumbers();

        assertThat(list).hasSize(5);
        assertThat(list.distinct()).hasSize(5);

    }

    @Test
    public void createNewListWithChangedFirstElement() {
        List<Integer> originalList = List.of(0, 2, 3);

        List<Integer> changedList = javaslangCollectionKatas.createListWithDifferentFirstElement(originalList);

        assertThat(changedList).isNotSameAs(originalList);
        assertThat(changedList.drop(1)).isEqualTo(originalList.drop(1));
        assertThat(changedList.get(0)).isNotEqualTo(originalList.get(0));
    }

    @Test
    @Parameters(method = "separators")
    public void joinLongFruitsAndVegetables(String separator) {
        assertThat(javaslangCollectionKatas.joinStrings(separator, "Carrot", "Cucumber", "Banana"))
            .isEqualTo("Carrot" + separator + "Cucumber" + separator + "Banana");
    }

    @SuppressWarnings("unused")
    private List<String> separators() {
        return List.of(" & ", " + ", ", ");
    }
}