requirejs.config({
    baseUrl:'/js/app'
});

requirejs(['main'], function() {
    console.log('All modules loaded.   #1');
})