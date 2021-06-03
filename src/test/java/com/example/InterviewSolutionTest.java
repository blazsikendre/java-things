package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class InterviewSolutionTest {

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("aaaaabbbcccaaaaaa", 11),
                Arguments.of("aaabbbccaabaaaaac", 11),
                Arguments.of("aaabbbbbccddeeffedd", 3),
                Arguments.of("aaabbbccccddd", 6),
                Arguments.of("abbbcccdddeee", 1),
                Arguments.of("aaabbbcccddd", 0),
                Arguments.of("abcdef", 0),
                Arguments.of("aa", 0),
                Arguments.of("", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void findIndex(String input, int expectedIndex) {
        var interviewSolution = new InterviewSolution();
        assertEquals(expectedIndex, interviewSolution.getStartIndexOfLongestPart(input));
    }
}