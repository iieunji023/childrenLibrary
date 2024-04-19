package admin.member.services.impl;

import admin.container.AdminContainer;
import user.member.UserDto;

import java.util.List;

public class SearchAllUserConfirm implements ISearchAllUserConfirm {
    @Override
    public void execute() {
        List<UserDto> userDtos = AdminContainer.getInstance().getAdminDao().selectAllUserByAdmin();

        if (userDtos != null) {
            for (UserDto userDto : userDtos) {
                System.out.printf("""
                                ──────────────────────────────────────────
                                <%s님의 정보>
                                NO: %d
                                ID: %s
                                NAME: %s
                                PHONE: %s
                                ADDRESS: %s
                                CREATED_AT: %s
                                ──────────────────────────────────────────
                                """, userDto.getName(),
                                     userDto.getNo(),
                                     userDto.getId(),
                                     userDto.getName(),
                                     userDto.getPhone(),
                                     userDto.getAddress(),
                                     userDto.getCreated_at());

            }
        } else {
            System.out.println("조회할 데이터가 없습니다.");

        }
    }
}