export interface NativePhonePlugin {
    makeACall(options: PhoneOptions): Promise<void>;
}

export interface PhoneOptions {
    phone_number: string;
    country_code?: string
}

export interface PermissionStatus {
    phone: PermissionState;
}