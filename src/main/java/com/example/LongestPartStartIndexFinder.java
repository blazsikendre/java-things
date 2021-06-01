package com.example;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class LongestPartStartIndexFinder implements Collector<Integer, Integer, Integer> {

    public static LongestPartStartIndexFinder findIndexOfLongestPart() {
        return new LongestPartStartIndexFinder();
    }

    private Integer lastCharacter;
    private Integer characterCounter;
    private Integer maxLength;
    private String maxCharacter;
    private String originalString;

    private LongestPartStartIndexFinder() {
        this.characterCounter = 1;
        this.maxLength = 0;
        this.maxCharacter = "";
        this.lastCharacter = 0;
        this.originalString = "";
    }

    @Override
    public Supplier<Integer> supplier() {
        return () -> 0;
    }

    @Override
    public BiConsumer<Integer, Integer> accumulator() {
        return (map, character) -> {
            if (this.lastCharacter.equals(character)) {
                this.characterCounter++;
            } else {
                this.characterCounter = 1;
            }

            if (this.maxLength < this.characterCounter) {
                this.maxLength = this.characterCounter;
                this.maxCharacter = Character.toString(this.lastCharacter);
            }

            this.originalString = this.originalString.concat(Character.toString(character));
            this.lastCharacter = character;
        };
    }

    @Override
    public BinaryOperator<Integer> combiner() {
        return (left, right) -> 0;
    }

    @Override
    public Function<Integer, Integer> finisher() {
        return character -> this.maxLength.equals(1)
                ? 0
                : this.originalString.indexOf(this.maxCharacter.repeat(this.maxLength));
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
}
