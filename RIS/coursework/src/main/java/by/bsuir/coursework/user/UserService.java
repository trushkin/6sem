package by.bsuir.coursework.user;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserMapper userMapper;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<UserDto> getAllUsersByRole(UserRole userRole) {
        return userRepository.findALLByRole(userRole).stream().map(userMapper::toUserDto).toList();
    }

    public List<UserDto> getUsersByKeyword(String keyword) {
        return userRepository.findByKeyword(keyword).stream().map(userMapper::toUserDto).toList();
    }
    public boolean changePassword(String oldPassword, String newPassword, String email){
        if (oldPassword.equals(newPassword)){
            return false;
        }
        User user = userRepository.findByEmail(email);
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
        return true;
    }

    public boolean addClient(UserDto userDto, HttpSession session) {
        userDto.setRole(UserRole.CLIENT);
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User userFromDB = userRepository.findByEmail(userDto.getEmail());

        if (userFromDB != null) {
            return false;
        }
        User user = userRepository.save(userMapper.toUserEntity(userDto));
        Client client = Client.builder()
                .address(userDto.getAddress())
                .age(userDto.getAge())
                .driving_exp(userDto.getDriving_exp())
                .passport(userDto.getPassport())
                .user(user)
                .build();
        clientRepository.save(client);
        session.setAttribute("user", userMapper.toUserDto(user));
        return true;
    }

    public boolean addClient(UserDto userDto) {
        userDto.setRole(UserRole.CLIENT);
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User userFromDB = userRepository.findByEmail(userDto.getEmail());

        if (userFromDB != null) {
            return false;
        }
        User user = userRepository.save(userMapper.toUserEntity(userDto));
        Client client = Client.builder()
                .address(userDto.getAddress())
                .age(userDto.getAge())
                .driving_exp(userDto.getDriving_exp())
                .passport(userDto.getPassport())
                .user(user)
                .build();
        clientRepository.save(client);
        return true;
    }

    public boolean login(String email, String password, HttpSession session) {
        if (userRepository.findByEmail(email) == null) {
            return false;
        }
        User user = userRepository.findByEmail(email);
        if (user.getPassword().equals(passwordEncoder.encode(password))) {
            return false;
        }
        session.setAttribute("user", userMapper.toUserDto(user));
        return true;
    }

    public void deleteUser(Integer userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
        }
    }

}
