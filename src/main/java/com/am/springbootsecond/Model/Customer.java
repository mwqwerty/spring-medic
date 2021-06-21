package com.am.springbootsecond.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customer")
public class Customer {
    @Id
    private String id;
    @NonNull
    private String name;
    @NonNull
    private String password;
    @NonNull
    @Indexed(unique=true)
    private String uname;
    @NonNull
    @Indexed(unique=true)
    private String email;
}
