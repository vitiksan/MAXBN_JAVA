package com.maxGroup.BankSystem.AccountFactory;

public class AccFactory {
    public static IAccountFactory createAccountFactory(String cardType) {
        if (cardType.equalsIgnoreCase("credit")) return new AccForCreditFactory();
        else if (cardType.equalsIgnoreCase("deposit")) return new AccForDepositFactory();
        else if (cardType.equalsIgnoreCase("payments")) return new AccForPaymentsFactory();
        else throw new RuntimeException(cardType + " is not defined.");
    }
}
