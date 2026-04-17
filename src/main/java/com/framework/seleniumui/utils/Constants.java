package com.framework.seleniumui.utils;

public class Constants {

    // URLs
    public static final String LOGIN_URL = "https://demoqa.com/login";
    public static final String ELEMENTS_URL = "https://demoqa.com/elements";
    public static final String FORMS_URL = "https://demoqa.com/forms";
    public static final String ALERTS_URL = "https://demoqa.com/alertsWindows";
    public static final String WIDGETS_URL = "https://demoqa.com/widgets";

    // Timeouts
    public static final int EXPLICIT_WAIT = 15;
    public static final int IMPLICIT_WAIT = 5;
    public static final int PAGE_LOAD_TIMEOUT = 30;

    // Test Data
    public static final String VALID_USERNAME = "vcalegari1";
    public static final String VALID_PASSWORD = "Ufpr20127552!";
    public static final String INVALID_USERNAME = "wronguser";
    public static final String INVALID_PASSWORD = "wrongpassword";

    // Messages
    public static final String INVALID_LOGIN_MESSAGE = "Invalid username or password!";

    // Retry
    public static final int RETRY_COUNT = 2;

    // Test Groups
    public static final String SMOKE = "smoke";
    public static final String REGRESSION = "regression";
    public static final String E2E = "e2e";
}