module.exports = {
    purge: [],
    darkMode: 'media',
    theme: {
        extend: {}
    },
    variants:{
        extend: {
                backgroundColor: ['responsive', 'hover', 'focus', 'active'],
                textColor: 'active',
            }
    },
    plugins: [],
}