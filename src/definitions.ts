export interface C4ApiCapacitorPluginPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
