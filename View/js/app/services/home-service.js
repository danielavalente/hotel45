define(function() {
    var internals = {};
    var externals = {};

/*
This service must be changed into some kind of validation trigger. 
Get response from back end, if accepted then allow user to proceed.
*/
    externals.get = function(cb) {
        $.support.cors = true;
        $.ajax({
            url: 'http://localhost:8085/api/customers/1',
            type: 'GET',
            dataType: 'json',
            success: function(results) {
                    //data = { sprite: results.sprites.other['official-artwork'].front_default}
                    cb(null)
            },
            error: function(request, statusText, httpError) { cb(httpError || statusText)}
        });
    };

    return externals;
});