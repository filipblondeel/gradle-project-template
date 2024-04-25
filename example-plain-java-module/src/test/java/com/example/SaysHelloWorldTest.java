package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Says hello")
class SaysHelloWorldTest {

    @Test
    void using_the_supplied_name() {
        String message = new HelloWorld().sayHelloTo("John");

        assertThat(message).isEqualTo("Hello John");
    }
}
