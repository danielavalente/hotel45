define(function() {
    var internals = {};
    var externals = {};

/*
Change into rooms json.
*/
    externals.get = function(cb) {
        $.ajax({
            url: 'http://localhost:8085/api/customers/1',
            type: 'GET',
            dataType: 'json',
            success: function(results) {
                    data = { sprite: results.sprites.other['official-artwork'].front_default}
                    cb(null, data)
            },
            error: function(request, statusText, httpError) { cb(httpError || statusText)}
        });
    };

    return externals;
});