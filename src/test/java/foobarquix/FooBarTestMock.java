package foobarquix;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
public class FooBarTestMock {

    FooBar foobar = new FooBar();

    @Before
    public void config() {
        Mockito.when(foobar.fooBarQix(Mockito.any())).thenReturn("BAR");
    }

    @Test
    void should_return_FOO_when_divide_by_3(int input)  {
        Assertions.assertEquals("FOO",foobar.fooBarQix(input));
    }

}
