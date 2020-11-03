$(document).ready(function () {
    $.getJSON('/indexfirst', function (data) {
        $('#name').text(data.name);
        console.log(data.name)
    });
    setInterval(loadData(), 1000);
});

function loadData() {
    $("#data > tbody").empty();
    $.getJSON('/message', function (data) {
        console.log(data.length)
        var i;
        for (i = 0; i < data.length; i++) {
            let t = data[i].text
            let u = data[i].userEntities
            let key = u.substr(1, 4)

            console.log(code.decryptMessage(t, key))
            if (u == 'second') {
                $('#data > tbody:last-child').append(
                    $('<tr>')
                        .append($('<td>').append(data[i].userEntities))
                        .append($('<td>').append(code.decryptMessage(t, key)))
                );
            } else {
                $('#data > tbody:last-child').append(
                    $('<tr>')
                        .append($('<td>').append(data[i].userEntities))
                        .append($('<td>').append(code.decryptMessage(t, key)))
                );
            }
        }
    });
}

let code = (function () {
    return {
        decryptMessage: function (encryptedMessage = '', secretkey = '') {
            var decryptedBytes = CryptoJS.AES.decrypt(encryptedMessage, secretkey);
            var decryptedMessage = decryptedBytes.toString(CryptoJS.enc.Utf8);
            return decryptedMessage;
        }
    }
})();

