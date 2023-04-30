package by.bsuir.coursework.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserDto {
    private Integer id;
    private String name;
    private String surname;
    private String patronymic;
    private String phoneNum;
    private String email;
    private UserRole role;
    private Integer age;
    private Integer driving_exp;
    private String address;
    private String passport;
}
