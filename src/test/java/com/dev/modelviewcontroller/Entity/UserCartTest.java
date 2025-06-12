package com.dev.modelviewcontroller.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class UserCartTest {
    @Test
    public void getCPName() {
        UserCart u = new UserCart(123, "abc", "abc", 123, 123);
        String expected = "abc";
        String actual = u.getCPName();

        assertEquals(expected, actual);
    }
}
