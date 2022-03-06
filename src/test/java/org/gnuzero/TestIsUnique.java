package org.gnuzero;

import org.junit.jupiter.api.Test;

public class TestIsUnique {

    @Test
    public void testUnique() {
        assert IsUnique.isUniqueChars("fobar");
        assert !IsUnique.isUniqueChars("foobar");
    }

    @Test
    public void testUniqueUseArray() {
        assert IsUnique.isUniqueUseArray("fobar");
        assert !IsUnique.isUniqueUseArray("foobar");
    }

    @Test
    public void testIsPermutation() {
        assert IsUnique.isPermutation("foobar", "barfoo");
        assert !IsUnique.isPermutation("fooZbar", "barXfoo");
    }

    @Test
    public void testIsPermutationUseArray() {
        assert IsUnique.isPermutationUseArray("foobar", "barfoo");
        assert !IsUnique.isPermutationUseArray("fooZbar", "barXfoo");
    }

    @Test
    public void testGetUrlfied() {
        assert IsUnique.isPermutationUseArray("foobar", "barfoo");
        assert !IsUnique.isPermutationUseArray("fooZbar", "barXfoo");
    }
}
