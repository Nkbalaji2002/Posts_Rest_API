package com.example.api.restdemo.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {

    private long id;

    @NotEmpty
    @Size(min = 2, message = "title should have at least 2 characters")
    private String title;

    @NotEmpty
    @Size(min = 4, message = "description should have at least 4 characters")
    private String description;

    @NotEmpty
    @Size(min = 4, message = "content should have at least 4 characters")
    private String content;

}
