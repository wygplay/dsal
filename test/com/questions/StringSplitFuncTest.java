package com.questions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringSplitFuncTest {

    @Test
    public void func() {
        // 编写 StringSplitFunc 类的 func 方法的测试用例
        // 4. 传入 "XY"，返回 2
        assertEquals(2, StringSplitFunc.func("XY"));
        // 5. 传入 "XXYY"，返回 4
        assertEquals(4, StringSplitFunc.func("XXYY"));
        assertEquals(24, StringSplitFunc.func("XXXYYYXYXY"));

    }
}