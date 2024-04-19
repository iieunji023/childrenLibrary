package user.member.services.impl;

import user.container.UserContainer;
import user.member.UserDto;
import user.session.UserSession;

public class UserModifyConfirm implements IUserModifyConfirm{
    private UserDto userDto;

    public UserModifyConfirm(UserDto userDto) {
        this.userDto = userDto;
    }

    @Override
    public void execute() {
        // null 값은 기존의 값으로 대체
        String pw = userDto.getPw();
        String name = userDto.getName();
        String phone = userDto.getPhone();
        String address = userDto.getAddress();

        UserDto loginedUserDto = UserSession.getInstance().getUserDto();

        if(pw.equals("")){
            userDto.setPw(loginedUserDto.getPw());

        }
        if(name.equals("")) {
            userDto.setName(loginedUserDto.getName());

        }
        if(phone.equals("")) {
            userDto.setPhone(loginedUserDto.getPhone());

        }
        if(address.equals("")) {
            userDto.setAddress(loginedUserDto.getAddress());

        }

        // no값
        userDto.setNo(loginedUserDto.getNo());

        // 회원정보 update
        int result = UserContainer.getInstance().getUserDao().updateUser(userDto);

        if(result > 0) {
            System.out.println("회원 정보수정이 완료되었습니다.");

        } else {
            System.out.println("정보 수정에 실패하였습니다.");

        }
    }
}
