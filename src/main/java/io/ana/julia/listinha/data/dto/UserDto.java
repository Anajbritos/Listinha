package io.ana.julia.listinha.data.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Boolean isActive;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public UserDto() {
    }

    public UserDto(
            Long id,
            String firstName,
            String lastName,
            String email,
            String password,
            Boolean isActive,
            LocalDateTime createAt,
            LocalDateTime updateAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }
}
