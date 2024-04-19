package utils;

import book.RentalDto;
import user.member.UserDto;

import java.util.List;

public class PrintInfoCollection {
    public static void printBookList(List<BookDto> bookDtos) {
        for(BookDto bookDto : bookDtos) {
            if (bookDto.getBooking_yn().equalsIgnoreCase("Y")) {
                System.out.printf("""
                                ────────────────────────────────────────────
                                NO: %d
                                CLASSIFY: %s
                                TITLE: %s
                                AUTHOR: %s
                                PUBLISHER: %s
                                BOOKING_YN: 대여불가
                                ────────────────────────────────────────────
                                """, bookDto.getNo(),
                        bookDto.getClassify(),
                        bookDto.getTitle(),
                        bookDto.getAuthor(),
                        bookDto.getPublisher());

            } else if (bookDto.getBooking_yn().equalsIgnoreCase("N")) {
                System.out.printf("""
                                ────────────────────────────────────────────
                                NO: %d
                                CLASSIFY: %s
                                TITLE: %s
                                AUTHOR: %s
                                PUBLISHER: %s
                                BOOKING_YN: 대여가능
                                ────────────────────────────────────────────
                                """, bookDto.getNo(),
                        bookDto.getClassify(),
                        bookDto.getTitle(),
                        bookDto.getAuthor(),
                        bookDto.getPublisher());

            }
        }
    }

    public static void printBookListIncludeCount(List<BookDto> bookDtos) {
        for (BookDto bookDto : bookDtos) {
            System.out.printf("""
                              ────────────────────────────────────────────
                              TITLE: %s
                              AUTHOR: %s
                              PUBLISHER: %s
                              ENABLE : %d
                              ────────────────────────────────────────────
                              """,
                    bookDto.getTitle(),
                    bookDto.getAuthor(),
                    bookDto.getPublisher(),
                    bookDto.getCount()
            );
        }

    }

    public static void printUserInfo(UserDto loginedUserDto) {
        System.out.printf("""
                          ────────────────────────────────────────────
                          <%s님의 정보>
                          ID: %s
                          NAME: %s
                          PHONE: %s
                          ADDRESS: %s
                          ────────────────────────────────────────────
                          """,  loginedUserDto.getName(),
                                loginedUserDto.getId(),
                                loginedUserDto.getName(),
                                loginedUserDto.getPhone(),
                                loginedUserDto.getAddress());

    }

    public static void printUserRentalList(List<RentalDto> rentalDtoList) {
        for (RentalDto rentalDto : rentalDtoList) {
            if(rentalDto.getExtension_yn().equalsIgnoreCase("Y")) {
                System.out.printf("""
                              ────────────────────────────────────────────
                              NO: %d
                              NAME: %s
                              TITLE: %s
                              RENTAL DATE: %s
                              FINISHED DATE: %s
                              EXTENSION : 연장가능
                              ────────────────────────────────────────────
                              """,rentalDto.getNo(),
                        rentalDto.getName(),
                        rentalDto.getTitle(),
                        rentalDto.getCreated_at(),
                        rentalDto.getFinished_date()
                );
            } else if(rentalDto.getExtension_yn().equalsIgnoreCase("N")){
                System.out.printf("""
                              ────────────────────────────────────────────
                              NO: %d
                              NAME: %s
                              TITLE: %s
                              RENTAL DATE: %s
                              FINISHED DATE: %s
                              EXTENSION : 연장불가
                              ────────────────────────────────────────────
                              """,rentalDto.getNo(),
                        rentalDto.getName(),
                        rentalDto.getTitle(),
                        rentalDto.getCreated_at(),
                        rentalDto.getFinished_date()
                );
            }

        }

    }

}

