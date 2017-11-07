package lab2;

import lombok.Getter;

@Getter
public enum MaritalStatus {
    SINGLE(1,"самотній" ), MARRIED(2,"одружений"), DIVORCED(3,"розлучений"), WIDOW(4,"вдівець");

    private final int dbCode;
    private final String ukrDesc;

    MaritalStatus(int dbCode, String ukrDesc) {
        this.dbCode = dbCode;
        this.ukrDesc = ukrDesc;
    }

    public static MaritalStatus findByDbCode(int dbCode) {
        MaritalStatus[] statuses = values();
        for (MaritalStatus status : statuses) {
            if (status.dbCode == dbCode) {
                return status;
            }
        }
        throw new RuntimeException(dbCode + " not supported");
    }


    @Override
    public String toString() {
        return ukrDesc;
    }
}
