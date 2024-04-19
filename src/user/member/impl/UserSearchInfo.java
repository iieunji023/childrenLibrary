package user.member.impl;

import user.member.UserDto;
import user.session.UserSession;
import utils.PrintInfoCollection;

import java.util.Scanner;

public class UserSearchInfo implements IUserMember{
    @Override
    public void execute(Scanner scanner) {
        UserDto loginedUserDto = UserSession.getInstance().getUserDto();
        PrintInfoCollection.printUserInfo(loginedUserDto);

    }

}
