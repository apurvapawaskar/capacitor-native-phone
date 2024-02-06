import { WebPlugin } from '@capacitor/core';

import type { NativePhonePlugin, PermissionStatus, PhoneOptions } from './definitions';

export class NativePhoneWeb extends WebPlugin implements NativePhonePlugin {
    checkPermission(): Promise<PermissionStatus> {
        throw new Error('Method not implemented.');
    }
    requestPermission(): Promise<PermissionStatus> {
        throw new Error('Method not implemented.');
    }
    checkPermissions(): Promise<PermissionStatus> {
        throw new Error('Method not implemented.');
    }

    requestPermissions(): Promise<PermissionStatus> {
        throw new Error('Method not implemented.');
    }

    async makeACall(options: PhoneOptions): Promise<void> {
        console.log('ECHO', options);
        return;
    }
}
