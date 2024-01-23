package com.elasticsearch.elasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "persons")
public class Person {
    @Id
    private  String id;

    @Field(type = FieldType.Text, name = "name")
    private  String name;

    @Field(type = FieldType.Text, name = "address")
    private  String address;

    @Field(type = FieldType.Text, name = "age")
    private  Long age;

    @Field(type = FieldType.Text, name = "phone")
    private  String phone;
}
