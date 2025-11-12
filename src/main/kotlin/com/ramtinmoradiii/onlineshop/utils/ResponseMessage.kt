package com.ramtinmoradiii.onlineshop.utils

object ResponseMessage {
    const val OK = "عملیات با موفقیت انجام شد."
    const val NOT_FOUND = "موردی یافت نشد."
    const val HAS_PROBLEM = "مشکلی پیش آمده است."
    const val NOT_MATCH_PASSWORD = "رمز عبور یکسان نیست."
    const val ENTER_USERNAME_AND_PASSWORD = "نام کاربری و رمز عبور را کامل وارد کنید."
    const val INTERNAL_SERVER_ERROR_PREFIX = "خطای داخلی سرور: "
    const val MALFORMED_JSON = "بدنه درخواست (JSON) ارسالی نامعتبر یا ناقص است."
    const val DATA_INTEGRITY_VIOLATION =
        "عملیات با محدودیت دیتابیس مواجه شد (مثلاً ورودی تکراری). لطفاً ورودی خود را بررسی کنید."
    const val VALIDATION_FAILED_PREFIX = "خطای اعتبارسنجی: "
    const val CONSTRAINT_VIOLATION_PREFIX = "خطای محدودیت: "
    const val TYPE_MISMATCH_TEMPLATE = "مقدار '%s' برای پارامتر '%s' نامعتبر است. نوع مورد انتظار: '%s'"
}