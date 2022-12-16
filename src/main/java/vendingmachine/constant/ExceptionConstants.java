package vendingmachine.constant;

public enum ExceptionConstants {
    INCORRECT_RANGE("입력은 Integer 범위의 정수여야 합니다."),
    NOT_NEGATIVE("입력은 음수가 아니어야 합니다."),
    NOT_MULTIPLE_OF_TEN("입력은 10의 배수여야 합니다."),
    INCORRECT_PRODUCT_LIST("상품명, 가격, 수량은 쉼표로, 개별 상품은 대괄호로 묶어 세미콜론으로 구분해야 합니다."),
    INCORRECT_PRICE_RANGE(String.format("상품 가격은 %d원부터 시작해야 합니다.", VendingMachineConstants.LOWEST_PRICE)),
    DUPLICATED_PRODUCT_NAME("상품명은 중복되지 않아야 합니다."),
    NO_SUCH_PRODUCT("자판기에 존재하지 않는 상품명입니다."),
    SOLD_OUT("구매하려는 상품의 재고가 소진되었습니다."),
    NOT_ENOUGH_MONEY("구매하려는 상품의 금액이 남은 투입 금액보다 큽니다.");

    private final String message;

    ExceptionConstants(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
