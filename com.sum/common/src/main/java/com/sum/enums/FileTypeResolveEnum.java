package com.sum.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author summerSmile
 * @date 2021/12/25
 * @apiNote
 */
@Getter
@AllArgsConstructor
public enum FileTypeResolveEnum {
    FILE_A_RESOLVE("A","A类型解析方式"),
    FILE_B_RESOLVE("B", "B类型解析方式"),
    FILE_DEFAULT_RESOLVE("O","默认类型解析方式");

    private final String key;

    private final String value;
}
