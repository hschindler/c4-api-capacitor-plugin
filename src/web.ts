import { WebPlugin } from '@capacitor/core';

import type { C4ApiCapacitorPluginPlugin } from './definitions';

export class C4ApiCapacitorPluginWeb extends WebPlugin implements C4ApiCapacitorPluginPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
