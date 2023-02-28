package com.ecom.app.constant;

public class Constant {

    public final static String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    public final static String DATE_FORMAT_DD_MM_YYYY = "dd-MM-yyyy";
    public final static String DATE_FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public final static String DATE_FORMAT_YYYY_MM_DD_T_HH_MM_SS_Z = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    public final static String SUCCESS = "Success";
    public final static String SUCCESSFULLY_CREATED = "Successfully created.";
    public final static String SUCCESSFULLY_UPDATED = "Successfully updated.";
    public final static String SUCCESSFULLY_DELETED = "Successfully deleted.";
    public final static String SUPER_ADMIN = "SUPER_ADMIN";
    public final static String ADMIN = "ADMIN";
    public final static String USER = "USER";
    public final static String VENDOR = "VENDOR";
    public final static String ETP_NUMBER = "ETP_NUMBER";
    public final static String ZONE_NUMBER = "ZONE_NUMBER";
    public final static String EMERGENCY_NUMBER = "EMERGENCY_NUMBER";
    public final static String LP_NUMBER = "LP_NUMBER";
    public final static String TRIP_NUMBER = "TRIP_NUMBER";
    public final static String GOOGLE_API_CONSUMPTION = "GOOGLE_API_CONSUMPTION";
    public final static String ADDRESS_URL = "ADDRESS_URL";
    public final static String ADDRESS_APP_KEY = "ADDRESS_APP_KEY";
    public final static String DELETE_GEOFENCE = "/api/geofences/";
    public final static String CREATE_GEOFENCE = "/api/geofences";
    public final static String SEND_COMMAND = "/api/commands/send";
    public final static String GET_GEOFENCE = "/api/geofences";
    public final static String UPDATE_DEVICE = "/api/devices/";
    public final static String REPORTS_SUMMARY = "/api/reports/summary";
    public final static String REPORTS_ROUTE = "/api/reports/route";
    public final static String REPORTS_EVENTS = "/api/reports/events";
    public final static String REPORTS_STOPS = "/api/reports/stops";
    public final static String POSITION = "/api/positions";
    public final static String REPORTS_TRIPS = "/api/reports/trips";
    public final static String CREATE_GROUP = "/api/groups";
    public final static String DELETE_GROUP = "/api/groups/";
    public final static String PERMISSION = "/api/permissions";
    public final static String DEFAULT_SPEED = "DEFAULT_SPEED";
    public final static String DEFAULT_STOPPAGE_TIME = "DEFAULT_STOPPAGE_TIME";
    public final static String RAPID_GPS_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    public final static String MESSAGE_URL = "MESSAGE_URL";
    public final static String MESSAGE_APP_KEY = "MESSAGE_APP_KEY";
    public final static String OVER_SPEED_SMS = "OVERSPEED_SMS";
    public final static String MESSAGE_ON = "MESSAGE_ON";
    public final static String UUID_UNIQUE = "UUID_UNIQUE";
    public final static String FUEL_FILL_EVENT = "deviceFuelRefill";
    public final static String FUEL_DROP_EVENT = "deviceFuelDrop";
    public final static String ALARM_EVENT = "alarm";
    public final static String WIRE_CUT = "powerCut";
    public final static String MESSAGE_OVER_SPEED = "OVER_SPEED";
    public final static String MESSAGE_ROUTE_DEVIATION = "ROUTE_DEVIATION";
    public final static String MESSAGE_UNAUTHORIZED_STOPPAGE = "UNAUTHORIZED_STOPPAGE";
    public final static String MESSAGE_TAMPERING = "TAMPERING";
    public final static String MESSAGE_ENTERED = "ENTERED";
    public final static String MESSAGE_EXIT = "EXIT";
    public final static String REMOVE_GPS_WASTOO = "v1/device_request/removeGpsCore";
    public final static Integer IST_OFFSET_IN_MINUTES = 330;
    public final static Integer IST_OFFSET_IN_MINUTES_PLUS = 340;
    public final static Double Knot_To_KmHr = 1.85200;
    public final static Double StopTimeCheck = 300000D;
    public final static Double minOverSpeedValue = 30D;
    public final static Double maxOverSpeedValue = Double.MAX_VALUE;
    public final static String MIN_POLLING_TIME_SECOND = "MIN_POLLING_TIME_SECOND";
    public final static String VEHICLE_IN_MAINTENANCE_PROCESS_CONSIDER = "VEHICLE_IN_MAINTENANCE_PROCESS_CONSIDER";
    public final static String FUEL_FILL = "FUEL_FILL";
    public final static String FUEL_DROP = "FUEL_DROP";
    public final static String FPL_DEPARTURE_BUFFER = "FPL_DEPARTURE_BUFFER";
    public final static String DPL_REACH_BUFFER = "DPL_REACH_BUFFER";
    public final static String BACK_FPL_REACH_BUFFER = "BACK_FPL_REACH_BUFFER";
    public final static Integer INITIAL_REMARK_LEVEL = 0;
    public final static String INITIAL_REMARK_LEVEL_USER = "VENDOR";
    public final static String FIX_PENALTY = "FIX_PENALTY";
    public final static String PUSH_ALERT_URL = "PUSH_ALERT_URL";
    public final static String GEOFENCE_CIRCLE_DISATNCE = "GEOFENCE_CIRCLE_DISATNCE";
    public final static String GEOFENCE_ADD_DISTANCE_PERCENTAGE = "GEOFENCE_ADD_DISTANCE_PERCENTAGE";
    public final static String MS_FPL_TRIP_INVALIDATE_TIME_IN_MIN = "MS_FPL_TRIP_INVALIDATE_TIME_IN_MIN";
    public final static String FAIL_LOGIN_LOCK_RELEASE_INMIN = "FAIL_LOGIN_LOCK_RELEASE_INMIN";
    public final static String MAX_LOGIN_ATTEMPT = "MAX_LOGIN_ATTEMPT";
    public final static String PASSWORD_FOR_ENCRYPTION = "ENCRYPTION_PASSWORD";
    public final static String ALGORITHM_FOR_ENCRYPTION = "AES";
    public final static String ENCRYPTION_PASSWORD = "77217A25432A462D4A614E635266556A";
    public static final String LAST_PROCESS_ALERTID = "LAST_PROCESS_ALERTID";
    public static final Long DJB_COMPANY_ID = 1L;
    public static final String DEVICE_UNLOCK_COMMAND = "(P43,12#aAM)";
    public static final String CUSTOM_COMMAND = "custom";
    public static final String CANCEL_ORDER = "CANCEL-ORDER";
    public static final String ORDER_STATUS = "ODER-STATUS";

}