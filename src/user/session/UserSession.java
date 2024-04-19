package user.session;

import book.RentalDto;
import user.member.UserDto;

public class UserSession {
    private static UserSession userSession;
    private UserDto userDto;
    private RentalDto rentalDto;

    private UserSession() {

    }

    public static UserSession getInstance() {
        if(userSession == null) {
            userSession = new UserSession();

        }
        return userSession;

    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public RentalDto getRentalDto() {
        return rentalDto;
    }

    public void setRentalDto(RentalDto rentalDto) {
        this.rentalDto = rentalDto;
    }
}
