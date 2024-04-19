package user.book.services.impl;

import book.BookController;
import book.RentalDto;
import book.container.BookContainer;
import config.BookConfig;
import user.config.BookUserConfig;
import user.container.UserContainer;
import user.session.UserSession;
import utils.BookDto;
import utils.PrintInfoCollection;

import java.security.cert.Extension;
import java.util.List;
import java.util.Scanner;

public class UserSearchRentalList implements IUserSearchRentalList{
    
    // 대여 리스트 조회
    @Override
    public void execute() {
        int user_no = UserSession.getInstance().getUserDto().getNo();

        List<RentalDto> rentalDtoList = UserContainer.getInstance().getUserBookDao().selectRentalList(user_no);
        PrintInfoCollection.printUserRentalList(rentalDtoList);

        if(!rentalDtoList.isEmpty()) {
            boolean run = true;
            Scanner scanner = new Scanner(System.in);

            while (run) {
                System.out.println("┌─────────────────────────┐");
                System.out.println("  1) 연장 2) 반납 99) 종료");
                System.out.println("└─────────────────────────┘");

                switch (scanner.nextInt()) {
                    case BookUserConfig.EXTENSION_DUE:
                        scanner.nextLine();
                        System.out.println("연장할 번호를 입력해주세요.");  // 대여테이블 NO
                        int no = scanner.nextInt();
                        scanner.nextLine();
                        
                        // EXTENSION 가능 여부 확인
                        boolean enable_extension = UserContainer.getInstance().getUserBookDao().selectExtensionYn(no);
                        
                        if (enable_extension) {             // ExtensionYn = 'Y'일때
                            int result = UserContainer.getInstance().getUserBookDao().updateExtensionDue(no);
                            if(result > 0) {
                                System.out.println("대여기간이 연장되었습니다.");

                            } else {
                                System.out.println("연장에 실패하였습니다.");

                            }

                        } else {
                            System.out.println("연장횟수를 초과하여 연장하실 수 없습니다.");

                        }
                        break;

                    case BookUserConfig.RETURN_BOOK:
                        scanner.nextLine();
                        System.out.println("반납할 번호를 입력해주세요.");  // 대여테이블 NO
                        no = scanner.nextInt();
                        UserContainer.getInstance().getUserBookDao().updateFinishedAt(no);

                        // 책 번호 출력
                        int book_no = UserContainer.getInstance().getUserBookDao().selectNoForReturn(no);
                        int result = UserContainer.getInstance().getUserBookDao().updateBookingYnByReturn(book_no);

                        if(result > 0) {
                            System.out.println("반납이 완료되었습니다.");

                        } else {
                            System.out.println("반납에 실패하였습니다.");

                        }

                        break;

                    case BookConfig.SYSTEM_SHUTDOWN:
                        System.out.println("종료되었습니다.");
                        run = false;
                        break;

                }
            }

        } else {
            System.out.println("대여한 책이 없습니다.");

        }
    }
}
