package com.hackergym.samples.array.questions;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MaximumSubarrayTest {

    MaximumSubarray finder = new MaximumSubarray();

    @Test
    public void testFindMaximumSubarrayEnumeration() throws Exception {

        //Arrange
        int[] array = {1, -2, 4, -1, -2, 5, -3};

        //Act
        MaximumSubarray.SubarraySum result = finder.findMaximumSubarrayEnumeration(array);

        //Assert
        assertThat(result.sum, is(6));
        assertThat(result.startIndex, is(2));
        assertThat(result.endIndex, is(5));
    }

    @Test
    public void testFindMaximumSubarrayEnumerationAllNegativeButOne() throws Exception {

        int[] array = {-1, -2, -3, 1, -2, -5, -3};

        //Act
        MaximumSubarray.SubarraySum result = finder.findMaximumSubarrayEnumeration(array);

        //Assert
        assertThat(result.sum, is(1));
        assertThat(result.startIndex, is(3));
        assertThat(result.endIndex, is(3));
    }

    @Test
    public void testFindMaximumSubarrayEnumerationEmptyArrayResult() throws Exception {

        int[] array = {-1, -2, -3, -1, -2, -5, -3};

        //Act
        MaximumSubarray.SubarraySum result = finder.findMaximumSubarrayEnumeration(array);

        //Assert
        assertThat(result.sum, is(0));
    }

    @Test
    public void testFindMaximumSubarrayLinear() throws Exception {

        //Arrange
        int[] array = {1, -2, 4, -1, -2, 5, -3};

        //Act
        MaximumSubarray.SubarraySum result = finder.findMaximumSubarrayLinear(array);

        //Assert
        assertThat(result.sum, is(6));
        assertThat(result.startIndex, is(2));
        assertThat(result.endIndex, is(5));

    }

    @Test
    public void testFindMaximumSubarrayLinearEmptyArrayResult() throws Exception {

        int[] array = {-1, -2, -3, -1, -2, -5, -3};

        //Act
        MaximumSubarray.SubarraySum result = finder.findMaximumSubarrayLinear(array);

        //Assert
        assertThat(result.sum, is(0));
        assertThat(result.endIndex, is(-1));
    }

    @Test
    public void testFindMaximumSubarrayLinearAllNegativeButOne() throws Exception {

        int[] array = {-1, -2, -3, 1, -2, -5, -3};

        //Act
        MaximumSubarray.SubarraySum result = finder.findMaximumSubarrayLinear(array);

        //Assert
        assertThat(result.sum, is(1));
        assertThat(result.startIndex, is(3));
        assertThat(result.endIndex, is(3));

    }
}