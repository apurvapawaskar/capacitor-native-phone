import { registerPlugin } from '@capacitor/core';

import type { NativePhonePlugin } from './definitions';

const NativePhone = registerPlugin<NativePhonePlugin>('NativePhone', {
  web: () => import('./web').then(m => new m.NativePhoneWeb()),
});

export * from './definitions';
export { NativePhone };
