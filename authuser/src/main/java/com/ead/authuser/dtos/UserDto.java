package com.ead.authuser.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    /*
     Json view é uma forma de estabelecer diferentes verificações em um mesmo modelo utilizando as interfaces internas e
      anotando nos atributos, dessa forma o controller só verificará os atributos com as anotações da interface
      definida no controller.
     */
    public interface UserView{ // para uso do JsonView
        public static interface RegistrationPost{}
        public static interface UserPut{}
        public static interface PasswordPut{}
        public static interface ImagePut{}
    }

    private UUID userid;

    @JsonView(UserView.RegistrationPost.class)
    private String username;

    @JsonView(UserView.RegistrationPost.class)
    private String email;

    @JsonView({UserView.RegistrationPost.class, UserView.PasswordPut.class})
    private String password;

    @JsonView(UserView.PasswordPut.class)
    private String oldPassword;

    @JsonView({UserView.UserPut.class, UserView.RegistrationPost.class})
    private String fullName;

    @JsonView({UserView.UserPut.class, UserView.RegistrationPost.class})
    private String phoneNumber;

    @JsonView({UserView.UserPut.class, UserView.RegistrationPost.class})
    private String cpf;

    @JsonView(UserView.ImagePut.class)
    private String imageUrl;

}
