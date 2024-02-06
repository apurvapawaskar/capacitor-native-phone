export interface NativePhonePlugin {
    makeACall(options: PhoneOptions): Promise<void>;
    checkPermission(): Promise<PermissionStatus>;
    requestPermission(): Promise<PermissionStatus>;
}

export interface PhoneOptions {
    phone_number: string;
}

export interface PermissionStatus {
    phone: PermissionState;
}