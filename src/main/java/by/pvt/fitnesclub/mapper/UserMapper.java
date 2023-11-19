package by.pvt.fitnesclub.mapper;

import by.pvt.fitnesclub.dto.UserRequest;
import by.pvt.fitnesclub.dto.UserResponse;
import by.pvt.fitnesclub.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface UserMapper {
//@Mapping(target = "city",source ="address.city")
    UserResponse userToUserResponse(User user);

    User toEntity(UserRequest userRequest);
}
