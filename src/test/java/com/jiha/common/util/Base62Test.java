package com.jiha.common.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class Base62Test {

    @Test
    public void changeUrl(){

        long id = 1;

        String changeKey = Base62.encode(id);
        System.out.println(changeKey);

        assertEquals(id, Base62.decode(changeKey));
    }


}