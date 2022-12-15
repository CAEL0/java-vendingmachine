package vendingmachine.constant;

public enum ExceptionConstants {
    INCORRECT_RANGE("입력은 Integer 범위의 정수여야 합니다."),
    NOT_NEGATIVE("입력은 음수가 아니어야 합니다."),
    NOT_MULTIPLE_OF_TEN("입력은 10의 배수여야 합니다."),
    INCORRECT_PRODUCT_LIST("상품명, 가격, 수량은 쉼표로, 개별 상품은 대괄호로 묶어 세미콜론으로 구분해야 합니다.");

    private final String message;

    ExceptionConstants(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
