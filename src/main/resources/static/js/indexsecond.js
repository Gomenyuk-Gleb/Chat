$(document).ready(function () {
    $.getJSON('/indexsecond', function (data) {
        $('#name').text(data.name);
    });
    setInterval(loadData(), 1000);
});
function loadData() {
    $("#data > tbody").empty();
    $.getJSON('/message', function (data) {
        console.log(data.length)
        var i;
        for (i = 0; i < data.length; i++) {
            console.log(data.length)
            $('#data > tbody:last-child').append(
                $('<tr>')
                    .append($('<td>').append(data[i].userEntities))
                    .append($('<td>').append(data[i].stringBuilder))
            );
        }
    });

};