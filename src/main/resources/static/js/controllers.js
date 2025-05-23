function addToCart(bookid) {
    if(confirm("장바구니에 도서를 추가합니까?") == true) {
        document.addForm.action="/BookMarket/cart/book/" + bookid;
        document.addForm.submit();
    }
}