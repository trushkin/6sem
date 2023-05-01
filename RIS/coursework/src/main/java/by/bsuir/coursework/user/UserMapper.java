package by.bsuir.coursework.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserMapper {
    public UserDto toUserDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .patronymic(user.getPatronymic())
                .phoneNum(user.getPhoneNum())
                .email(user.getEmail())
                .role(user.getRole())
                .age(user.getClient().getAge())
                .driving_exp(user.getClient().getDriving_exp())
                .address(user.getClient().getAddress())
                .passport(user.getClient().getPassport())
                .password(user.getPassword())
                .build();
    }
}
