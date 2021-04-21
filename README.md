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
* [`startInventory()`](#startinventory)
* [`stopInventory()`](#stopinventory)
* [`setOutputPower()`](#setoutputpower)
* [`scanBarcode()`](#scanbarcode)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => any
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>any</code>

--------------------


### getFirmware()

```typescript
getFirmware() => any
```

Gets RFID UHF reader firmware.

**Returns:** <code>any</code>

**Since:** 1.0.0

--------------------


### startInventory()

```typescript
startInventory() => any
```

Starts RFID UHF inventory.

**Returns:** <code>any</code>

**Since:** 1.0.0

--------------------


### stopInventory()

```typescript
stopInventory() => any
```

Stops RFID UHF inventory.

**Returns:** <code>any</code>

**Since:** 1.0.0

--------------------


### setOutputPower()

```typescript
setOutputPower() => any
```

Sets RFID UHF output power.

**Returns:** <code>any</code>

**Since:** 1.0.0

--------------------


### scanBarcode()

```typescript
scanBarcode() => any
```

Starts scanning barcode with 1D Scanner.

**Returns:** <code>any</code>

**Since:** 1.0.0

--------------------

</docgen-api>
