const chars = {

'1': 'e',

'8': 'r',

'11': '!',

'4': 'o',

'0': 'H',

'10': 'd',

'6': 'W',

'9': 'l',

'2': 'l',

'7': 'o',

'3': 'l',

length: 12

}

let msg = ''

for(let i = 0; i < chars.length; i++) {

if (chars[i])

msg = msg + chars[i]

else

msg = msg + ' '

}

console.log(msg)
