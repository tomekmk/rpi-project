$(document).ready(function () {

    let button = $(".smartbutton");

    button.each(function (index, element) {

        console.log("loaded " + index);

        if (element.dataset.btntype == "1") {
            $(this).on("click", function () {

                let controlValue = {
                    "type": "1",
                    "deviceId": element.dataset.btnid,
                    "value": true
                };

                $.ajax({
                    url: "http://localhost:8080/control/onoff",
                    data: JSON.stringify(controlValue),
                    contentType: "application/json",
                    type: "post",
                    dataType: "json"
                })
                    .done(function (result) {
                        console.log("odpowiedź")
                    })
                    .fail(function () {
                        console.log("brak odpowiedzi")
                    });
            });
        }

    });

});