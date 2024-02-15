import { WebPlugin } from '@capacitor/core';

import type { NativePhonePlugin, PhoneOptions } from './definitions';

export class NativePhoneWeb extends WebPlugin implements NativePhonePlugin {
    async makeACall(options: PhoneOptions): Promise<void> {
        console.log('Options', options);
        return;
    }
}
