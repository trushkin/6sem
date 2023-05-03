package by.bsuir.coursework.user;

import by.bsuir.coursework.car.details.BrandRepository;
import by.bsuir.coursework.car.details.EngineRepository;
import by.bsuir.coursework.car.details.ModelRepository;
import by.bsuir.coursework.car.details.TransmissionRepository;
import by.bsuir.coursework.car.details.TrunkRepository;
import by.bsuir.coursework.car.details.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public User toUserEntity(UserDto userDto){
        return User.builder()
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .patronymic(userDto.getPatronymic())
                .phoneNum(userDto.getPhoneNum())
                .email(userDto.getEmail())
                .role(userDto.getRole())
                .password(userDto.getPassword())
                .build();
    }
}
