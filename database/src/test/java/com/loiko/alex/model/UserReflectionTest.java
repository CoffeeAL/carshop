package com.loiko.alex.model;

import com.loiko.alex.user.User;
import com.loiko.alex.user.UserInfo;
import org.junit.Test;

import javax.persistence.Column;
import javax.persistence.Table;
import java.lang.reflect.Field;

public class UserReflectionTest {

    @Test
    public void checkAnnotation() {
        Table annotation = User.class.getAnnotation(Table.class);
        System.out.println(annotation.name());
        System.out.println(annotation.schema());
        System.out.println("INSERT INTO " + annotation.schema() + "." + annotation.name() + " VALUES ()");
    }

    @Test
    public void checkColumnAnnotation() throws NoSuchFieldException {
        Field nameField = UserInfo.class.getDeclaredField("fullName");
        Column annotation = nameField.getAnnotation(Column.class);
        if (annotation == null) {
            System.out.println(nameField.getName());
        } else {
            System.out.println(annotation.name());
        }
    }
}