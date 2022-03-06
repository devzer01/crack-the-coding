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
        assert IsUnique.getUrlfied("foo bar      ".toCharArray(), 7).equals("foo%20bar    ");
    }

    @Test
    public void testIsPalindrome() {
        assert IsUnique.isPalindrome("foooof");
        assert IsUnique.isPalindrome("foogoof");
        assert !IsUnique.isPalindrome("foolof");
    }
}
