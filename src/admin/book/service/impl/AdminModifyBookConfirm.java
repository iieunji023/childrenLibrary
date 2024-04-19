package admin.book.service.impl;

import utils.BookDto;
import admin.container.AdminContainer;

import java.util.List;

public class AdminModifyBookConfirm implements IAdminModifyBookConfirm{
    private BookDto bookDto;
    public AdminModifyBookConfirm(BookDto bookDto) {
        this.bookDto = bookDto;
    }

    @Override
    public void execute() {
        int no = bookDto.getNo();
        // null 값일떄, 기존값을 넣기 위해 db에서 select해옴
        List<BookDto> bookDtos = AdminContainer.getInstance().getAdminBookDao().selectBookInfoByNo(no);
        int category_no = bookDtos.get(0).getCategory_no();
        String title = bookDtos.get(0).getTitle();
        String author = bookDtos.get(0).getAuthor();
        String publisher = bookDtos.get(0).getPublisher();

        if(bookDto.getCategory_no() == 0) {
            bookDto.setCategory_no(category_no);

        }

        if(bookDto.getTitle().equals("")) {
            bookDto.setTitle(title);

        }

        if(bookDto.getAuthor().equals("")) {
            bookDto.setAuthor(author);

        }

        if(bookDto.getPublisher().equals("")) {
            bookDto.setPublisher(publisher);

        }

        int result = AdminContainer.getInstance().getAdminBookDao().updateBookInfo(bookDto);

        if(result > 0) {
            System.out.printf("수정이 완료되었습니다. \n");

        } else {
            System.out.printf("수정에 실패하였습니다. \n");

        }

    }
}
