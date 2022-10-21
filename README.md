# c4-api-capacitor-plugin

Plugin for C4 Devices to use Barcode and UHF RFID

## Install

```bash
npm install c4-api-capacitor-plugin
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`getFirmware()`](#getfirmware)
* [`startInventory(...)`](#startinventory)
* [`stopInventory()`](#stopinventory)
* [`setOutputPower(...)`](#setoutputpower)
* [`scanBarcode()`](#scanbarcode)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### getFirmware()

```typescript
getFirmware() => Promise<{ firmware: number[]; }>
```

Gets RFID UHF reader firmware.

**Returns:** <code>Promise&lt;{ firmware: number[]; }&gt;</code>

**Since:** 1.0.0

--------------------


### startInventory(...)

```typescript
startInventory(options: { value: string; }) => Promise<{ uhfData: string[]; }>
```

Starts RFID UHF inventory.

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ uhfData: string[]; }&gt;</code>

**Since:** 1.0.0

--------------------


### stopInventory()

```typescript
stopInventory() => Promise<boolean>
```

Stops RFID UHF inventory.

**Returns:** <code>Promise&lt;boolean&gt;</code>

**Since:** 1.0.0

--------------------


### setOutputPower(...)

```typescript
setOutputPower(options: { value: number; }) => Promise<number>
```

Sets RFID UHF output power.

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: number; }</code> |

**Returns:** <code>Promise&lt;number&gt;</code>

**Since:** 1.0.0

--------------------


### scanBarcode()

```typescript
scanBarcode() => Promise<{ barcodeData: string; }>
```

Starts scanning barcode with 1D Scanner.

**Returns:** <code>Promise&lt;{ barcodeData: string; }&gt;</code>

**Since:** 1.0.0

--------------------

</docgen-api>
