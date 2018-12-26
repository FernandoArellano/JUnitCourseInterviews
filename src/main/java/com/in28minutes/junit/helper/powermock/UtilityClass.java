package com.in28minutes.junit.helper.powermock;

public class UtilityClass {
    public static int staticMethod(long value) {
        // Some complex logic is done here...
        throw new RuntimeException(
                "I dont want to be executed. I will anyway be mocked out.");
    }
}