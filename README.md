# capacitor-native-phone

This plugin allows user to place a phone call

## Install

```bash
npm install capacitor-native-phone
npx cap sync
```

## API

<docgen-index>

* [`makeACall(...)`](#makeacall)
* [`checkPermission()`](#checkpermission)
* [`requestPermission()`](#requestpermission)
* [Interfaces](#interfaces)
* [Type Aliases](#type-aliases)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### makeACall(...)

```typescript
makeACall(options: PhoneOptions) => Promise<void>
```

| Param         | Type                                                  |
| ------------- | ----------------------------------------------------- |
| **`options`** | <code><a href="#phoneoptions">PhoneOptions</a></code> |

--------------------


### checkPermission()

```typescript
checkPermission() => Promise<PermissionStatus>
```

**Returns:** <code>Promise&lt;<a href="#permissionstatus">PermissionStatus</a>&gt;</code>

--------------------


### requestPermission()

```typescript
requestPermission() => Promise<PermissionStatus>
```

**Returns:** <code>Promise&lt;<a href="#permissionstatus">PermissionStatus</a>&gt;</code>

--------------------


### Interfaces


#### PhoneOptions

| Prop               | Type                |
| ------------------ | ------------------- |
| **`phone_number`** | <code>string</code> |


#### PermissionStatus

| Prop        | Type                                                        |
| ----------- | ----------------------------------------------------------- |
| **`phone`** | <code><a href="#permissionstate">PermissionState</a></code> |


### Type Aliases


#### PermissionState

<code>'prompt' | 'prompt-with-rationale' | 'granted' | 'denied'</code>

</docgen-api>
