package de.fhdw.std;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static de.fhdw.std.assertions.BankAccountAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CheckingAccountTest {

    @Test
    void depositPositive() {
        CheckingAccount account = new CheckingAccount("1", 0, 500, 5);

        account.deposit(100);

        assertThat(account).hasBalance(100);
    }

    @Test
    void depositNegative() {
        CheckingAccount account = new CheckingAccount("1", 0, 500, 5);

        assertThatThrownBy(() -> account.deposit(-100))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideValuesForWithdraw")
    void ParamwithdrawAvailableAmount(String id, double balance, double limit, double fee, double amount, double expected) {
        CheckingAccount account = new CheckingAccount(id, balance, limit, fee);
        account.withdraw(amount);
        assertThat(account).hasBalance(expected);
    }

    private static Stream<Arguments> provideValuesForWithdraw() {
        return Stream.of(
            Arguments.of("1", 1000, 500, 5, 200, 800),
            Arguments.of("2", 1000, 500, 5, 1200, -205),
            Arguments.of("3", 0, 500, 5, 100, -105)
        );
    }

    @Test
    void withdrawAvailableAmount() {
        CheckingAccount account = new CheckingAccount("1", 1000, 500, 5);

        account.withdraw(200);

        assertThat(account).hasBalance(800);
    }

    @Test
    void withdrawWithinLimit() {
        CheckingAccount account = new CheckingAccount("1", 1000, 500, 5);

        account.withdraw(1200);

        assertThat(account).hasBalance(-205);
    }

    @Test
    void withdrawAboveLimit() {
        CheckingAccount account = new CheckingAccount("1", 1000, 500, 5);

        assertThatThrownBy(() -> account.withdraw(1700))
                .isInstanceOf(InsufficientFundsException.class);
    }

    @Test
    void withdrawNegativeAmount() {
        CheckingAccount account = new CheckingAccount("1", 0, 500, 5);

        assertThatThrownBy(() -> account.withdraw(-100))
                .isInstanceOf(IllegalArgumentException.class);
    }

}