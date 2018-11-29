$(document).ready(function () {

    let lock = false;

    let buttons = $(".smartbutton");

    buttons.each(function (index, element) {
        let deviceType = element.dataset.btntype;

        switch (deviceType) {
            case "1":

                $(this).on("click", function () {
                    let controlValue = {
                        "deviceId": element.dataset.btnid
                    };
                    sendAjax("/control/toggle", controlValue, deviceType, element);
                });
                break;

            case "2" :

                $(function () {
                    let progressbar = $(".progress.progress-template");
                    progressbar.slider({
                        range: "min",
                        value: 0,
                        min: 0,
                        max: 100,
                        slide: function (event, ui) {
                            event.stopPropagation();
                            let controlValue = {
                                "deviceId": this.parentElement.parentElement.dataset.btnid,
                                "dimmValue": ui.value
                            };

                            if (lock === false) {
                                lock = true;
                                sendAjax("/control/dimming/value", controlValue, deviceType, this.parentElement.parentElement);
                                setTimeout(function () {
                                    lock = false;
                                }, 40);
                            }
                        }
                    });
                });

                $(this).on("click", function () {
                    let controlValue = {
                        "deviceId": element.dataset.btnid
                    };
                    sendAjax("/control/dimming/toggle", controlValue, deviceType, element);
                });
                break;

        }
    });

    function sendAjax(url, data, deviceType, element) {
        $.ajax({
            url: appUri + url,
            data: JSON.stringify(data),
            contentType: "application/json",
            type: "post",
            dataType: "json"
        })
            .done(function (result) {
                if (deviceType == "1") onOffToggle(element, result);
                if (deviceType == "2") dimmingValue(element, result);
            })
            .fail(function () {
                console.log("brak odpowiedzi");
            });
    }

    function onOffToggle(element, result, updated) {
        if (typeof updated === "string")
            element.querySelector(".updated").innerText = updated;
        if (result) {
            element.firstElementChild.style.backgroundColor = "dimgray";
            element.querySelector(".number").innerText = "On";
        } else {
            element.firstElementChild.style.backgroundColor = "#463f3f";
            element.querySelector(".number").innerText = "Off";
        }
    }

    function dimmingValue(element, result, updated) {
        if (typeof updated === "string")
            element.querySelector(".updated").innerText = updated;
        if (typeof result === "boolean") {
            if (result)
                dimmingSetOn(element, "100");
            else
                dimmingSetOff(element);
        } else {
            if (result > 0)
                dimmingSetOn(element, result);
            else
                dimmingSetOff(element);
        }
    }

    function dimmingSetOn(element, value) {
        element.firstElementChild.style.backgroundColor = "dimgray";
        element.querySelector(".number").innerText = value + "%";
        element.querySelector(".ui-slider-range").style.width = value + "%";
        element.querySelector(".ui-slider-handle").style.left = value + "%";
    }

    function dimmingSetOff(element) {
        element.firstElementChild.style.backgroundColor = "#463f3f";
        element.querySelector(".number").innerText = "Off";
        element.querySelector(".ui-slider-range").style.width = "0%";
        element.querySelector(".ui-slider-handle").style.left = "0%";
    }

    setInterval(function () {
        if (!lock) {
            $.ajax({
                url: appUri + "/control/getall",
                contentType: "application/json",
                type: "post",
                dataType: "json"
            })
                .done(function (result) {
                    result.forEach(function (element) {
                        buttons.each(function (index, button) {
                            let lastUpdateTime = "" + element.updated.hour + ":" + element.updated.minute + ":" + element.updated.second;
                            if (button.dataset.btntype == element.type && button.dataset.btnid == element.id)
                                switch (element.type) {
                                    case 1:
                                        onOffToggle(button, element.value, lastUpdateTime);
                                        return;
                                    case 2:
                                        dimmingValue(button, element.dimmingValue, lastUpdateTime);
                                        return;

                                }
                        });
                    });
                })
                .fail(function () {
                    console.log("brak odpowiedzi");
                });
        }
    }, 1000)

});