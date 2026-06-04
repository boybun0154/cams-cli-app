package cams.domain;

public enum AccountTier {
    PLATINUM("Platinum"),
    GOLD("Gold"),
    SILVER("Silver");

    private final String displayName;

    AccountTier(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static AccountTier fromBalance(double balance) {
        if (balance >= 100000.00) {
            return PLATINUM;
        } else if (balance >= 50000.00) {
            return GOLD;
        } else {
            return SILVER;
        }
    }
}
