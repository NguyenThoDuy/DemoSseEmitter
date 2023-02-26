

// data list table sort
$('#data-list-table').DataTable({
    searching: false, paging: false, info: false,
    "order": [],
    "language": {
        "emptyTable": "[[#{f000.common.empty-table}]]"
    },
    "columnDefs": [
        {
            "orderDataType": "dom-text",
            "targets": 5,
            "type": "num"
        }
    ]
});

//confirm-checked-radio-box
function searchByCheckBox() {
    let confirmSearch = "編集中のデータが破棄されますがよろしいですか？"
    if (isExist == true){
        if (confirm(confirmSearch) == true) {
            let inputSearchSeason = $('#inputSearchSeason').val();

            let data = [
                {
                    key: 'seasonId',
                    value: inputSearchSeason
                }
            ]
            reloadMultipleParam(data, true);
        }
        else return false;
    }
    else {
        let inputSearchSeason = $('#inputSearchSeason').val();

        let data = [
            {
                key: 'seasonId',
                value: inputSearchSeason
            }
        ]
        reloadMultipleParam(data, true);
    }
}



$(document).ready(function () {
    let datasCheckbox = [];
    let seasonId = $('#inputSearchSeason option:selected').val();
    let shipCode = $('#inputRegisterShipCode option:selected').val();


    $(".btn-submit").click(function () {
        let countClick = 0;
        if ($('.cbCheck:checkbox:checked')) {
            $('.cbCheck:checkbox:checked').each(function () {
                countClick++;
            });
        }
        if (countClick == 0) {
            alert('登録対象のデータがありません。');
        } else {
            var proceed = confirm("画面の内容で登録しますか？");
            if (proceed) {
                registSubmit()
            }
        }
    });


    // regist
    // $("#regist-confirm-yes").click(function () {
        function registSubmit() {

        if ($('.cbCheck:checkbox:checked')) {
            $('.cbCheck:checkbox:checked').each(function () {
                datasCheckbox.push($(this).val());
            });
        }


        // PREPARE FORM DATA
        var formData = {
            seasonId: seasonId,
            checkbox: datasCheckbox,
            shipCode: shipCode
        }

        if (datasCheckbox.length > 0) {
            $.ajax({
                url: "/f110_regist_ship_to/register",
                type: 'POST',
                contentType: "application/json",
                data: JSON.stringify(formData),
                dataType: 'json',
                xhrFields: {
                    withCredentials: true
                },
                success: function (data) {
                    var exportExcel = confirm("登録しました");
                    if (exportExcel) {
                        excelExport();
                    }
                }
            });
        }
    }



    //export confirm
        function excelExport() {
        //Set the File URL.
            $( "#export-excel-f110" ).submit();
        }

});


