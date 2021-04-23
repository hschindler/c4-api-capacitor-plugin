import { registerPlugin } from '@capacitor/core';
const C4ApiCapacitor = registerPlugin('C4ApiCapacitorPlugin', {
    web: () => import('./web').then(m => new m.C4ApiCapacitorPluginWeb()),
});
export * from './definitions';
export { C4ApiCapacitor };
//# sourceMappingURL=index.js.map