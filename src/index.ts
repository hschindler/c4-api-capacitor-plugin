import { registerPlugin } from '@capacitor/core';

import type { C4ApiCapacitorPluginPlugin } from './definitions';

const C4ApiCapacitorPlugin = registerPlugin<C4ApiCapacitorPluginPlugin>('C4ApiCapacitorPlugin', {
  web: () => import('./web').then(m => new m.C4ApiCapacitorPluginWeb()),
});

export * from './definitions';
export { C4ApiCapacitorPlugin };
