package by.pvt.fitnesclub.mapper;

import by.pvt.fitnesclub.dto.ActivitesReq;
import by.pvt.fitnesclub.dto.ActivitesRes;
import by.pvt.fitnesclub.dto.UserRequest;
import by.pvt.fitnesclub.dto.UserResponse;
import by.pvt.fitnesclub.entity.Activites;
import by.pvt.fitnesclub.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActivitesMapper {
    ActivitesRes userToUserResponse(Activites activites);

    Activites toEntity(ActivitesReq activitesReq);
}
