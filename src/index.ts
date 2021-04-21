import { registerPlugin } from '@capacitor/core';

import type { C4ApiCapacitorPlugin } from './definitions';

const C4ApiCapacitor = registerPlugin<C4ApiCapacitorPlugin>('C4ApiCapacitorPlugin', {
  web: () => import('./web').then(m => new m.C4ApiCapacitorPluginWeb()),
});

export * from './definitions';
export { C4ApiCapacitor };
