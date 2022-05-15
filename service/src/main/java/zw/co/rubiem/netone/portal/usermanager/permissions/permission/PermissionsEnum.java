package zw.co.rubiem.netone.portal.usermanager.permissions.permission;

import lombok.Getter;


@Getter
public enum PermissionsEnum {

    CREATE_GROUP(true, false),
    UPDATE_GROUP(true, false),
    DELETE_GROUP(true, false),

    UPDATE_PERMISSION(true, false),
    CREATE_PERMISSION(true, false),

    REVOKE_USER_PERMISSION(true, false),
    CREATE_USER_PERMISSION(true, false),

    CREATE_ADMIN_USER(true, false),
    UPDATE_ADMIN_USER(true, false),
    DELETE_ADMIN_USER(false, false),

    CREATE_USER(true, false),
    UPDATE_USER(false, false),
    DELETE_USER(false, false),

    CHANGE_USER_ACCOUNT_STATUS(true, false),

    CHANGE_SUB_USER_ACCOUNT_STATUS(true, false),
    UPDATE_SUB_USER_ACCOUNT(true, false),
    CREATE_SUB_USER_ACCOUNT(true, false),

    RESET_USER_PASSWORD(true, false),
    CHANGE_USER_GROUP(true, false),

    IS_SUPER_ADMIN(true, false);

    private final boolean isForAdminOnly;

    private final boolean isForCompanyAdmin;

    PermissionsEnum(boolean isForAdminOnly, boolean isForCompanyAdmin) {
        this.isForAdminOnly = isForAdminOnly;
        this.isForCompanyAdmin = isForCompanyAdmin;
    }
}
